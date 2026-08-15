package net.moddedmite.mitemod.bex.mixin.common.item.enchantment;

import cn.wensc.mitemod.extreme.item.ItemClubMetal;
import net.minecraft.*;
import net.moddedmite.mitemod.bex.register.BEXMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentDamage.class)
public abstract class EnchantmentDamageMixin extends Enchantment {
   protected EnchantmentDamageMixin(int id, EnumRarity rarity, int difficulty) {
      super(id, rarity, difficulty);
   }

   @Inject(method = "canEnchantItem", at = @At("HEAD"), cancellable = true)
   public void injectVibraniumCheck(Item item, CallbackInfoReturnable<Boolean> cir) {
      if (this == Enchantment.smite && item.getHardestMetalMaterial() == BEXMaterials.enchant && (item instanceof ItemSword || item instanceof ItemClubMetal)) {
         cir.setReturnValue(true);
      }
      if (this == Enchantment.smite && item instanceof ItemBattleAxe) {
         cir.setReturnValue(true);
      }
   }

//   @Inject(method = "canApplyTogether", at = @At("HEAD"), cancellable = true)
//   public void vibraniumTogether(Enchantment par1Enchantment, CallbackInfoReturnable<Boolean> cir) {
//      cir.setReturnValue(true);
//   }
}
