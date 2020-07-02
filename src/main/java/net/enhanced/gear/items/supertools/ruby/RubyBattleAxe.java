package net.enhanced.gear.items.supertools.ruby;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

import static net.enhanced.gear.Util.checkWithTag;
import static net.enhanced.gear.Util.veinMiner;

public class RubyBattleAxe extends AxeItem {

    public RubyBattleAxe(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
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
        veinMiner(pos, block, checkWithTag(BlockTags.LOGS), world, stack, miner);
        return true;
    }
}