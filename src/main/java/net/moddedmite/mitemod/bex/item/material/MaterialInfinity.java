package net.moddedmite.mitemod.bex.item.material;

import cn.wensc.mitemod.extreme.util.EXConfigs;
import huix.glacier.api.extension.material.*;
import net.minecraft.EnumEquipmentMaterial;
import net.minecraft.Item;
import net.minecraft.Material;
import net.moddedmite.mitemod.bex.register.BEXItems;
import net.moddedmite.mitemod.bex.util.BEXConfigs;
import net.xiaoyu233.mitemod.miteite.item.MITEITEItemRegistryInit;

public class MaterialInfinity extends Material implements IArmorMaterial, IRepairableMaterial, IToolMaterial {

    public MaterialInfinity(EnumEquipmentMaterial enum_crafting_material) {
        super(enum_crafting_material);
        this.setMetal(false).setHarmedByLava(false).setMinHarvestLevel(32767);
    }

    @Override
    public float getDamageVsEntity() {
        return 32.0F;
    }

    @Override
    public int getProtection() {
        return 100000000;
    }

    @Override
    public Item getRepairItem() {
        return BEXItems.infinityNugget;
    }

    @Override
    public float getHarvestEfficiency() {
        return 256.0F;
    }
}
