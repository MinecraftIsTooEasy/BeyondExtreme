package net.moddedmite.mitemod.bex;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.minecraft.EnumQuality;
import net.moddedmite.mitemod.bex.util.BEXConfigs;
import net.xiaoyu233.fml.util.EnumExtends;

public class BEXEarlyRiser implements PreLaunchEntrypoint {
    @Override
    public void onPreLaunch() {
        EnumExtends.EQUIPMENT_MATERIAL.addEnum("infinity", () -> new Object[]{64800.0f, 0, EnumQuality.legendary, "infinity"});
        EnumExtends.EQUIPMENT_MATERIAL.addEnum("enchant", () -> new Object[]{256.0f, 1024, EnumQuality.legendary, "enchant"});
    }
}
