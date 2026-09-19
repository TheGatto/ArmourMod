package com.gatto.cbcbetterarmour.util;

import com.gatto.cbcbetterarmour.CBCBetterArmourMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> BORON_CARBIDE_COMPOSITE = createTag("boron_carbide_composite");
        public static final TagKey<Block> LIGHT_ARMOUR = createTag("boron_carbide_composite");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(CBCBetterArmourMod.MOD_ID, name));
        }
    }

    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(CBCBetterArmourMod.MOD_ID, name));
        }
    }
}
