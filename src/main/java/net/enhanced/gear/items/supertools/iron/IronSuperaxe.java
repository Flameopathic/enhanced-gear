package net.enhanced.gear.items.supertools.iron;

import net.enhanced.gear.EnhancedGear;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class IronSuperaxe extends AxeItem {

    public IronSuperaxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        Block block = world.getBlockState(pos).getBlock();
        EnhancedGear.veinMiner(pos, block, BlockTags.LOGS, world, stack, miner);
        return true;
    }
}