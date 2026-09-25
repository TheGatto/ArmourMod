package com.gatto.cbcbetterarmour.items;

import com.gatto.cbcbetterarmour.util.ModBlockVariants;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class DyeTubeItem extends Item {
    private final String variant;

    public DyeTubeItem(String variant, Properties properties) {
        super(properties);
        this.variant = variant;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        var pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        ItemStack stack = context.getItemInHand();

        Block target = ModBlockVariants.get(state.getBlock(), variant);
        if (target == null || target == state.getBlock())
            return InteractionResult.PASS;

        Player player = context.getPlayer();
        boolean creative = player != null && player.getAbilities().instabuild;
        if (!creative && stack.getDamageValue() >= stack.getMaxDamage())
            return InteractionResult.PASS;

        if (!level.isClientSide) {
            level.setBlockAndUpdate(pos, target.withPropertiesOf(state));
            if (!creative)
                stack.setDamageValue(stack.getDamageValue() + 1);
        }

        level.playSound(player, pos, SoundEvents.DYE_USE, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.sidedSuccess(level.isClientSide);
    }
}
