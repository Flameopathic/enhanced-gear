package net.enhanced.gear.items.supertools.iron;

import net.enhanced.gear.EnhancedGear;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IronExcavator extends ShovelItem {
    public IronExcavator(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        EnhancedGear.cubeMiner(pos, Items.IRON_SHOVEL, world, 3, stack, miner);
        System.out.println(world.isClient);
        ((ServerWorld) world).spawnParticles(ParticleTypes.SMOKE, pos.getX(), pos.getY(), pos.getZ(), 1000, 0.1, 0.1, 0.1, 0.1);
        return true;
    }
}