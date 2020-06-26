package net.enhanced.gear.items.supertools.iron;

import net.enhanced.gear.EnhancedGear;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IronCraterCreator extends PickaxeItem {
    public IronCraterCreator(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        EnhancedGear.cubeMiner(pos, EnhancedGear.STONEY, world, 5, stack, miner);
        ((ServerWorld) world).spawnParticles(ParticleTypes.EXPLOSION, pos.getX(), pos.getY(), pos.getZ(), 1, 1.0, 1.0, 1.0, 1.0);
        world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 10, 1);
        return true;
    }
}