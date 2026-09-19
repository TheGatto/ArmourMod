package com.gatto.cbcbetterarmour.items;

import com.gatto.cbcbetterarmour.CBCBetterArmourMod;
import com.gatto.cbcbetterarmour.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CBCBetterArmourMod.MOD_ID);

    public static final Supplier<CreativeModeTab> CBCBETTERARMOUR_TAB = CREATIVE_MODE_TAB.register("cbcbetterarmour_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BORON_CARBIDE.get()))
                    .title(Component.translatable("creativetab.cbcbetterarmour"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BORAX);
                        output.accept(ModItems.BORIA);
                        output.accept(ModItems.BORON_CARBIDE);
                        output.accept(ModBlocks.BORAX_BLOCK);
                        output.accept(ModBlocks.SKY_STONE);
                        output.accept(ModBlocks.BORON_CARBIDE_BLOCK);
                        output.accept(ModBlocks.HARDENED_GLASS_BLOCK);
                        output.accept(ModBlocks.PYKRETE);
                        output.accept(ModBlocks.BORON_CARBIDE_COMPOSITE_ARMOUR_BLOCK);
                        output.accept(ModBlocks.BORON_CARBIDE_COMPOSITE_ARMOUR_DUNE_BLOCK);
                        output.accept(ModBlocks.BORON_CARBIDE_COMPOSITE_ARMOUR_FOREST_BLOCK);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
