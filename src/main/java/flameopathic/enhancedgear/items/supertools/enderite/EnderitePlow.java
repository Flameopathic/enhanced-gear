package flameopathic.enhancedgear.items.supertools.enderite;

import flameopathic.enhancedgear.EnhancedGear;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static flameopathic.enhancedgear.util.Util.*;

public class EnderitePlow extends HoeItem {

    public EnderitePlow(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        cubeMiner(pos, checkWithToolType(EnhancedGear.OBSIDIAN_HOE), world, 3, stack, miner);
        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        ItemStack stack = context.getStack();
        LivingEntity user = context.getPlayer();
        plower(pos, world, 3, stack, user);
        return ActionResult.SUCCESS;
    }
}