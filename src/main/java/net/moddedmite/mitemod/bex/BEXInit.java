package net.moddedmite.mitemod.bex;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.moddedmite.mitemod.bex.event.BEXEventListeners;
import net.moddedmite.mitemod.bex.util.BEXConfigs;
import net.moddedmite.mitemod.bex.world.BiomeVolcano;
import net.xiaoyu233.fml.FishModLoader;
import net.xiaoyu233.fml.ModResourceManager;
import net.xiaoyu233.fml.reload.utils.IdUtil;

public class BEXInit implements ModInitializer {
    public static String BEXNameSpace = "Beyond Extreme";
    public static String BEXModId = "bex";
    public static String BEXResourceId = "bex:";
    public static final String BEXVersion = FishModLoader.getModContainer(BEXModId).map(ModContainer::getMetadata).map(ModMetadata::getVersion).map(Version::getFriendlyString).orElse("v?.?.?");

    @Override
    public void onInitialize() {
        BEXEventListeners.registerAllEvents();
        BEXConfigs.loadConfigs();
        ModResourceManager.addResourcePackDomain(BEXModId);
    }
}
