package com.gatto.cbcbetterarmour.block;

import com.gatto.cbcbetterarmour.CBCBetterArmourMod;
import com.gatto.cbcbetterarmour.items.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CBCBetterArmourMod.MOD_ID);

    public static final DeferredBlock<Block> BORAX_BLOCK = registerBlock("borax_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(.75f).explosionResistance(4.2f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)));
    public static final DeferredBlock<Block> BORON_CARBIDE_BLOCK = registerBlock("boron_carbide_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(5f).explosionResistance(20f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> HARDENED_GLASS_BLOCK = registerBlock("hardened_glass_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(.4f).explosionResistance(12f).sound(SoundType.GLASS).noOcclusion().isSuffocating((state, level, pos) -> false)
                    .isViewBlocking((state, level, pos) -> false)));
    public static final DeferredBlock<Block> BORON_CARBIDE_COMPOSITE_ARMOUR_BLOCK = registerBlock("boron_carbide_composite_armour_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(5f).explosionResistance(30f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
    public static final DeferredBlock<Block> BORON_CARBIDE_COMPOSITE_ARMOUR_DUNE_BLOCK = registerBlock("boron_carbide_composite_armour_dune_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(5f).explosionResistance(30f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
    public static final DeferredBlock<Block> BORON_CARBIDE_COMPOSITE_ARMOUR_FOREST_BLOCK = registerBlock("boron_carbide_composite_armour_forest_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(5f).explosionResistance(30f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
    public static final DeferredBlock<Block> REINFORCED_STEEL_PLATE = registerBlock("reinforced_steel_plate",
            () -> new Block(BlockBehaviour.Properties.of().strength(5f).explosionResistance(20f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
    public static final DeferredBlock<Block> ZIRCONIA_OSMIRIDIUM_COMPOSITE = registerBlock("zirconia_osmiridium_composite",
            () -> new Block(BlockBehaviour.Properties.of().strength(5f).explosionResistance(60f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
    public static final DeferredBlock<Block> NESTED_CARBYNE_PLATE = registerBlock("nested_carbyne_plate",
            () -> new Block(BlockBehaviour.Properties.of().strength(5f).explosionResistance(45f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));
    public static final DeferredBlock<Block> PYKRETE = registerBlock("pykrete",
            () -> new Block(BlockBehaviour.Properties.of().strength(1.5f).explosionResistance(12f).sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> SKY_STONE = registerBlock("sky_stone",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).explosionResistance(6f).sound(SoundType.DRIPSTONE_BLOCK).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SKY_STONE_ORE = registerBlock("sky_stone_ore",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).explosionResistance(6f).sound(SoundType.DRIPSTONE_BLOCK).requiresCorrectToolForDrops()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
