package net.moddedmite.mitemod.bex.register;

import cn.wensc.mitemod.extreme.item.ItemClubMetal;
import cn.wensc.mitemod.extreme.item.ItemDynamicCore;
import cn.wensc.mitemod.extreme.item.ItemMobVoucher;
import cn.wensc.mitemod.extreme.register.EXItemsRegistryInit;
import cn.wensc.mitemod.extreme.util.EXConfigs;
import moddedmite.rustedironcore.api.event.events.CraftingRecipeRegisterEvent;
import net.minecraft.*;
import net.moddedmite.mitemod.bex.BEXInit;
import net.moddedmite.mitemod.bex.item.*;
import net.moddedmite.mitemod.bex.item.ItemFinalFood;
import net.xiaoyu233.fml.reload.event.ItemRegistryEvent;
import net.xiaoyu233.fml.util.ReflectHelper;
import net.xiaoyu233.mitemod.miteite.block.MITEITEBlockRegistryInit;
import net.xiaoyu233.mitemod.miteite.item.MITEITEItemRegistryInit;
import net.xiaoyu233.mitemod.miteite.item.material.Materials;
import net.xiaoyu233.mitemod.miteite.util.Constant;

public class BEXItems {
    public static final CreativeTabs tabBEX = new CreativeTabBEX();

    public static final Item voucherZombieBoss = new ItemBEXMobVoucher(Constant.getNextItemID(), "zombieboss");
    public static final Item voucherGhast = new ItemBEXMobVoucher(Constant.getNextItemID(), "ghast");
    public static final Item voucherBedrock = new ItemBEXMobVoucher(Constant.getNextItemID(), "bedrock");
    public static final Item voucherVibraniumDoor = new ItemBEXMobVoucher(Constant.getNextItemID(), "vibraniumdoor");
    public static final Item voucherGoldBodyCore = new ItemBEXMobVoucher(Constant.getNextItemID(), "goldbody_core");
    public static final Item voucherSkeletonBoss = new ItemBEXMobVoucher(Constant.getNextItemID(), "skeletonboss");
    public static final Item voucherUltimateAnnihilation = new ItemBEXMobVoucher(Constant.getNextItemID(), "UltimateAnnihilation");
    public static final Item voucherSpiderQueen = new ItemBEXMobVoucher(Constant.getNextItemID(), "spiderqueen").setCreativeTab(tabBEX);
    public static final Item voucherZombieMiner = new ItemBEXMobVoucher(Constant.getNextItemID(), "zombieminer").setCreativeTab(tabBEX);

    public static ItemEndBook itemEndBook = (ItemEndBook)(new ItemEndBook(Constant.getNextItemID())).setUnlocalizedName("end_book");
    public static final Item spiderQueenSilk = new ItemSpiderQueenString(Constant.getNextItemID()).setCreativeTab(tabBEX);

