package net.enhanced.gear.items.supertools.gold;

import net.enhanced.gear.EnhancedGear;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GoldDrill extends PickaxeItem {

    public GoldDrill(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public void eatBlocks(BlockPos pos, Block block, World world,  ItemStack stack, LivingEntity miner) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    BlockPos current = pos.add(x, y, z);
                    BlockState state = world.getBlockState(current);
                    Block currentBlock = state.getBlock();
                    if (EnhancedGear.ORES.contains(block)) {
                        if (block.equals(currentBlock)) {
                            if (stack.getDamage() < stack.getMaxDamage()) {
                                world.breakBlock(current, true);
                                stack.damage(1, miner, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                                eatBlocks(current, block, world, stack, miner);
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        Block block = state.getBlock();
        eatBlocks(pos, block, world, stack, miner);
        return true;
    }
}