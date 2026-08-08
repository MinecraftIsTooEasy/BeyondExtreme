package net.moddedmite.mitemod.bex.register;

import net.minecraft.Material;
import net.moddedmite.mitemod.bex.item.material.BEXEnumEquipmentMaterials;
import net.moddedmite.mitemod.bex.item.material.MaterialEnchant;
import net.moddedmite.mitemod.bex.item.material.MaterialInfinity;

public class BEXMaterials extends Material {

    public static final Material infinity = new MaterialInfinity(BEXEnumEquipmentMaterials.infinity);
    public static final Material enchant = new MaterialEnchant(BEXEnumEquipmentMaterials.enchant);

    public BEXMaterials(String name) {
        super(name);
    }
}