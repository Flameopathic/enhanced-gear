package flameopathic.enhancedgear.items.supertools.obsidian;

import flameopathic.enhancedgear.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ObsidianBattleAxe extends AxeItem {

    public ObsidianBattleAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        Block block = state.getBlock();
        Util.veinMiner(pos, block, Util.checkWithTag(BlockTags.LOGS), world, stack, miner);
        return true;
    }
}