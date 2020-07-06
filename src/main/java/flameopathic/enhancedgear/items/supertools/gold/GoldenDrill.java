package flameopathic.enhancedgear.items.supertools.gold;

import flameopathic.enhancedgear.EnhancedGear;
import flameopathic.enhancedgear.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class GoldenDrill extends PickaxeItem {

    public GoldenDrill(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        Block block = state.getBlock();
        Util.veinMiner(pos, block, Util.checkWithTag(EnhancedGear.ORES), world, stack, miner);
        return true;
    }
}