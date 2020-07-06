package flameopathic.enhancedgear.items.supertools.ruby;

import flameopathic.enhancedgear.util.Util;
import flameopathic.enhancedgear.EnhancedGear;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class RubyDrill extends PickaxeItem {

    public RubyDrill(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
        Random random = new Random();
        EnchantmentHelper.enchant(random, stack, 15, false);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        Block block = state.getBlock();
        Util.veinMiner(pos, block, Util.checkWithTag(EnhancedGear.ORES), world, stack, miner);
        return true;
    }
}