    public static final Item infinityingot = ReflectHelper.createInstance(ItemIngot.class, new Class[]{Integer.TYPE, Material.class}, Constant.getNextItemID(), BEXMaterials.infinity).setCreativeTab(tabBEX);
    public static final ItemNugget infinityNugget = (ItemNugget) ReflectHelper.createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, Constant.getNextItemID(), BEXMaterials.infinity).setCreativeTab(tabBEX);
    public static final ItemInfinitySword infinitySword = new ItemInfinitySword(Constant.getNextItemID(), 0);
    public static final ItemInfinitySword ENDING = new ItemInfinitySword(Constant.getNextItemID(), 1);
    public static final ItemInfinityPickaxe infinityPickaxe = new ItemInfinityPickaxe(Constant.getNextItemID());
    public static final ItemInfinityArmor unassailableChestPlate = new ItemInfinityArmor(Constant.getNextItemID(), BEXMaterials.infinity,1,false);
    public static final ItemInfinityArmor unassailableHelmet = new ItemInfinityArmor(Constant.getNextItemID(), BEXMaterials.infinity, 0,false);
    public static final ItemInfinityArmor unassailableLeggings = new ItemInfinityArmor(Constant.getNextItemID(), BEXMaterials.infinity, 2, false);
    public static final ItemInfinityArmor unassailableBoots = new ItemInfinityArmor(Constant.getNextItemID(), BEXMaterials.infinity, 3, false);
    public static final Item ringKillerInfinity = new ItemInfinityRingKiller(Constant.getNextItemID(), BEXMaterials.infinity).setUnlocalizedName("ringKillerInfinity").setCreativeTab(tabBEX);
    public static final Item itemDynamicCoreInfinity = new ItemDynamicCore(Constant.getNextItemID(), BEXMaterials.infinity, 32767).setUnlocalizedName("dynamic_core_infinity").setCreativeTab(tabBEX);
    public static final ItemFinalFood AvariceMeatBalls = (ItemFinalFood) new ItemFinalFood(Constant.getNextItemID()).setCreativeTab(tabBEX);

    public static final ItemCoin coinVibranium = (ItemCoin) ReflectHelper.createInstance(ItemCoin.class, new Class[]{Integer.TYPE, Material.class}, Constant.getNextItemID(), Materials.vibranium).setCreativeTab(tabBEX);
    public static final Item doorVibranium = new ItemDoor(Constant.getNextItemID(), Materials.vibranium).setCreativeTab(tabBEX);
    public static final Item fishRodVibranium = new ItemBEXFishingRod(Constant.getNextItemID(), Materials.vibranium).setCreativeTab(tabBEX);
    public static final ItemArrow arrowVibranium = (ItemArrow) new ItemArrow(Constant.getNextItemID(), Materials.vibranium).setCreativeTab(tabBEX);

    public static final Item enchantSRC = ReflectHelper.createInstance(Item.class,new Class[]{int.class, Material.class, String.class},Constant.getNextItemID(), BEXMaterials.enchant, "enchant_src").setXPReward(80).setCreativeTab(tabBEX);
    public static final Item enchantIngot = ReflectHelper.createInstance(ItemIngot.class, new Class[]{Integer.TYPE, Material.class}, Constant.getNextItemID(), BEXMaterials.enchant).setCreativeTab(tabBEX);
    public static final ItemNugget enchantNugget = (ItemNugget) ReflectHelper.createInstance(ItemNugget.class, new Class[]{int.class, Material.class},Constant.getNextItemID(), BEXMaterials.enchant).setCreativeTab(tabBEX);
    public static final ItemSword enchantSword = (ItemSword) ReflectHelper.createInstance(ItemSword.class,new Class[]{int.class, Material.class},Constant.getNextItemID(), BEXMaterials.enchant).setCreativeTab(tabBEX);
    public static final Item clubEnchant = new ItemClubMetal(Constant.getNextItemID(), BEXMaterials.enchant).setCreativeTab(tabBEX);
    public static final ItemPickaxe enchantPickaxe = (ItemPickaxe) ReflectHelper.createInstance(ItemPickaxe.class,new Class[]{int.class, Material.class},Constant.getNextItemID(), BEXMaterials.enchant).setCreativeTab(tabBEX);
    public static final Item enchantStick = ReflectHelper.createInstance(Item.class,new Class[]{int.class, Material.class, String.class},Constant.getNextItemID(), BEXMaterials.enchant, "enchant_stick").setCreativeTab(tabBEX);
