package net.moddedmite.mitemod.bex.compat;

import cn.wensc.mitemod.extreme.entity.EntityExchanger;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaEntityAccessor;
import mcp.mobius.waila.api.IWailaEntityProvider;
import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.IWailaRegistrar;
import mcp.mobius.waila.cbcore.LangUtil;
import net.minecraft.Entity;
import net.minecraft.EnumChatFormatting;
import net.minecraft.NBTTagCompound;
import net.minecraft.ServerPlayer;
import net.minecraft.World;
import net.moddedmite.mitemod.bex.api.IBEXEvasions;
import net.moddedmite.mitemod.bex.entity.EntitySkeletonBoss;
import net.moddedmite.mitemod.bex.entity.EntitySkeletonShadow;
import net.moddedmite.mitemod.bex.entity.EntityUltimateAnnihilationSkeleton;

import java.util.List;

public final class BEXWailaPlugin implements IWailaPlugin {

    @Override
    public void register(IWailaRegistrar registrar) {
        IWailaEntityProvider provider = new EvasionDataProvider();

        registrar.registerBodyProvider(provider, EntityExchanger.class);
        registrar.registerNBTProvider(provider, EntityExchanger.class);

        registrar.registerBodyProvider(provider, EntitySkeletonBoss.class);
        registrar.registerNBTProvider(provider, EntitySkeletonBoss.class);

        registrar.registerBodyProvider(provider, EntitySkeletonShadow.class);
        registrar.registerNBTProvider(provider, EntitySkeletonShadow.class);

        registrar.registerBodyProvider(provider, EntityUltimateAnnihilationSkeleton.class);
        registrar.registerNBTProvider(provider, EntityUltimateAnnihilationSkeleton.class);
    }

    private static final class EvasionDataProvider implements IWailaEntityProvider {

        private static final String EVASIONS_KEY = "WailaNumEvasions";

        @Override
        public Entity getWailaOverride(IWailaEntityAccessor accessor, IWailaConfigHandler config) {
            return null;
        }

        @Override
        public List<String> getWailaHead(Entity entity, List<String> currenttip, IWailaEntityAccessor accessor, IWailaConfigHandler config) {
            return currenttip;
        }

        @Override
        public List<String> getWailaBody(Entity entity, List<String> currenttip, IWailaEntityAccessor accessor, IWailaConfigHandler config) {
            if (!config.getConfig("option.general.showphaseevasions", true)) return currenttip;

            NBTTagCompound tag = accessor.getNBTData();
            if (tag != null && tag.hasKey(EVASIONS_KEY)) {
                int evasions = tag.getInteger(EVASIONS_KEY);
                if (evasions >= 0)
                    currenttip.add(EnumChatFormatting.GRAY + LangUtil.translateG("hud.msg.phase_evasions", evasions));
            }
            return currenttip;
        }

        @Override
        public List<String> getWailaTail(Entity entity, List<String> currenttip, IWailaEntityAccessor accessor, IWailaConfigHandler config) {
            return currenttip;
        }

        @Override
        public NBTTagCompound getNBTData(ServerPlayer player, Entity entity, NBTTagCompound tag, World world) {
            int evasions = getNumEvasions(entity);
            if (evasions >= 0) tag.setInteger(EVASIONS_KEY, evasions);
            return tag;
        }

        private static int getNumEvasions(Entity entity) {
            if (entity instanceof EntitySkeletonBoss boss) return boss.getNumEvasions();
            if (entity instanceof EntitySkeletonShadow shadow) return shadow.getNumEvasions();
            if (entity instanceof EntityUltimateAnnihilationSkeleton ultimate) return ultimate.getNumEvasions();
            if (entity instanceof IBEXEvasions exchanger) return exchanger.bex$getNumEvasions();
            return -1;
        }
    }
}
