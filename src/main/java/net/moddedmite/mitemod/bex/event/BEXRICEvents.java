package net.moddedmite.mitemod.bex.event;

import moddedmite.rustedironcore.api.event.Handlers;
import moddedmite.rustedironcore.api.event.events.BiomeDecorationRegisterEvent;
import moddedmite.rustedironcore.api.event.listener.IArrowRegisterListener;
import moddedmite.rustedironcore.api.event.listener.IBeaconUpdateHandler;
import moddedmite.rustedironcore.api.event.listener.IBiomeGenerateListener;
import moddedmite.rustedironcore.api.event.listener.IEnchantingListener;
import moddedmite.rustedironcore.property.ItemProperties;
import moddedmite.rustedironcore.property.MaterialProperties;
import net.minecraft.BiomeGenBase;
import net.minecraft.Item;
import net.minecraft.ItemStack;
import net.minecraft.Material;
import net.minecraft.TileEntityBeacon;
import net.moddedmite.mitemod.bex.event.listener.*;
import net.moddedmite.mitemod.bex.register.BEXBlocks;
import net.moddedmite.mitemod.bex.register.BEXItems;
import net.moddedmite.mitemod.bex.register.BEXMaterials;
import net.moddedmite.mitemod.bex.world.BiomeVolcano;
import net.xiaoyu233.fml.reload.utils.IdUtil;
import net.xiaoyu233.mitemod.miteite.block.MITEITEBlockRegistryInit;
import net.xiaoyu233.mitemod.miteite.events.listener.CraftingRegistry;
import net.xiaoyu233.mitemod.miteite.item.MITEITEItemRegistryInit;
import net.xiaoyu233.mitemod.miteite.item.material.Materials;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class BEXRICEvents extends Handlers {
    public static void register() {
        LootTable.register(new BEXLootTable());
        SpawnCondition.register(new BEXSpawnCondition());
        Crafting.register(new BEXCraftingRegistry());
        Combat.register(new BEXCombatListener());
        Achievement.register(new BEXAchievementListener());
        ArmorModel.register(new BEXArmorModelListener());
        Enchanting.register(new IEnchantingListener() {
            public int onMaxEnchantNumModify(Random random, ItemStack item_stack, int enchantment_levels, int original) {
                return item_stack.getItem().getHardestMetalMaterial() == BEXMaterials.enchant ? original + 3 : original;
            }
        });
        BeaconUpdate.register(new IBeaconUpdateHandler() {
            public boolean onBlockValidModify(TileEntityBeacon tileEntityBeacon, int blockID, boolean original) {
                return original || blockID == BEXBlocks.blockInfinity.blockID;
            }

            public boolean onItemValidModify(TileEntityBeacon tileEntityBeacon, ItemStack itemStack, boolean original) {
                return original || itemStack.getItem() == BEXItems.infinityingot;
            }
        });
        ArrowRegister.register(new IArrowRegisterListener() {
            @Override
            public void onRegister(Consumer<Material> registry) {
                registry.accept(Materials.vibranium);
            }
        });
        PropertiesRegistry.register(() -> {
            ItemProperties.HeatLevelRequired.register(BEXItems.enchantSRC, 2);
            MaterialProperties.RepairItem.register(BEXMaterials.infinity, BEXItems.infinityNugget);
            MaterialProperties.RepairItem.register(BEXMaterials.enchant, BEXItems.enchantNugget);
        });
        BiomeGenerate.register(new IBiomeGenerateListener() {
            @Override
            public void onInitialBiomesModify(List<BiomeGenBase> list) {
                BiomeVolcano volcano = new BiomeVolcano(IdUtil.getNextBiomeId());
                list.add(volcano);
            }
        });
    }
}
