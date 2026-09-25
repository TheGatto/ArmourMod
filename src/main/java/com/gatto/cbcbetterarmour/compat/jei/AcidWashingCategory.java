package com.gatto.cbcbetterarmour.compat.jei;

import com.gatto.cbcbetterarmour.CBCBetterArmourMod;
import com.gatto.cbcbetterarmour.recipe.AcidWashingRecipe;
import com.simibubi.create.compat.jei.category.ProcessingViaFanCategory;
import com.simibubi.create.compat.jei.category.animations.AnimatedKinetics;
import net.createmod.catnip.gui.element.GuiGameElement;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;

import java.util.function.Supplier;

public class AcidWashingCategory extends ProcessingViaFanCategory.MultiOutput<AcidWashingRecipe> {

    public static final ResourceLocation SULFURIC_ACID = ResourceLocation.fromNamespaceAndPath("createplenty", "sulfuric_acid");

    public AcidWashingCategory(Info<AcidWashingRecipe> info) {
        super(info);
    }

    public static Supplier<ItemStack> getFan() {
        ItemStack stack = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("create", "encased_fan")));
        stack.set(DataComponents.CUSTOM_NAME, Component.translatable(CBCBetterArmourMod.MOD_ID + ".recipe.acid_washing.fan").withStyle(style -> style.withItalic(false)));
        return () -> stack;
    }

    @Override
    protected void renderAttachedBlock(GuiGraphics graphics) {
        Fluid fluid = BuiltInRegistries.FLUID.get(SULFURIC_ACID);
        if (fluid == Fluids.EMPTY)
            return;
        GuiGameElement.of(fluid)
                .scale(SCALE)
                .atLocal(0, 0, 2)
                .lighting(AnimatedKinetics.DEFAULT_LIGHTING)
                .render(graphics);
    }

}
