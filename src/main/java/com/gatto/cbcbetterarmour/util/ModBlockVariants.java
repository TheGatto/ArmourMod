package com.gatto.cbcbetterarmour.util;

import com.gatto.cbcbetterarmour.block.ModBlocks;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlockVariants {
    public static final String BASE = "base";
    public static final String YELLOW = "yellow";
    public static final String GREEN = "green";

    private static final List<Map<String, Supplier<Block>>> FAMILIES = List.of(
            Map.of(
                    BASE, ModBlocks.BORON_CARBIDE_COMPOSITE_ARMOUR_BLOCK,
                    YELLOW, ModBlocks.BORON_CARBIDE_COMPOSITE_ARMOUR_DUNE_BLOCK,
                    GREEN, ModBlocks.BORON_CARBIDE_COMPOSITE_ARMOUR_FOREST_BLOCK
            )
    );

    public static Block get(Block from, String variant) {
        for (Map<String, Supplier<Block>> family : FAMILIES) {
            for (Supplier<Block> member : family.values()) {
                if (member.get() == from) {
                    Supplier<Block> target = family.get(variant);
                    return target == null ? null : target.get();
                }
            }
        }
        return null;
    }
}
