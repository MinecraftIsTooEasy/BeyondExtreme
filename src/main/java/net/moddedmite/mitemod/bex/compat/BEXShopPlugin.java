package net.moddedmite.mitemod.bex.compat;

import cn.wensc.mitemod.shop.api.ShopItem;
import cn.wensc.mitemod.shop.api.ShopPlugin;
import cn.wensc.mitemod.shop.api.ShopRegistry;
import net.minecraft.Item;
import net.moddedmite.mitemod.bex.register.BEXItems;

public class BEXShopPlugin implements ShopPlugin {
	@Override
	public void register(ShopRegistry shopRegistry) {
		((ShopItem) BEXItems.doorVibranium).setSoldPriceForAllSubs(500D);
		((ShopItem) BEXItems.infinityingot).setSoldPriceForAllSubs(10000D);
		((ShopItem) Item.enderPearl).setSoldPriceForAllSubs(5D);
		((ShopItem) Item.arrowRustedIron).setSoldPriceForAllSubs(1D);
		((ShopItem) Item.arrowIron).setSoldPriceForAllSubs(2D);
		((ShopItem) Item.arrowAncientMetal).setSoldPriceForAllSubs(3D);
		((ShopItem) Item.slimeBall).setSoldPriceForAllSubs(1D);
		
		((ShopItem) Item.brewingStand).setBuyPriceForAllSubs(500D);
		((ShopItem) Item.netherStalkSeeds).setBuyPriceForAllSubs(10D).setSoldPriceForAllSubs(0.1D);
		((ShopItem) Item.netherQuartz).setBuyPriceForAllSubs(1D);
	}
}
