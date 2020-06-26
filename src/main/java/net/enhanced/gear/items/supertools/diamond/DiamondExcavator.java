package net.enhanced.gear.items.supertools.diamond;

import net.enhanced.gear.EnhancedGear;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.enhanced.gear.EnhancedGear.checkWithToolType;

public class DiamondExcavator extends ShovelItem {
    public DiamondExcavator(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        EnhancedGear.cubeMiner(pos, checkWithToolType(Items.DIAMOND_SHOVEL), world, 3, stack, miner);
        System.out.println(world.isClient);
        ((ServerWorld) world).spawnParticles(ParticleTypes.SMOKE, pos.getX(), pos.getY(), pos.getZ(), 1000, 0.1, 0.1, 0.1, 0.1);
        return true;
    }
}