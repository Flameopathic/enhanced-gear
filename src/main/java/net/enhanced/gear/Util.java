package net.enhanced.gear;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.Tag;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;
import java.util.function.BiFunction;

public class Util {
    //Generates blocks in whatever biome is put into it. Only does ruby_ore right now
    public static void handleBiome(Biome biome) {
        if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
            biome.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(
                            new OreFeatureConfig(
                                    OreFeatureConfig.Target.NATURAL_STONE,
                                    EnhancedGear.RUBY_ORE.getDefaultState(),
                                    5       //maximum vein size
                            )).createDecoratedFeature(
                            Decorator.COUNT_RANGE.configure(new RangeDecoratorConfig(
                                    3,     //maximum number per chunk
                                    0,
                                    0,
                                    15  //maximum y coordinate
                            ))));
        }
    }

    //Stuff that makes supertools work

    public static BiFunction<BlockState, ItemStack, Boolean> checkWithTag(Tag<Block> tag) {
        return (blockState, itemStack) -> tag.contains(blockState.getBlock());
    }
    public static BiFunction<BlockState, ItemStack, Boolean> checkWithToolType(Item toolType) {
        return (blockState, itemStack) -> toolType.getMiningSpeed(itemStack, blockState) > 1;
    }
    public static BiFunction<BlockState, ItemStack, Boolean> checkWithBlockList(List<Block> blocks) {
        return (blockState, itemStack) -> blocks.contains(blockState.getBlock());
    }

//    public static BiFunction<BlockState, ItemStack, Boolean> example = checkWithBlockList(Arrays.asList(/*Grass, Podzol, ...*/));

    public static void veinMiner(BlockPos pos, Block block, BiFunction<BlockState, ItemStack, Boolean> canMine, World world, ItemStack stack, LivingEntity miner) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    BlockPos current = pos.add(x, y, z);
                    BlockState state = world.getBlockState(current);
                    Block currentBlock = state.getBlock();
                    if (canMine.apply(state, stack)) {
                        if (block.equals(currentBlock)) {
                            if (stack.getDamage() < stack.getMaxDamage()) {
                                world.breakBlock(current, true);
                                stack.damage(1, miner, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                                veinMiner(current, block, canMine, world, stack, miner);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void cubeMiner(BlockPos pos, BiFunction<BlockState, ItemStack, Boolean> canMine, World world, int diameter, ItemStack stack, LivingEntity miner) {
        int min = (diameter / 2) * -1;
        int max = (min * -1) + 1;
        for (int x = min; x < max; x++) {
            for (int y = min; y < max; y++) {
                for (int z = min; z < max; z++) {
                    BlockPos current = pos.add(x, y, z);
                    BlockState state = world.getBlockState(current);
                    if (canMine.apply(state, stack)) {
                        if (stack.getDamage() < stack.getMaxDamage()) {
                            world.breakBlock(current, true);
                            stack.damage(1, miner, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                        }
                    }
                }
            }
        }
    }

    public static void plower(BlockPos pos, World world, int diameter, ItemStack stack, LivingEntity miner) {
        int min = (diameter / 2) * -1;
        int max = (min * -1) + 1;
        for (int x = min; x < max; x++) {
            for (int y = min; y < max; y++) {
                for (int z = min; z < max; z++) {
                    BlockPos current = pos.add(x, y, z);
                    BlockState state = world.getBlockState(current);
                    Block block = state.getBlock();
                    if ((block.equals(Blocks.DIRT) || block.equals(Blocks.GRASS_BLOCK)) &&
                            world.getBlockState(current.up()).getBlock().isAir(world.getBlockState(current.up()))){
                        if (stack.getDamage() < stack.getMaxDamage()) {
                            world.setBlockState(current, Blocks.FARMLAND.getDefaultState());
                            stack.damage(1, miner, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                        }
                    }
                }
            }
        }
    }
}
