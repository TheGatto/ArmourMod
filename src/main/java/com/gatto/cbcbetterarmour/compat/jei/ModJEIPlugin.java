package com.gatto.cbcbetterarmour.compat.jei;

import com.gatto.cbcbetterarmour.CBCBetterArmourMod;
import com.gatto.cbcbetterarmour.items.ModItems;
import com.gatto.cbcbetterarmour.recipe.AcidWashingRecipe;
import com.gatto.cbcbetterarmour.recipe.ModRecipeTypes;
import com.simibubi.create.compat.jei.category.CreateRecipeCategory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class ModJEIPlugin implements IModPlugin {

    private static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(CBCBetterArmourMod.MOD_ID, "jei_plugin");

    private final List<CreateRecipeCategory<?>> allCategories = new ArrayList<>();

    private void loadCategories() {
        allCategories.clear();

        Item acidBucket = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("createplenty", "sulfuric_acid_bucket"));
        if (acidBucket == Items.AIR)
            acidBucket = ModItems.MYSTERIOUS_ORE.get();

        allCategories.add(new CreateRecipeCategory.Builder<>(AcidWashingRecipe.class)
                .addTypedRecipes(ModRecipeTypes.ACID_WASHING)
                .catalystStack(AcidWashingCategory.getFan())
                .doubleItemIcon(BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("create", "propeller")), acidBucket)
                .emptyBackground(178, 72)
                .build(ModRecipeTypes.ACID_WASHING.getId(), AcidWashingCategory::new));
    }

    @Override
    @NotNull
    public ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        loadCategories();
        registration.addRecipeCategories(allCategories.toArray(IRecipeCategory[]::new));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        allCategories.forEach(c -> c.registerRecipes(registration));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        allCategories.forEach(c -> c.registerCatalysts(registration));
    }
}
