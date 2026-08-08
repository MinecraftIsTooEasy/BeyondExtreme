package net.moddedmite.mitemod.bex.event;

import com.google.common.eventbus.Subscribe;
import net.minecraft.*;
import net.moddedmite.mitemod.bex.BEXInit;
import net.moddedmite.mitemod.bex.entity.*;
import net.moddedmite.mitemod.bex.register.BEXAchievements;
import net.moddedmite.mitemod.bex.register.BEXBlocks;
import net.moddedmite.mitemod.bex.register.BEXEnchantments;
import net.moddedmite.mitemod.bex.register.BEXItems;
import net.moddedmite.mitemod.bex.render.entity.RenderBedrockElemental;
import net.moddedmite.mitemod.bex.render.entity.RenderSpiderQueen;
import net.xiaoyu233.fml.reload.event.*;
import net.xiaoyu233.fml.reload.utils.IdUtil;
import net.xiaoyu233.mitemod.miteite.MITEITEMod;
import net.xiaoyu233.mitemod.miteite.achievement.MITEITEAchievementRegistryInit;
import net.xiaoyu233.mitemod.miteite.block.MITEITEBlockRegistryInit;
import net.xiaoyu233.mitemod.miteite.entity.*;
import net.xiaoyu233.mitemod.miteite.item.MITEITEItemRegistryInit;
import net.xiaoyu233.mitemod.miteite.item.enchantment.MITEITEEnchantmentRegistryInit;
import net.xiaoyu233.mitemod.miteite.render.entity.RenderAncientDragon;
import net.xiaoyu233.mitemod.miteite.render.entity.RenderAnnihilationSkeleton;
import net.xiaoyu233.mitemod.miteite.render.entity.RenderWanderingWitch;

public class BEXFishEvents {

    @Subscribe
    public void handleChatCommand(HandleChatCommandEvent event) {
        String par2Str = event.getCommand();
        EntityPlayer player = event.getPlayer();
        if (Minecraft.inDevMode()) {
            if (par2Str.startsWith("fly")) {
                if (Minecraft.inDevMode()) {
                    player.capabilities.allowFlying = true;
                }
                event.setExecuteSuccess(true);
            }
        }
    }


    @Subscribe
    public void onItemRegister(ItemRegistryEvent event) {
        BEXItems.registerItems(event);
        BEXBlocks.registerBlocks(event);
    }

    @Subscribe
    public void onEnchantmentRegister(EnchantmentRegistryEvent event) {
        BEXEnchantments.registerEnchantments(event);
    }

    @Subscribe
    public void onAchievementRegister(AchievementRegistryEvent event) {
        BEXAchievements.registerAchievements();
    }

    @Subscribe
    public void onEntityRegister(EntityRegisterEvent event) {
        event.register(EntityZombieDoorLord .class, BEXInit.BEXNameSpace, "EntityZombieDoorLord", IdUtil.getNextEntityID(), 0, 0);
        event.register(EntityBedrockElemental .class, BEXInit.BEXNameSpace, "EntityBedrockElemental", IdUtil.getNextEntityID(), 0, 0);
        event.register(EntitySkeletonBoss .class, BEXInit.BEXNameSpace, "EntitySkeletonBoss", IdUtil.getNextEntityID(), 0, 0);
        event.register(EntitySkeletonShadow .class, BEXInit.BEXNameSpace, "EntitySkeletonShadow", IdUtil.getNextEntityID(), 0, 0);
        event.register(EntitySpiderQueen .class, BEXInit.BEXNameSpace, "EntitySpiderQueen", IdUtil.getNextEntityID(), 0, 0);
        event.register(EntityUltimateAnnihilationSkeleton.class, BEXInit.BEXNameSpace, "EntityUltimateAnnihilationSkeleton", IdUtil.getNextEntityID(), 0, 0);
        event.register(EntityZombieDoorWood.class, BEXInit.BEXNameSpace, "EntityZombieDoorWood", IdUtil.getNextEntityID(), 0, 0);
        event.register(EntityZombieDoorDeep.class, BEXInit.BEXNameSpace, "EntityZombieDoorDeep", IdUtil.getNextEntityID(), 0, 0);
        event.register(EntityZombieMiner.class, BEXInit.BEXNameSpace, "EntityZombieMiner", IdUtil.getNextEntityID(), 0, 0);
        event.register(EntityGhastLord.class, BEXInit.BEXNameSpace, "EntityGhastLord", IdUtil.getNextEntityID(), 0, 0);
    }

    @Subscribe
    public void onEntityRendererRegister(EntityRendererRegistryEvent event) {
        event.register(EntityUltimateAnnihilationSkeleton.class, new RenderAnnihilationSkeleton());
        event.register(EntityBedrockElemental.class, new RenderBedrockElemental());
        event.register(EntitySpiderQueen.class, new RenderSpiderQueen(1.45F));
    }

//    @Subscribe
//    public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
//        EntityPlayer par1EntityPlayerMP = event.getPlayer();
//        par1EntityPlayerMP.sendChatToPlayer(ChatMessageComponent.createFromTranslationKey("[BeyondExtreme]:")
//                .appendComponent(ChatMessageComponent.createFromTranslationKey("更新日志:https://docs.qq.com/doc/DZVhpUGtGcFRPa2ZV，赞助链接:https://afdian.com/a/xy_lose").setColor(EnumChatFormatting.WHITE)).appendComponent(ChatMessageComponent.createFromTranslationKey("感谢 ").setColor(EnumChatFormatting.RED)
//                        .appendComponent(ChatMessageComponent.createFromTranslationKey("，叶辉与mite-loneina").setColor(EnumChatFormatting.WHITE))
//                        .addText(" 对此项目的赞助").setColor(EnumChatFormatting.RED)));
//    }
}
