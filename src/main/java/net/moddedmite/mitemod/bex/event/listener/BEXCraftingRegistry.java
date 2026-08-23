package net.moddedmite.mitemod.bex.event.listener;

import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;
import net.minecraft.ItemStack;
import net.moddedmite.mitemod.bex.register.BEXBlocks;
import net.moddedmite.mitemod.bex.register.BEXItems;
import net.xiaoyu233.mitemod.miteite.item.MITEITEItemRegistryInit;

import java.util.function.Consumer;

public class BEXCraftingRegistry implements Consumer<CraftingRecipeRegisterEvent> {
    @Override
    public void accept(CraftingRecipeRegisterEvent event) {
        event.getShaped().removeIf(recipe -> {
            ItemStack result = recipe.result;
            if (result.getItem() == MITEITEItemRegistryInit.VIBRANIUM_BOW) {
                return true;
            }
            return false;
        });
        BEXItems.registerRecipes(event);
        BEXBlocks.registerRecipes(event);
    }
}
