package flameopathic.enhancedgear.items.supertools.enderite;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static flameopathic.enhancedgear.util.Util.checkWithTag;
import static flameopathic.enhancedgear.util.Util.veinMiner;

public class EnderiteBattleAxe extends AxeItem {

    public EnderiteBattleAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        Block block = state.getBlock();
        veinMiner(pos, block, checkWithTag(BlockTags.LOGS), world, stack, miner);
        return true;
    }
}