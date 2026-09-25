package com.gatto.cbcbetterarmour.fan;

import com.gatto.cbcbetterarmour.recipe.ModRecipeTypes;
import com.gatto.cbcbetterarmour.util.ModTags;
import com.simibubi.create.content.kinetics.fan.processing.FanProcessingType;
import com.simibubi.create.foundation.recipe.RecipeApplier;
import net.createmod.catnip.theme.Color;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.List;

public class AcidWashingType implements FanProcessingType {
    @Override
    public boolean isValidAt(Level level, BlockPos pos) {
        FluidState fluidState = level.getFluidState(pos);
        return fluidState.is(ModTags.Fluids.ACID_WASHING_CATALYSTS);
    }

    @Override
    public int getPriority() {
        return 400;
    }

    @Override
    public boolean canProcess(ItemStack stack, Level level) {
        return ModRecipeTypes.ACID_WASHING.find(new SingleRecipeInput(stack), level)
                .isPresent();
    }

    @Override
    @Nullable
    public List<ItemStack> process(ItemStack stack, Level level) {
        return ModRecipeTypes.ACID_WASHING.find(new SingleRecipeInput(stack), level)
                .map(RecipeHolder::value)
                .map(r -> RecipeApplier.applyRecipeOn(level, stack, r, true))
                .orElse(null);
    }

    @Override
    public void spawnProcessingParticles(Level level, Vec3 pos) {
        if (level.random.nextInt(8) != 0)
            return;
        Vector3f color = new Color(0xC6D400).asVectorF();
        level.addParticle(new DustParticleOptions(color, 1), pos.x + (level.random.nextFloat() - .5f) * .5f,
                pos.y + .5f, pos.z + (level.random.nextFloat() - .5f) * .5f, 0, 1 / 8f, 0);
        level.addParticle(ParticleTypes.SPIT, pos.x + (level.random.nextFloat() - .5f) * .5f, pos.y + .5f,
                pos.z + (level.random.nextFloat() - .5f) * .5f, 0, 1 / 8f, 0);
    }

    @Override
    public void morphAirFlow(AirFlowParticleAccess particleAccess, RandomSource random) {
        particleAccess.setColor(Color.mixColors(0xD8E600, 0xA9B800, random.nextFloat()));
        particleAccess.setAlpha(1f);
        if (random.nextFloat() < 1 / 32f)
            particleAccess.spawnExtraParticle(ParticleTypes.BUBBLE_POP, .125f);
    }

    @Override
    public void affectEntity(Entity entity, Level level) {
        if (level.isClientSide)
            return;

        if (entity instanceof LivingEntity) {
            entity.hurt(entity.damageSources().magic(), 2);
        }
    }
}
