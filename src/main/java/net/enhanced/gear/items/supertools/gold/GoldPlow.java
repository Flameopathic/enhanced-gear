package net.enhanced.gear.items.supertools.gold;

import net.enhanced.gear.EnhancedGear;
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

public class GoldPlow extends HoeItem {

    public GoldPlow(ToolMaterial material, float attackSpeed, Settings settings) {
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