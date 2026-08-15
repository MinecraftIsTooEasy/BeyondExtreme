package net.moddedmite.mitemod.bex.mixin.common.container;

import net.minecraft.*;
import net.moddedmite.mitemod.bex.register.BEXMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value = ContainerEnchantment.class, priority = 2000)
public abstract class ContainerEnchantmentMixin extends Container {
    @Shadow private int posX;
    @Shadow private int posY;
    @Shadow private int posZ;

    public ContainerEnchantmentMixin(EntityPlayer player) {
        super(player);
    }

//    @Inject(method = "calcEnchantmentLevelsForSlot", at = @At("HEAD"), cancellable = true)
//    private void onCalcEnchantmentLevelsForSlot(Random random, int slot_index, int num_accessible_bookshelves, ItemStack item_stack, CallbackInfoReturnable<Integer> cir) {
//        Item item = item_stack.getItem();
//
//        if (item.getHardestMetalMaterial() == BEXMaterials.enchant) {
//            int result = this.modifiedCalcEnchantmentLevels(random, slot_index, num_accessible_bookshelves, item_stack);
//            cir.setReturnValue(result);
//        }
//    }

    @ModifyConstant(method = "calcEnchantmentLevelsForSlot", constant = @Constant(intValue = 24), allow = 2)
    private int removeBookshelfCap(int original) {
        return Integer.MAX_VALUE;
    }

//    @Unique
//    private int modifiedCalcEnchantmentLevels(Random random, int slot_index, int num_accessible_bookshelves, ItemStack item_stack) {
//        Item item = item_stack.getItem();
//
//        if (!ItemPotion.isBottleOfWater(item_stack) && !ItemAppleGold.isUnenchantedGoldenApple(item_stack)) {
//            if (item.getItemEnchantability() <= 0) {
//                return 0;
//            } else {
//                Block enchantment_table_block = this.world.getBlock(this.posX, this.posY, this.posZ);
//
//                int enchantment_table_power = (1 + num_accessible_bookshelves) * (enchantment_table_block == Block.enchantmentTableEmerald ? 2 : 4);
//                int enchantment_levels = EnchantmentHelper.getEnchantmentLevelsAlteredByItemEnchantability(enchantment_table_power, item);
//                float fraction = (1.0F + (float) slot_index) / 3.0F;
//
//                if (slot_index < 2) {
//                    fraction += (random.nextFloat() - 0.5F) * 0.2F;
//                }
//
//                return Math.max(Math.round((float) enchantment_levels * fraction), 1);
//            }
//        } else {
//            return 2;
//        }
//    }
}
