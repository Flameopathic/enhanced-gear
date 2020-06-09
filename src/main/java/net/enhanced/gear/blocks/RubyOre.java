package net.enhanced.gear.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class RubyOre extends Block {
    public RubyOre(Settings settings) {
        super(settings);
    }
    public Random random = new Random();

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);
        if (random.nextInt(20) == 0) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 12000, 9, false, false));
        }
    }
}

