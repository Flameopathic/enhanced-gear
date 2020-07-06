package flameopathic.enhancedgear.items.supertools.diamond;

import flameopathic.enhancedgear.EnhancedGear;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static flameopathic.enhancedgear.util.Util.checkWithTag;
import static flameopathic.enhancedgear.util.Util.veinMiner;

public class DiamondDrill extends PickaxeItem {

    public DiamondDrill(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        Block block = state.getBlock();
        veinMiner(pos, block, checkWithTag(EnhancedGear.ORES), world, stack, miner);
        return true;
    }
}