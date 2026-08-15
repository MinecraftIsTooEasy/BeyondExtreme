package net.moddedmite.mitemod.bex.entity;

import net.minecraft.*;
import net.moddedmite.mitemod.bex.register.BEXItems;
import net.xiaoyu233.mitemod.miteite.util.Configs;

import java.util.Iterator;
import java.util.List;

public class EntitySpiderQueen extends EntityArachnid {
    private final int num_webs;

    public EntitySpiderQueen(World par1World) {
        super(par1World, 1.45F);
        this.num_webs = 4;
    }

    protected String getLivingSound() {
        return "imported.mob.demonspider.say";
    }

    protected String getHurtSound() {
        return "imported.mob.demonspider.hurt";
    }

    protected String getDeathSound() {
        return "imported.mob.demonspider.death";
    }

    protected float getSoundVolume(String sound) {
        return super.getSoundVolume(sound) * 1.3F;
    }

    protected float getSoundPitch(String sound) {
        return super.getSoundPitch(sound) * 0.6F;
    }

    public boolean peacefulDuringDay() {
        return false;
    }

    @Override
    public boolean getCanSpawnHere(boolean perform_light_check) {
        return super.getCanSpawnHere(perform_light_check) && this.worldObj.getDayOfOverworld() >= 10;
    }

    protected void applyEntityAttributes() {
        int day = Math.min(Configs.Entities.ENHANCE_LIMIT.get(), this.getWorld() != null ? this.getWorld().getDayOfOverworld() : 0);
        super.applyEntityAttributes();
        this.setEntityAttribute(SharedMonsterAttributes.maxHealth, 60.0 + (double) day / 3.0);
        this.setEntityAttribute(SharedMonsterAttributes.followRange, 96.0);
        this.setEntityAttribute(SharedMonsterAttributes.attackDamage, 15.0 + (double) day / 6.0);
        this.setEntityAttribute(SharedMonsterAttributes.movementSpeed, 0.92);
    }

    public EntityDamageResult attackEntityAsMob(Entity target) {
        EntityDamageResult result = super.attackEntityAsMob(target);
        if (result != null && !result.entityWasDestroyed()) {
            if (result.entityLostHealth() && target instanceof EntityLiving) {
                target.getAsEntityLivingBase().addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 200, 5));
                target.getAsEntityLivingBase().addPotionEffect(new PotionEffect(Potion.poison.id, 850, 0));
            }

            return result;
        } else {
            return result;
        }
    }

    private int spawnCounter;
    private int spawnSums;

    public void onUpdate() {
        super.onUpdate();
        if (!this.getWorld().isRemote) {
            List nearby_spiders = this.worldObj.getEntitiesWithinAABB(EntityArachnid.class, this.boundingBox.expand(16.0, 8.0, 16.0));
            Iterator i = nearby_spiders.iterator();
            if (this.getTicksExistedWithOffset() % 100 == 0) {
                while (i.hasNext()) {
                    EntityArachnid spiders = (EntityArachnid) i.next();
                    if (spiders == this) continue;
                    spiders.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 200, 0));
                }
            }
        }
        if (!getWorld().isRemote) {
            EntityLivingBase target = this.getAttackTarget();

                if (spawnSums < 8)
                    if (spawnCounter < 20) {
                        ++this.spawnCounter;
                    } else {
                        EntityBlackWidowSpider widowspider = new EntityBlackWidowSpider(worldObj);
                        widowspider.setPosition(posX + this.rand.nextInt(8) - this.rand.nextInt(8), posY, posZ - this.rand.nextInt(8) + this.rand.nextInt(8));
                        widowspider.refreshDespawnCounter(-9600);
                        worldObj.spawnEntityInWorld(widowspider);
                        widowspider.onSpawnWithEgg(null);
                        widowspider.entityFX(EnumEntityFX.summoned);
                        widowspider.setAttackTarget(this.getTarget());
                        spawnCounter = 0;
                        spawnSums++;
            }
        }

    }
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
        int day = this.worldObj.getDayOfWorld();
        Entity player = damageSource.getResponsibleEntity();
        if (player instanceof EntityPlayer) {
            int count = Math.min(3,1 + day / 48);
            for (int i = 0; i < count; ++i) {
                this.dropItem(Item.diamond);
            }
            this.dropItem(BEXItems.voucherSpiderQueen);
            this.dropItem(BEXItems.spiderQueenSilk);
        }
    }

    public int getExperienceValue() {
        return super.getExperienceValue() * 6;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 1;
    }

}
