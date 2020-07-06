package flameopathic.enhancedgear.items.supertools.netherite;

import flameopathic.enhancedgear.util.Util;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NetheritePlow extends HoeItem {

    public NetheritePlow(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        Util.cubeMiner(pos, Util.checkWithToolType(Items.NETHERITE_HOE), world, 3, stack, miner);
        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        ItemStack stack = context.getStack();
        LivingEntity user = context.getPlayer();
        Util.plower(pos, world, 3, stack, user);
        return ActionResult.SUCCESS;
    }
}