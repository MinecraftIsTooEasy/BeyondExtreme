package net.moddedmite.mitemod.bex.entity;

import cn.wensc.mitemod.extreme.register.EXEnchantmentRegistryInit;
import net.minecraft.*;
import net.minecraft.server.MinecraftServer;
import net.moddedmite.mitemod.bex.register.BEXEnchantments;
import net.moddedmite.mitemod.bex.util.BEXConfigs;
import net.xiaoyu233.mitemod.miteite.api.ITEEnchantment;
import net.moddedmite.mitemod.bex.register.BEXItems;
import net.xiaoyu233.mitemod.miteite.item.MITEITEItemRegistryInit;
import net.xiaoyu233.mitemod.miteite.item.enchantment.MITEITEEnchantmentRegistryInit;

import java.util.*;

public class EntitySkeletonBoss extends EntitySkeleton implements IBossDisplayData {
    private int max_num_evasions;
    private int num_evasions;
    private int spawnCounter;
    ItemStack stowed_item_stack;
    public Map<String, Float> attackDamageMap = new HashMap<>();
    private Enchantment [] enhanceSpecialBookList = new Enchantment[] {Enchantment.protection, Enchantment.sharpness,  Enchantment.fortune, Enchantment.harvesting, MITEITEEnchantmentRegistryInit.EXTEND, Enchantment.efficiency, Enchantment.vampiric, Enchantment.butchering, Enchantment.featherFalling, BEXEnchantments.EnchantmentForge};
    private Enchantment [] nonLevelsBookList = new Enchantment[] {EXEnchantmentRegistryInit.enchantmentFixed, EXEnchantmentRegistryInit.enchantmentChain, MITEITEEnchantmentRegistryInit.EMERGENCY, BEXEnchantments.enchantmentRangeAttack, BEXEnchantments.enchantmentUnassailable};
    private boolean attack_mode = true;
    public void addRandomWeapon() {
        List items = new ArrayList();
        items.add(new RandomItemListEntry(MITEITEItemRegistryInit.VIBRANIUM_SWORD, 2));
        this.stowed_item_stack = (new ItemStack(Item.diamond)).randomizeForMob(this, true);
        RandomItemListEntry entry = (RandomItemListEntry) WeightedRandom.getRandomItem(this.rand, items);
        this.setHeldItemStack((new ItemStack(entry.item)).randomizeForMob(this, true));
        this.setSkeletonType(2);
    }
    public EntitySkeletonBoss(World par1World) {
        super(par1World);
        if (par1World != null && this.onServer()) {
            int rate = Math.min(200, worldObj.getDayOfOverworld()) / 10;
            this.max_num_evasions = this.num_evasions = 8 + rate * 2;
        }
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityPlayer.class, 9.0F, 1.1, 1.4));
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setByte("max_num_evasions", (byte)this.max_num_evasions);
        par1NBTTagCompound.setByte("num_evasions", (byte)this.num_evasions);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.max_num_evasions = par1NBTTagCompound.getByte("max_num_evasions");
        this.num_evasions = par1NBTTagCompound.getByte("num_evasions");
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        int rate = Math.min(200, worldObj.getDayOfOverworld()) / 10;
        this.setEntityAttribute(SharedMonsterAttributes.followRange, 128.0);
        this.setEntityAttribute(SharedMonsterAttributes.movementSpeed, 0.3);
        this.setEntityAttribute(SharedMonsterAttributes.attackDamage, 15d + BEXConfigs.bexConfig.skeletonBossBaseDamage.ConfigValue);
        this.setEntityAttribute(SharedMonsterAttributes.maxHealth, BEXConfigs.bexConfig.skeletonBossMaxHealth.ConfigValue + rate * 20);
    }
    protected void addRandomEquipment() {
        this.addRandomWeapon();
        this.setBoots((new ItemStack(MITEITEItemRegistryInit.VIBRANIUM_BOOTS)).randomizeForMob(this, true));
        this.setLeggings((new ItemStack(MITEITEItemRegistryInit.VIBRANIUM_LEGGINGS)).randomizeForMob(this, true));
        this.setCuirass((new ItemStack(MITEITEItemRegistryInit.VIBRANIUM_CHESTPLATE)).randomizeForMob(this, true));
        this.setHelmet((new ItemStack(MITEITEItemRegistryInit.VIBRANIUM_HELMET)).randomizeForMob(this, true));
    }

    public void onUpdate() {
        super.onUpdate();
        if(!getWorld().isRemote){
            spawnCounter++;
            if (spawnCounter > 300 && !attack_mode) {
                if(this.getTarget()!=null){
                    this.worldObj.playSoundEffect(this.getTarget().posX + 0.5, this.getTarget().posY + 0.5, this.getTarget().posZ + 0.5, "ambient.weather.thunder", 50.0F + this.rand.nextFloat(), 0.8F + this.rand.nextFloat() * 0.2F);
                    this.worldObj.playSoundEffect(this.getTarget().posX, this.getTarget().posY, this.getTarget().posZ, "random.explode", 2.0F, 0.5F + this.rand.nextFloat() * 0.2F);
                    this.worldObj.spawnParticle(EnumParticle.witchMagic, this.posX + (this.rand.nextDouble() - 0.5) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5) * (double) this.width, 0.0, 0.0, 0.0);
                    this.getTarget().attackEntityFrom(new Damage(DamageSource.divine_lightning, 10));
                }
                EntityLongdeadGuardian guardian = new EntityLongdeadGuardian(worldObj);
                guardian.setPosition(posX + this.rand.nextInt(8) - this.rand.nextInt(8), posY, posZ - this.rand.nextInt(8) + this.rand.nextInt(8));
                guardian.refreshDespawnCounter(-9600);
                worldObj.spawnEntityInWorld(guardian);
                guardian.onSpawnWithEgg(null);
                guardian.entityFX(EnumEntityFX.summoned);
                spawnCounter = 0;
            }
        }
    }
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.onServer() && this.getHealth() > 0.0F) {
            int ticks_existed_with_offset = this.getTicksExistedWithOffset();
            if (this.num_evasions < this.max_num_evasions && ticks_existed_with_offset % 600 == 0) {
                ++this.num_evasions;
            }

            if (this.hasPath() && (this.getTarget() != null || this.fleeing) && ticks_existed_with_offset % 10 == 0 && this.rand.nextInt(3) == 0) {
                PathEntity path = this.getPathToEntity();
                if (!path.isFinished()) {
                    int n = path.getNumRemainingPathPoints();
                    if (n > 1) {
                        int path_index_advancement = MathHelper.clamp_int(this.rand.nextInt(n), 1, 4);
                        PathPoint path_point = path.getPathPointFromCurrentIndex(path_index_advancement);
                        if ((double)path_point.distanceSqTo(this) > 3.0 && this.tryTeleportTo((double)path_point.xCoord + 0.5, (double)path_point.yCoord, (double)path_point.zCoord + 0.5)) {
                            path.setCurrentPathIndex(path.getCurrentPathIndex() + path_index_advancement - 1);
                        }
                    }
                }
            }
        }
        if (this.stowed_item_stack != null && (this.getHeldItemStack() == null || this.getTicksExistedWithOffset() % 10 == 0)) {
            if (this.getHeldItemStack() == null) {
                this.swapHeldItemStackWithStowed();
            } else {
                Entity target = this.getTarget();
                if (target != null && this.canSeeTarget(true)) {
                    double distance = (double)this.getDistanceToEntity(target);
                    if (this.getHeldItemStack().itemID == Item.diamond.itemID) {
                        if (distance < 5.0) {
                            this.swapHeldItemStackWithStowed();
                            attack_mode = true;
                        }
                    } else if (distance > 6.0) {
                        this.swapHeldItemStackWithStowed();
                        attack_mode = false;
                    }
                }
            }
        }
    }
    public boolean tryTeleportTo(double pos_x, double pos_y, double pos_z) {
        if (!this.isDead && !(this.getHealth() <= 0.0F)) {
            int x = MathHelper.floor_double(pos_x);
            int y = MathHelper.floor_double(pos_y);
            int z = MathHelper.floor_double(pos_z);
            if (y >= 1 && this.worldObj.blockExists(x, y, z)) {
                while(true) {
                    --y;
                    if (this.worldObj.isBlockSolid(x, y, z)) {
                        ++y;
                        if (!this.worldObj.isBlockSolid(x, y, z) && !this.worldObj.isLiquidBlock(x, y, z)) {
                            double delta_pos_x = pos_x - this.posX;
                            double delta_pos_y = pos_y - this.posY;
                            double delta_pos_z = pos_z - this.posZ;
                            AxisAlignedBB bb = this.boundingBox.translateCopy(delta_pos_x, delta_pos_y, delta_pos_z);
                            if (this.worldObj.getCollidingBoundingBoxes(this, bb).isEmpty() && !this.worldObj.isAnyLiquid(bb)) {
                                World var10000 = this.worldObj;
                                double distance = (double)World.getDistanceFromDeltas(delta_pos_x, delta_pos_y, delta_pos_z);
                                this.worldObj.blockFX(EnumBlockFX.particle_trail, x, y, z, (new SignalData()).setByte(EnumParticle.runegate.ordinal()).setShort((int)(16.0 * distance)).setApproxPosition((double)MathHelper.floor_double(this.posX), (double)MathHelper.floor_double(this.posY), (double)MathHelper.floor_double(this.posZ)));
                                this.worldObj.playSoundEffect(this.posX, this.posY, this.posZ, "mob.endermen.portal", 1.0F, 1.0F);
                                this.setPosition(pos_x, pos_y, pos_z);
                                this.send_position_update_immediately = true;
                                return true;
                            }

                            return false;
                        }

                        return false;
                    }

                    if (y < 1) {
                        return false;
                    }

                    --pos_y;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean tryTeleportAwayFrom(Entity entity, double min_distance) {
        if (!this.isDead && !(this.getHealth() <= 0.0F)) {
            double min_distance_sq = min_distance * min_distance;
            int x = this.getBlockPosX();
            int y = this.getFootBlockPosY();
            int z = this.getBlockPosZ();
            double threat_pos_x = entity == null ? this.posX : entity.posX;
            double threat_pos_z = entity == null ? this.posZ : entity.posZ;

            for(int attempts = 0; attempts < 64; ++attempts) {
                int dx = this.rand.nextInt(11) - 5;
                int dy = this.rand.nextInt(9) - 4;
                int dz = this.rand.nextInt(11) - 5;
                if (Math.abs(dx) >= 3 || Math.abs(dz) >= 3) {
                    int try_x = x + dx;
                    int try_y = y + dy;
                    int try_z = z + dz;
                    double try_pos_x = (double)try_x + 0.5;
                    double try_pos_z = (double)try_z + 0.5;
                    World var10000 = this.worldObj;
                    if (!(World.getDistanceSqFromDeltas(try_pos_x - threat_pos_x, try_pos_z - threat_pos_z) < min_distance_sq) && try_y >= 1 && this.worldObj.blockExists(try_x, try_y, try_z)) {
                        do {
                            --try_y;
                        } while(!this.worldObj.isBlockSolid(try_x, try_y, try_z) && try_y >= 1);

                        if (try_y >= 1) {
                            ++try_y;
                            if (!this.worldObj.isBlockSolid(try_x, try_y, try_z) && !this.worldObj.isLiquidBlock(try_x, try_y, try_z) && this.tryTeleportTo(try_pos_x, (double)try_y, try_pos_z)) {
                                EntityPlayer target = this.findPlayerToAttack(Math.min(this.getMaxTargettingRange(), 24.0F));
                                if (target != null && target != this.getTarget()) {
                                    this.setTarget(target);
                                }

                                return true;
                            }
                        }
                    }
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public EntityDamageResult attackEntityFrom(Damage damage) {
        boolean can_evade = !damage.isFallDamage() && !damage.isFireDamage() && !damage.isPoison();
        if (can_evade && this.num_evasions > 0) {
            --this.num_evasions;
            if (this.tryTeleportAwayFrom(this.getTarget(), 6.0)) {
                EntitySkeletonShadow shadow = new EntitySkeletonShadow(worldObj);
                shadow.setPosition(posX, posY, posZ);
                shadow.refreshDespawnCounter(-9600);
                worldObj.spawnEntityInWorld(shadow);
                shadow.onSpawnWithEgg(null);
                shadow.entityFX(EnumEntityFX.summoned);
                return null;
            }
        }
        return super.attackEntityFrom(damage);
    }

    public void swapHeldItemStackWithStowed() {
        ItemStack item_stack = this.stowed_item_stack;
        this.stowed_item_stack = this.getHeldItemStack();
        this.setHeldItemStack(item_stack);
    }
    public void getEnchantBookDependsOnDamageRate(EntityPlayer entityPlayer, int rate) {
        ItemStack var11 = null;
        Enchantment dropEnchantment = Enchantment.enchantmentsList[rand.nextInt(Enchantment.enchantmentsList.length)];
        if (dropEnchantment != null) {
            if (((ITEEnchantment) dropEnchantment).getNumLevelsForVibranium() > 1) {
                var11 = Item.enchantedBook.getEnchantedItemStack(new EnchantmentData(dropEnchantment, Math.min(rate, ((ITEEnchantment) dropEnchantment).getNumLevelsForVibranium())));
            } else {
                if(rate >= 7) {
                    var11 = Item.enchantedBook.getEnchantedItemStack(new EnchantmentData(dropEnchantment, 1));
                } else {
                    getEnchantBookDependsOnDamageRate(entityPlayer, rate);
                }
            }
        } else {
            getEnchantBookDependsOnDamageRate(entityPlayer, rate);
        }
        entityPlayer.inventory.addItemStackToInventoryOrDropIt(var11);
    }
    protected void dropFewItems(boolean recently_hit_by_player, DamageSource damage_source) {
        if (recently_hit_by_player){
            this.broadcastDamage("骷髅BOSS挑战成功");
            int day = this.worldObj.getDayOfWorld();
            this.dropItemStack(new ItemStack(Item.diamond, 10 + (int) (day / 10)));
            float percent = (float) nonLevelsBookList.length / ((float)enhanceSpecialBookList.length + (float) nonLevelsBookList.length);
            if(rand.nextFloat() < percent && rand.nextInt(5) == 0) {
                Enchantment dropEnchantment = nonLevelsBookList[rand.nextInt(nonLevelsBookList.length)];
                ItemStack var11 = Item.enchantedBook.getEnchantedItemStack(new EnchantmentData(dropEnchantment, ((ITEEnchantment) dropEnchantment).getNumLevelsForVibranium()));
                this.dropItemStack(var11);
                return;
            }
            Enchantment dropEnchantment = enhanceSpecialBookList[rand.nextInt(enhanceSpecialBookList.length)];
            ItemStack enchantBook = Item.enchantedBook.getEnchantedItemStack(new EnchantmentData(dropEnchantment, ((ITEEnchantment) dropEnchantment).getNumLevelsForVibranium()));
            this.dropItemStack(enchantBook);
            this.dropItemStack(new ItemStack(BEXItems.voucherSkeletonBoss, 1));
//            MinecraftServer server = MinecraftServer.F();
//            Iterator var4 = server.getConfigurationManager().playerEntityList.iterator();
//
//            while (var4.hasNext()) {
//                Object o = var4.next();
//                EntityPlayer player = (EntityPlayer)o;
//                if(attackDamageMap.containsKey(player.getEntityName()) && player != null) {
//                    player.triggerAchievement(Achievements.killZombieBoss);
//                    float damage = attackDamageMap.get(player.getEntityName());
//                    int nums = Math.round(damage) / 10;
//                    int damageWithEnchantBookRate = Math.round(damage) / 50;
//                    if(damageWithEnchantBookRate > 0) {
//                        this.getEnchantBookDependsOnDamageRate(player, damageWithEnchantBookRate);
//                    }
//                    if(nums > 0) {
//                        player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(Item.diamond, nums));
//                        player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(Items.voucherSkeletonBoss,1));
//                    }
//                }
//            }
        }
    }
    public int getExperienceValue() {
        return super.getExperienceValue() * 20;
    }
    public void broadcastDamage(String stateMessage) {
        MinecraftServer server = MinecraftServer.getServer();
        Iterator var4 = server.getConfigurationManager().playerEntityList.iterator();

        List<Map.Entry<String,Float>> list = new ArrayList<>(attackDamageMap.entrySet());
        Collections.sort(list, (e1, e2) -> (int) Math.floor(e2.getValue() - e1.getValue()));
        while(var4.hasNext()) {
            Object o = var4.next();
            EntityPlayer player = (EntityPlayer)o;
            for(int i = 0; i < Math.min(list.size(), 5); i++) {
                player.sendChatToPlayer(ChatMessageComponent.createFromText("--" + stateMessage + "-伤害排名--"));
                player.sendChatToPlayer(ChatMessageComponent.createFromText("第")
                        .appendComponent(ChatMessageComponent.createFromText("§6" + (i + 1)))
                        .appendComponent(ChatMessageComponent.createFromText("§r名: "))
                        .appendComponent(ChatMessageComponent.createFromText("§n" + list.get(i).getKey()))
                        .appendComponent(ChatMessageComponent.createFromText("§r - "))
                        .appendComponent(ChatMessageComponent.createFromText("§b" + String.format("%.2f", list.get(i).getValue())))
                        .appendComponent(ChatMessageComponent.createFromText("§r点伤害")));
            }
        }
    }
    @Override
    public void dropContainedItems() {

    }

    @Override
    protected void dropEquipment(boolean recently_hit_by_player, int par2) {

    }
}
