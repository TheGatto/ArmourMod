package com.gatto.cbcbetterarmour.items;

import com.gatto.cbcbetterarmour.CBCBetterArmourMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CBCBetterArmourMod.MOD_ID);

    public static final DeferredItem<Item> BORAX = ITEMS.register("borax", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BORIA = ITEMS.register("boria", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BORON_CARBIDE = ITEMS.register("boron_carbide", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
