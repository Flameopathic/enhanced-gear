package net.enhanced.gear.items.supertools.iron;

import net.enhanced.gear.EnhancedGear;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.enhanced.gear.Util.plower;

public class IronPlow extends HoeItem {

    public IronPlow(ToolMaterial material, float attackSpeed, Settings settings) {
        super(material, attackSpeed, settings);
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