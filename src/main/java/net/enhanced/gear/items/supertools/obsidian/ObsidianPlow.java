package net.enhanced.gear.items.supertools.obsidian;

import net.enhanced.gear.EnhancedGear;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ObsidianPlow extends HoeItem {

    public ObsidianPlow(ToolMaterial material, float attackSpeed, Settings settings) {
        super(material, attackSpeed, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        World world = context.getWorld();
        ItemStack stack = context.getStack();
        LivingEntity user = context.getPlayer();
        EnhancedGear.plower(pos, world, 3, stack, user);
        return ActionResult.SUCCESS;
    }
}