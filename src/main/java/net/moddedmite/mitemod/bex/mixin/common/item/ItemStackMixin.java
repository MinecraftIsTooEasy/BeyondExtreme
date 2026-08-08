package net.moddedmite.mitemod.bex.mixin.common.item;

import net.minecraft.*;
import net.moddedmite.mitemod.bex.register.BEXItems;
import net.moddedmite.mitemod.bex.register.BEXMaterials;
import net.moddedmite.mitemod.bex.util.ColorText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
   @Shadow public int itemID;

   @Shadow public abstract Item getItem();

   @Shadow public abstract boolean hasMaterial(Material material);

   @Inject(method = "getTooltip", at = @At("RETURN"))
   public void InjectGetTooltip(EntityPlayer par1EntityPlayer, boolean par2, Slot slot, CallbackInfoReturnable<ArrayList> callbackInfoReturnable) {
      List<String> list = callbackInfoReturnable.getReturnValue();
      if (this.getItem() == BEXItems.infinityingot) {
         list.add(ColorText.makeColors("汝掌心中者，寰宇之力也"));
      }
   }
   
   @Inject(method = "tryDamageItem(Lnet/minecraft/World;IZ)Lnet/minecraft/ItemDamageResult;", at = @At("HEAD"), cancellable = true)
   private void preventDurabilityDamage(World world, int damage, boolean prevent_destruction, CallbackInfoReturnable<ItemDamageResult> cir) {
      if (this.hasMaterial(BEXMaterials.infinity)) {
         cir.setReturnValue(null);
      }
   }
}
