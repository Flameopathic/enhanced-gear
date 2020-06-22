package net.enhanced.gear.items.supertools;

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

    public void eatTheTree(BlockPos pos, World world,  ItemStack stack, LivingEntity miner) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    BlockPos current = pos.add(x, y, z);
                    BlockState state = world.getBlockState(current);
                    Block block = state.getBlock();
                    if (BlockTags.LOGS.contains(block)) {
                        if (stack.getDamage() < stack.getMaxDamage()) {
                            world.breakBlock(current, true);
                            stack.damage(1, miner, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                            eatTheTree(current, world, stack, miner);
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (BlockTags.LOGS.contains(state.getBlock())) {
            eatTheTree(pos, world, stack, miner);
        }
        return true;
    }
}