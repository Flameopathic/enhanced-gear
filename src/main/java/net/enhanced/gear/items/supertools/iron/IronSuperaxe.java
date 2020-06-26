package net.enhanced.gear.items.supertools.iron;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.enhanced.gear.Util.checkWithTag;
import static net.enhanced.gear.Util.veinMiner;

public class IronSuperaxe extends AxeItem {

    public IronSuperaxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        Block block = state.getBlock();
        veinMiner(pos, block, checkWithTag(BlockTags.LOGS), world, stack, miner);
        return true;
    }
}