package net.enhanced.gear.items.supertools.diamond;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DiamondPlow extends HoeItem {

    public DiamondPlow(ToolMaterial material, float attackSpeed, Settings settings) {
        super(material, attackSpeed, settings);
    }

    public void eatBlocks(BlockPos pos, World world, ItemStack stack, LivingEntity miner) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    BlockPos current = pos.add(x, y, z);
                    BlockState state = world.getBlockState(current);
                    Block block = state.getBlock();
                    if (block.equals(Blocks.DIRT) && world.getBlockState(current.up()).getBlock().equals(Blocks.AIR) || block.equals(Blocks.GRASS_BLOCK) && world.getBlockState(current.up()).getBlock().equals(Blocks.AIR)) {
                        if (stack.getDamage() < stack.getMaxDamage()) {
                            world.setBlockState(current, Blocks.FARMLAND.getDefaultState());
                            stack.damage(1, miner, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                        }
                    }
                }
            }
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        ItemStack stack = context.getStack();
        LivingEntity user = context.getPlayer();
        eatBlocks(pos, world, stack, user);
        return ActionResult.SUCCESS;
    }
}