package net.moddedmite.mitemod.bex.compat;

import com.inf1nlty.newshop.api.ShopPlugin;
import com.inf1nlty.newshop.api.ShopRegistry;
import net.minecraft.Item;
import net.moddedmite.mitemod.bex.register.BEXItems;

public class BEXShopPlugin implements ShopPlugin {

    @Override
    public void register(ShopRegistry registry) {

        registry.addItem(BEXItems.doorVibranium, 0, 0.0, 500.0);
        registry.addItem(BEXItems.infinityingot, 0, 0.0, 10000.0);

        registry.addItem(Item.enderPearl, 0, 0.0, 5.0);
        registry.addItem(Item.arrowRustedIron, 0, 0.0, 1.0);
        registry.addItem(Item.arrowIron, 0, 0.0, 2.0);
        registry.addItem(Item.arrowAncientMetal, 0, 0.0, 3.0);
        registry.addItem(Item.slimeBall, 0, 0.0, 1.0);

        registry.addItem(Item.brewingStand, 0, 500.0, 0.0);
        registry.addItem(Item.netherStalkSeeds, 0, 10.0, 0.1);
        registry.addItem(Item.netherQuartz, 0, 1.0, 0.0);
    }
}