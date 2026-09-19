package com.gatto.cbcbetterarmour;

import com.gatto.cbcbetterarmour.block.ModBlocks;
import com.gatto.cbcbetterarmour.items.ModCreativeModeTab;
import com.gatto.cbcbetterarmour.items.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(CBCBetterArmourMod.MOD_ID)
public class CBCBetterArmourMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "cbcbetterarmour";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public CBCBetterArmourMod(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTab.register(modEventBus);
        modEventBus.addListener(this::addCreative);


        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == ModCreativeModeTab.CBCBETTERARMOUR_TAB) {
            event.accept(ModItems.BORAX);
            event.accept(ModItems.BORIA);
            event.accept(ModItems.BORON_CARBIDE);

            event.accept(ModBlocks.BORAX_BLOCK);
            event.accept(ModBlocks.SKY_STONE);
            event.accept(ModBlocks.BORON_CARBIDE_BLOCK);
            event.accept(ModBlocks.HARDENED_GLASS_BLOCK);
            event.accept(ModBlocks.PYKRETE);
            event.accept(ModBlocks.BORON_CARBIDE_COMPOSITE_ARMOUR_BLOCK);
            event.accept(ModBlocks.BORON_CARBIDE_COMPOSITE_ARMOUR_DUNE_BLOCK);
            event.accept(ModBlocks.BORON_CARBIDE_COMPOSITE_ARMOUR_FOREST_BLOCK);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