//    public static final ItemEnhanceStone copper_enhance_stone = (ItemEnhanceStone) new ItemEnhanceStone(ItemEnhanceStone.Types.copper).setCraftingDifficultyAsComponent(ItemRock.getCraftingDifficultyAsComponent(Material.copper) * 2f);

    public static void registerItems(ItemRegistryEvent event) {
        registerItem(event, "vibranium_coin", coinVibranium);
        registerItem(event, "vibranium_door", doorVibranium);
        registerItem(event, "fishing_rods/vibranium_fishrod", fishRodVibranium);
        registerItem(event, "vibranium_arrow", arrowVibranium);

//        registerItem(event, "enhance_stone/copper",copper_enhance_stone , CreativeTabs.tabMaterials);

        registerItem(event, "club/enchant_club", "enchant_club", clubEnchant).setLowestCraftingDifficultyToProduce(1.0F);

        registerItem(event, "ring_killer/ring_killer_infinity", "ring_killer_infinity", ringKillerInfinity).setLowestCraftingDifficultyToProduce(1.0F);

        registerItem(event, "voucher/voucher_zombieboss", "voucher_zombieboss", voucherZombieBoss).setLowestCraftingDifficultyToProduce(1.0F);
        registerItem(event, "voucher/voucher_ghast", "voucher_ghast", voucherGhast).setLowestCraftingDifficultyToProduce(1.0F);
        registerItem(event, "voucher/voucher_bedrock", "voucher_bedrock", voucherBedrock).setLowestCraftingDifficultyToProduce(1.0F);
        registerItem(event, "voucher/voucher_vibraniumdoor", "voucher_vibraniumdoor", voucherVibraniumDoor).setLowestCraftingDifficultyToProduce(1.0F);
        registerItem(event, "voucher/voucher_goldbody_core", "voucher_goldbody_core", voucherGoldBodyCore).setLowestCraftingDifficultyToProduce(1.0F);
        registerItem(event, "voucher/voucher_ultimateannihilation", "voucher_ultimateannihilation", voucherUltimateAnnihilation).setLowestCraftingDifficultyToProduce(1.0F);
        registerItem(event, "voucher/voucher_skeletonboss", "voucher_skeletonboss", voucherSkeletonBoss).setLowestCraftingDifficultyToProduce(1.0F);
        registerItem(event, "voucher/voucher_spider_queen","voucher_spiderqueen",  voucherSpiderQueen).setLowestCraftingDifficultyToProduce(1.0F);
        registerItem(event, "voucher/voucher_zombie_miner", "voucher_zombieminer", voucherZombieMiner).setLowestCraftingDifficultyToProduce(1.0F);

        registerItem(event, "dynamic_core/dynamic_core_6", "dynamic_core_infinity", itemDynamicCoreInfinity).setLowestCraftingDifficultyToProduce(1.0F);

        registerItem(event, "end_book", "end_book", itemEndBook);
        registerItem(event, "spider_queen_silk", "spider_queen_silk", spiderQueenSilk);
        registerItem(event, "foods/avarice_meatballs", "avarice_meatballs", AvariceMeatBalls);

        registerItem(event, "ending", ENDING);
        registerItem(event, "infinity_sword", infinitySword);
        registerItem(event, "ingots/infinity_ingot", "infinity_ingot", infinityingot);
        registerItem(event, "unassailable_chestplate", unassailableChestPlate);
        registerItem(event, "unassailable_helmet", unassailableHelmet);
        registerItem(event, "unassailable_leggings", unassailableLeggings);
        registerItem(event, "unassailable_boots", unassailableBoots);
        registerItem(event, "infinity_pickaxe", infinityPickaxe);
        registerItem(event, "ingots/infinity_nugget", "infinity_nugget", infinityNugget);

        registerItem(event, "enchant_sword", enchantSword);
        registerItem(event, "ingots/enchant_ingot", "enchant_ingot", enchantIngot);
        registerItem(event, "ingots/enchant_nugget", "enchant_nugget", enchantNugget);
        registerItem(event, "enchant_stick", enchantStick);
        registerItem(event, "enchant_pickaxe", enchantPickaxe);
        registerItem(event, "enchant_src", enchantSRC);
    }

    private static Item registerItem(ItemRegistryEvent event, String resourceLocation, Item item) {
        event.register(BEXInit.BEXNameSpace, BEXInit.BEXResourceId + resourceLocation, resourceLocation, item);
        return item;
    }

    private static Item registerItem(ItemRegistryEvent event, String resourceLocation, String name, Item item) {
        event.register(BEXInit.BEXNameSpace, BEXInit.BEXResourceId + resourceLocation, name, item);
        return item;
    }

    public static void registerRecipes(CraftingRecipeRegisterEvent register) {
        register.registerShapelessRecipe(new ItemStack(EXItemsRegistryInit.voucherCore, 1), true, EXItemsRegistryInit.voucherAnnihilationSkeleton, EXItemsRegistryInit.voucherDoor, EXItemsRegistryInit.voucherExchanger, EXItemsRegistryInit.voucherPigman, EXItemsRegistryInit.voucherZombieLord, EXItemsRegistryInit.voucherWitch, voucherGhast, voucherZombieMiner, voucherSpiderQueen);

        register.registerShapedRecipe(new ItemStack(clubEnchant, 1), true, new Object[]{"#B#", "#*#"," A ", '#', BEXItems.enchantNugget , '*', BEXItems.enchantIngot, 'A', EXItemsRegistryInit.voucherClubCore, 'B', EXItemsRegistryInit.clubMithril}).extendsNBT().keepQuality();

        register.registerShapedRecipe(new ItemStack(itemDynamicCoreInfinity, 1), true, new Object[]{"ABA", "BCB","ABA", 'A', BEXItems.infinityingot, 'B', Block.glass, 'C', EXItemsRegistryInit.itemDynamicCoreVibranium});

        register.registerShapelessRecipe(new ItemStack(voucherGoldBodyCore), true, BEXItems.voucherVibraniumDoor, BEXItems.voucherBedrock, BEXItems.voucherGhast, BEXItems.voucherSkeletonBoss);
        register.registerShapelessRecipe(new ItemStack(EXItemsRegistryInit.voucherAnnihilationSkeleton), true,
                EXItemsRegistryInit.voucherDoor, EXItemsRegistryInit.voucherZombieLord, EXItemsRegistryInit.voucherWitch, EXItemsRegistryInit.voucherPigman, EXItemsRegistryInit.voucherExchanger);
        register.registerShapelessRecipe(new ItemStack(EXItemsRegistryInit.voucherPigman), true,
                EXItemsRegistryInit.voucherDoor, EXItemsRegistryInit.voucherZombieLord, EXItemsRegistryInit.voucherWitch, EXItemsRegistryInit.voucherAnnihilationSkeleton, EXItemsRegistryInit.voucherExchanger);
        register.registerShapelessRecipe(new ItemStack(voucherSpiderQueen), true,
                voucherZombieMiner, EXItemsRegistryInit.voucherZombieLord, EXItemsRegistryInit.voucherWitch);

        if (EXConfigs.wenscConfig.isRecipeRingKiller.ConfigValue) {
            register.registerShapedRecipe(new ItemStack(ringKillerInfinity, 1), true, new Object[]{"#U#", "#*#","###", '#', infinitySword, '*', EXItemsRegistryInit.ringKillerVibranium, 'U', BEXItems.voucherUltimateAnnihilation});
        }

        register.registerShapelessRecipe(new ItemStack(itemEndBook), true, Block.enderChest, Item.book);
        
        ItemCoin[] coins = new ItemCoin[]{coinVibranium};

        for (ItemCoin coin : coins) {
            for (int plank_subtype = 1; plank_subtype <= 9; ++plank_subtype) {
                register.registerShapelessRecipe(new ItemStack(coin.getNuggetPeer(), plank_subtype), true, new ItemStack(coin, plank_subtype));
            }

            register.registerShapelessRecipe(new ItemStack(coin), true, new ItemStack(coin.getNuggetPeer()));
        }

        register.registerShapelessRecipe(new ItemStack(enchantSRC), true,
                new ItemStack(Item.appleGold,1,1), Item.ingotAncientMetal, Item.expBottle, EXItemsRegistryInit.voucherFishing, MITEITEItemRegistryInit.VIBRANIUM_INGOT);
        register.registerShapelessRecipe(new ItemStack(infinityingot), true,
                voucherZombieBoss, MITEITEItemRegistryInit.VIBRANIUM_INGOT, EXItemsRegistryInit.voucherClubCore, voucherZombieBoss, EXItemsRegistryInit.voucherClubCore);
        register.registerShapelessRecipe(new ItemStack(AvariceMeatBalls), false,
                new ItemStack(Item.appleGold,8,1), BEXItems.infinityNugget);

        register.registerShapedRecipe(new ItemStack(infinitySword),
                true,
                "CDC",
                "SDS",
                "BEB",
                'E', enchantStick,
                'D', infinityingot,
                'B', MITEITEBlockRegistryInit.blockVibranium,
                'C', coinVibranium,
                'S', MITEITEItemRegistryInit.VIBRANIUM_SWORD);

        register.registerShapedRecipe(new ItemStack(infinityPickaxe),
                true,
                "DDD",
                " E ",
                " E ",
                'E', enchantStick,
                'D', infinityingot);
        register.registerShapedRecipe(new ItemStack(doorVibranium),
                false,
                "NN",
                "NN",
                "NN",
                'N',
                MITEITEItemRegistryInit.VIBRANIUM_INGOT);
        register.registerShapedRecipe(new ItemStack(fishRodVibranium),
                false,
                "  S",
                " SL",
                "XZL",
                'L', BEXItems.spiderQueenSilk,
                'Z', MITEITEItemRegistryInit.VIBRANIUM_NUGGET,
                'S', MITEITEItemRegistryInit.OBSIDIAN_STICK,
                'X', Item.fishingRodAncientMetal);
        register.registerShapedRecipe(new ItemStack(fishRodVibranium),
                false,
                "  X",
                " SL",
                "SZL",
                'L', BEXItems.spiderQueenSilk,
                'Z', MITEITEItemRegistryInit.VIBRANIUM_NUGGET,
                'S', MITEITEItemRegistryInit.OBSIDIAN_STICK,
                'X', Item.fishingRodAncientMetal);
        register.registerShapedRecipe(new ItemStack(fishRodVibranium),
                false,
                "  S",
                " XL",
                "SZL",
                'L', BEXItems.spiderQueenSilk,
                'Z', MITEITEItemRegistryInit.VIBRANIUM_NUGGET,
                'S', MITEITEItemRegistryInit.OBSIDIAN_STICK,
                'X', Item.fishingRodAncientMetal);
        register.registerShapedRecipe(new ItemStack(unassailableChestPlate),
                false,
                "IGI",
                "EBE",
                "CVC",
                'I', BEXItems.infinityingot,
                'G', BEXItems.voucherGoldBodyCore,
                'C', MITEITEItemRegistryInit.VIBRANIUM_CHESTPLATE,
                'V', MITEITEBlockRegistryInit.blockVibranium,
                'E', BEXItems.coinVibranium,
                'B', Block.beacon);
        register.registerShapedRecipe(new ItemStack(unassailableHelmet),
                false,
                "IGI",
                "EBE",
                "CHC",
                'I', BEXItems.infinityingot,
                'G', BEXItems.voucherGoldBodyCore,
                'C', MITEITEItemRegistryInit.VIBRANIUM_HELMET,
                'H', Block.dragonEgg,
                'E', BEXItems.coinVibranium,
                'B', Block.beacon);
        register.registerShapedRecipe(new ItemStack(unassailableBoots),
                false,
                "CGC",
                "EBE",
                "IHI",
                'I', BEXItems.infinityingot,
                'G', BEXItems.voucherGoldBodyCore,
                'C', MITEITEItemRegistryInit.VIBRANIUM_BOOTS,
                'H' ,Block.dragonEgg,
                'E', BEXItems.coinVibranium,
                'B', Block.beacon);
        register.registerShapedRecipe(new ItemStack(unassailableLeggings),
                false,
                "CGC",
                "EBE",
                "IHI",
                'I', BEXItems.infinityingot,
                'G', BEXItems.voucherGoldBodyCore,
                'C', MITEITEItemRegistryInit.VIBRANIUM_LEGGINGS,
                'H',Block.dragonEgg,
                'E', BEXItems.coinVibranium,
                'B',Block.beacon);
        register.registerShapedRecipe(new ItemStack(enchantStick),
                false,
                "I",
                "I",
                'I', BEXItems.enchantIngot);
        register.registerShapedRecipe(new ItemStack(enchantIngot),
                false,
                "NNN",
                "NNN",
                "NNN",
                'N', BEXItems.enchantNugget);
        register.registerShapedRecipe(new ItemStack(enchantSword),
                false,
                "I",
                "I",
                "S",
                'I', BEXItems.enchantIngot,
                'S', MITEITEItemRegistryInit.OBSIDIAN_STICK);
        register.registerShapedRecipe(new ItemStack(enchantPickaxe),
                false,
                "III",
                " S ",
                " S ",
                'I', BEXItems.enchantIngot,
                'S', MITEITEItemRegistryInit.OBSIDIAN_STICK);
        register.registerShapedRecipe(new ItemStack(arrowVibranium, 16),
                false,
                "N",
                "S",
                "F",
                'N', MITEITEItemRegistryInit.VIBRANIUM_NUGGET,
                'S', MITEITEItemRegistryInit.OBSIDIAN_STICK,
                'F',Item.feather);
        register.registerShapedRecipe(new ItemStack(MITEITEItemRegistryInit.VIBRANIUM_BOW),
                false,
                "NSL",
                "AVL",
                "NSL",
                'S', MITEITEItemRegistryInit.OBSIDIAN_STICK,
                'V', MITEITEItemRegistryInit.VIBRANIUM_INGOT,
                'L', spiderQueenSilk,
                'N', MITEITEItemRegistryInit.VIBRANIUM_NUGGET,
                'A', Item.bowAncientMetal).extendsNBT().keepQuality();
        
//        register.registerShapedRecipe(new ItemStack(copper_enhance_stone),
//                true,
//                " S ",
//                "CGC",
//                " S ",
//                'C', Item.ingotCopper,
//                'S', Item.ingotSilver,
//                'G', Item.goldNugget);
        register.registerShapelessRecipe(new ItemStack(BEXItems.infinityingot),
                false,
                infinityNugget,
                infinityNugget,
                infinityNugget,
                infinityNugget);
        register.registerShapelessRecipe(new ItemStack(enchantNugget, 9), true, enchantIngot);

        register.registerShapelessRecipe(new ItemStack(infinityNugget, 4), true, infinityingot);
//        register.registerShapelessRecipe(new ItemStack(infinityingot), true, voucherZombieBoss, VIBRANIUM_INGOT, VIBRANIUM_INGOT);

        FurnaceRecipes.smelting().addSmelting(enchantSRC.itemID, new ItemStack(enchantIngot));

    }
}
