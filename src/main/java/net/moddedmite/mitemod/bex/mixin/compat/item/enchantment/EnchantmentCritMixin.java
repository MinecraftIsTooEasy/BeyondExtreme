package net.moddedmite.mitemod.bex.mixin.compat.item.enchantment;

import net.minecraft.Item;
import net.minecraft.ItemBattleAxe;
import net.xiaoyu233.mitemod.miteite.item.enchantment.EnchantmentCrit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentCrit.class)
public class EnchantmentCritMixin {
    @Inject(method = "canEnchantItem", at = @At("TAIL"), cancellable = true)
    public void battleAxeEnchantAdd(Item item, CallbackInfoReturnable<Boolean> cir) {
        if (item instanceof ItemBattleAxe) {
            cir.setReturnValue(true);
        }
    }
}
