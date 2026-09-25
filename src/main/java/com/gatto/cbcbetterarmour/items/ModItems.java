package com.gatto.cbcbetterarmour.items;

import com.gatto.cbcbetterarmour.CBCBetterArmourMod;
import com.gatto.cbcbetterarmour.util.ModBlockVariants;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CBCBetterArmourMod.MOD_ID);

    public static final DeferredItem<Item> BORAX = ITEMS.register("borax", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BORIA = ITEMS.register("boria", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BORON_CARBIDE = ITEMS.register("boron_carbide", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CARBON_FIBRE = ITEMS.register("carbon_fibre", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DYE_TUBE = ITEMS.register("dye_tube", () -> new DyeTubeItem(ModBlockVariants.BASE, new Item.Properties().durability(64)));
    public static final DeferredItem<Item> DYE_TUBE_YELLOW = ITEMS.register("dye_tube_yellow", () -> new DyeTubeItem(ModBlockVariants.YELLOW, new Item.Properties().durability(64)));
    public static final DeferredItem<Item> DYE_TUBE_GREEN = ITEMS.register("dye_tube_green", () -> new DyeTubeItem(ModBlockVariants.GREEN, new Item.Properties().durability(64)));

    public static final DeferredItem<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IRIDIUM_NUGGET = ITEMS.register("iridium_nugget", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OSMIUM_NUGGET = ITEMS.register("osmium_nugget", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> OSMIRIDIUM_INGOT = ITEMS.register("osmiridium_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CARBYNE_SHEET = ITEMS.register("carbyne_sheet", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ZIRCON = ITEMS.register("zircon", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MYSTERIOUS_ORE = ITEMS.register("mysterious_ore", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
