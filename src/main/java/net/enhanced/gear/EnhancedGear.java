package net.enhanced.gear;

import net.enhanced.gear.armor.EmeraldArmorBase;
import net.enhanced.gear.armor.ObsidianArmorBase;
import net.enhanced.gear.armor.RubyArmorBase;
import net.enhanced.gear.armor.StoneArmorBase;
import net.enhanced.gear.blocks.RubyBlock;
import net.enhanced.gear.blocks.RubyOre;
import net.enhanced.gear.items.Ruby;
import net.enhanced.gear.items.supertools.diamond.*;
import net.enhanced.gear.items.supertools.gold.*;
import net.enhanced.gear.items.supertools.iron.*;
import net.enhanced.gear.items.tools.*;
import net.enhanced.gear.materials.armormaterials.EmeraldArmor;
import net.enhanced.gear.materials.armormaterials.ObsidianArmor;
import net.enhanced.gear.materials.armormaterials.RubyArmor;
import net.enhanced.gear.materials.armormaterials.StoneArmor;
import net.enhanced.gear.materials.supertoolmaterials.DiamondSupertool;
import net.enhanced.gear.materials.supertoolmaterials.GoldSupertool;
import net.enhanced.gear.materials.supertoolmaterials.IronSupertool;
import net.enhanced.gear.materials.toolmaterials.EmeraldTool;
import net.enhanced.gear.materials.toolmaterials.ObsidianTool;
import net.enhanced.gear.materials.toolmaterials.RubyTool;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class EnhancedGear implements ModInitializer {

    //Something to lessen typing
    public static final String modid = "enhancedgear";

    //Main item group with all modded items in it
    public static final ItemGroup GROUP = FabricItemGroupBuilder.create(new Identifier(modid, "group"))
            .icon(() -> new ItemStack(EnhancedGear.OBSIDIAN_CHESTPLATE))
            .appendItems(stacks ->
            {
                /*
                Items in here are in the custom group.
                Their order dictates their order in the group.
                ItemStack.EMPTY will make an open slot
                */

                //Emerald armor
                stacks.add(new ItemStack(EnhancedGear.EMERALD_HELMET));
                stacks.add(new ItemStack(EnhancedGear.EMERALD_CHESTPLATE));
                stacks.add(new ItemStack(EnhancedGear.EMERALD_LEGGINGS));
                stacks.add(new ItemStack(EnhancedGear.EMERALD_BOOTS));

                //Emerald tools
                stacks.add(new ItemStack(EnhancedGear.EMERALD_SWORD));
                stacks.add(new ItemStack(EnhancedGear.EMERALD_PICKAXE));
                stacks.add(new ItemStack(EnhancedGear.EMERALD_AXE));
                stacks.add(new ItemStack(EnhancedGear.EMERALD_SHOVEL));
                stacks.add(new ItemStack(EnhancedGear.EMERALD_HOE));

                //Obsidian armor
                stacks.add(new ItemStack(EnhancedGear.OBSIDIAN_HELMET));
                stacks.add(new ItemStack(EnhancedGear.OBSIDIAN_CHESTPLATE));
                stacks.add(new ItemStack(EnhancedGear.OBSIDIAN_LEGGINGS));
                stacks.add(new ItemStack(EnhancedGear.OBSIDIAN_BOOTS));

                //Obsidian tools
                stacks.add(new ItemStack(EnhancedGear.OBSIDIAN_SWORD));
                stacks.add(new ItemStack(EnhancedGear.OBSIDIAN_PICKAXE));
                stacks.add(new ItemStack(EnhancedGear.OBSIDIAN_AXE));
                stacks.add(new ItemStack(EnhancedGear.OBSIDIAN_SHOVEL));
                stacks.add(new ItemStack(EnhancedGear.OBSIDIAN_HOE));

                //Ruby armor
                stacks.add(new ItemStack(EnhancedGear.RUBY_HELMET));
                stacks.add(new ItemStack(EnhancedGear.RUBY_CHESTPLATE));
                stacks.add(new ItemStack(EnhancedGear.RUBY_LEGGINGS));
                stacks.add(new ItemStack(EnhancedGear.RUBY_BOOTS));

                //Ruby tools
                stacks.add(new ItemStack(EnhancedGear.RUBY_SWORD));
                stacks.add(new ItemStack(EnhancedGear.RUBY_PICKAXE));
                stacks.add(new ItemStack(EnhancedGear.RUBY_AXE));
                stacks.add(new ItemStack(EnhancedGear.RUBY_SHOVEL));
                stacks.add(new ItemStack(EnhancedGear.RUBY_HOE));

                //Stone armor
                stacks.add(new ItemStack(EnhancedGear.STONE_HELMET));
                stacks.add(new ItemStack(EnhancedGear.STONE_VEST));
                stacks.add(new ItemStack(EnhancedGear.STONE_LEG_PLATING));
                stacks.add(new ItemStack(EnhancedGear.STONE_BOOTS));

                //Other
                stacks.add(new ItemStack(EnhancedGear.RUBY));
                stacks.add(new ItemStack(EnhancedGear.RUBY_ORE));
                stacks.add(new ItemStack(EnhancedGear.RUBY_BLOCK));
            })
            .build();

    public static final ItemGroup SUPERTOOL_GROUP = FabricItemGroupBuilder.create(new Identifier(modid, "supertool_group"))
            .icon(() -> new ItemStack(EnhancedGear.IRON_CRATER_CREATOR))
            .appendItems(stacks ->
            {
                //Iron
                stacks.add(new ItemStack(EnhancedGear.IRON_CRATER_CREATOR));
                stacks.add(new ItemStack(EnhancedGear.IRON_DRILL));
                stacks.add(new ItemStack(EnhancedGear.IRON_SUPERAXE));
                stacks.add(new ItemStack(EnhancedGear.IRON_EXCAVATOR));
                stacks.add(new ItemStack(EnhancedGear.IRON_PLOW));

                //Gold
                stacks.add(new ItemStack(EnhancedGear.GOLD_CRATER_CREATOR));
                stacks.add(new ItemStack(EnhancedGear.GOLD_DRILL));
                stacks.add(new ItemStack(EnhancedGear.GOLD_SUPERAXE));
                stacks.add(new ItemStack(EnhancedGear.GOLD_EXCAVATOR));
                stacks.add(new ItemStack(EnhancedGear.GOLD_PLOW));

                //Diamond
                stacks.add(new ItemStack(EnhancedGear.DIAMOND_CRATER_CREATOR));
                stacks.add(new ItemStack(EnhancedGear.DIAMOND_DRILL));
                stacks.add(new ItemStack(EnhancedGear.DIAMOND_SUPERAXE));
                stacks.add(new ItemStack(EnhancedGear.DIAMOND_EXCAVATOR));
                stacks.add(new ItemStack(EnhancedGear.DIAMOND_PLOW));
            })
            .build();
    /*
    This next area is for item definitions, which I have put all of the settings into.
    Their respective classes are only used for the constructors and any extra functionality to be added to the item.
     */

    //Emerald tools
    public static final EmeraldTool EmeraldTool = new EmeraldTool();
    public static final EmeraldSword EMERALD_SWORD = new EmeraldSword(EmeraldTool, 3, -2.4f, new Item.Settings().group(GROUP));
    public static final EmeraldPickaxe EMERALD_PICKAXE = new EmeraldPickaxe(EmeraldTool, 1, -2.8f, new Item.Settings().group(GROUP));
    public static final EmeraldAxe EMERALD_AXE = new EmeraldAxe(EmeraldTool, 5, -3, new Item.Settings().group(GROUP));
    public static final EmeraldShovel EMERALD_SHOVEL = new EmeraldShovel(EmeraldTool, 1.5f, -3f, new Item.Settings().group(GROUP));
    public static final EmeraldHoe EMERALD_HOE = new EmeraldHoe(EmeraldTool, -2.8f, new Item.Settings().group(GROUP));

    //Emerald armor
    public static final EmeraldArmor EmeraldArmor = new EmeraldArmor();
    public static final EmeraldArmorBase EMERALD_HELMET = new EmeraldArmorBase(EmeraldArmor, EquipmentSlot.HEAD, new Item.Settings().group(GROUP));
    public static final EmeraldArmorBase EMERALD_CHESTPLATE = new EmeraldArmorBase(EmeraldArmor, EquipmentSlot.CHEST, new Item.Settings().group(GROUP));
    public static final EmeraldArmorBase EMERALD_LEGGINGS = new EmeraldArmorBase(EmeraldArmor, EquipmentSlot.LEGS, new Item.Settings().group(GROUP));
    public static final EmeraldArmorBase EMERALD_BOOTS = new EmeraldArmorBase(EmeraldArmor, EquipmentSlot.FEET, new Item.Settings().group(GROUP));

    //Obsidian tools
    public static final ObsidianTool ObsidianTool = new ObsidianTool();
    public static final ObsidianSword OBSIDIAN_SWORD = new ObsidianSword(ObsidianTool, 3, -2.4f, new Item.Settings().group(GROUP));
    public static final ObsidianPickaxe OBSIDIAN_PICKAXE = new ObsidianPickaxe(ObsidianTool, 1, -2.8f, new Item.Settings().group(GROUP));
    public static final ObsidianAxe OBSIDIAN_AXE = new ObsidianAxe(ObsidianTool, 5f, -3f, new Item.Settings().group(GROUP));
    public static final ObsidianShovel OBSIDIAN_SHOVEL = new ObsidianShovel(ObsidianTool, 1.5f, -3f, new Item.Settings().group(GROUP));
    public static final ObsidianHoe OBSIDIAN_HOE = new ObsidianHoe(ObsidianTool, -2.8f, new Item.Settings().group(GROUP));

    //Obsidian armor
    public static final ObsidianArmor ObsidianArmor = new ObsidianArmor();
    public static final ObsidianArmorBase OBSIDIAN_HELMET = new ObsidianArmorBase(ObsidianArmor, EquipmentSlot.HEAD, new Item.Settings().group(GROUP));
    public static final ObsidianArmorBase OBSIDIAN_CHESTPLATE = new ObsidianArmorBase(ObsidianArmor, EquipmentSlot.CHEST, new Item.Settings().group(GROUP));
    public static final ObsidianArmorBase OBSIDIAN_LEGGINGS = new ObsidianArmorBase(ObsidianArmor, EquipmentSlot.LEGS, new Item.Settings().group(GROUP));
    public static final ObsidianArmorBase OBSIDIAN_BOOTS = new ObsidianArmorBase(ObsidianArmor, EquipmentSlot.FEET, new Item.Settings().group(GROUP));

    //Ruby tools
    public static final RubyTool RubyTool = new RubyTool();
    public static final RubySword RUBY_SWORD = new RubySword(RubyTool, 3, -2.4f, new Item.Settings().group(GROUP));
    public static final RubyPickaxe RUBY_PICKAXE = new RubyPickaxe(RubyTool, 1, -2.8f, new Item.Settings().group(GROUP));
    public static final RubyAxe RUBY_AXE = new RubyAxe(RubyTool, 5, -3f, new Item.Settings().group(GROUP));
    public static final RubyShovel RUBY_SHOVEL = new RubyShovel(RubyTool, 1.5f, -3f, new Item.Settings().group(GROUP));
    public static final RubyHoe RUBY_HOE = new RubyHoe(RubyTool, -2.8f, new Item.Settings().group(GROUP));

    //Ruby armor
    public static final RubyArmor RubyArmor = new RubyArmor();
    public static final RubyArmorBase RUBY_HELMET = new RubyArmorBase(RubyArmor, EquipmentSlot.HEAD, new Item.Settings().group(GROUP));
    public static final RubyArmorBase RUBY_CHESTPLATE = new RubyArmorBase(RubyArmor, EquipmentSlot.CHEST, new Item.Settings().group(GROUP));
    public static final RubyArmorBase RUBY_LEGGINGS = new RubyArmorBase(RubyArmor, EquipmentSlot.LEGS, new Item.Settings().group(GROUP));
    public static final RubyArmorBase RUBY_BOOTS = new RubyArmorBase(RubyArmor, EquipmentSlot.FEET, new Item.Settings().group(GROUP));

    //Stone armor
    public static final StoneArmor StoneArmor = new StoneArmor();
    public static final StoneArmorBase STONE_HELMET = new StoneArmorBase(StoneArmor, EquipmentSlot.HEAD, new Item.Settings().group(GROUP));
    public static final StoneArmorBase STONE_VEST = new StoneArmorBase(StoneArmor, EquipmentSlot.CHEST, new Item.Settings().group(GROUP));
    public static final StoneArmorBase STONE_LEG_PLATING = new StoneArmorBase(StoneArmor, EquipmentSlot.LEGS, new Item.Settings().group(GROUP));
    public static final StoneArmorBase STONE_BOOTS = new StoneArmorBase(StoneArmor, EquipmentSlot.FEET, new Item.Settings().group(GROUP));

    //Ruby things
    public static final Ruby RUBY = new Ruby(new Item.Settings().group(GROUP));
    public static final Block RUBY_ORE = new RubyOre(FabricBlockSettings.of(Material.EARTH).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).strength(3, 3f));
    public static final Block RUBY_BLOCK = new RubyBlock(FabricBlockSettings.of(Material.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.METAL).strength(3, 3f));

    //Super tools
    
    //Iron
    public static final IronSupertool IronSupertool = new IronSupertool();
    public static final IronCraterCreator IRON_CRATER_CREATOR = new IronCraterCreator(IronSupertool, 4, -3.3f, new Item.Settings().group(SUPERTOOL_GROUP));
    public static final IronDrill IRON_DRILL = new IronDrill(IronSupertool, 4, -3.3f, new Item.Settings().group(SUPERTOOL_GROUP));
    public static final IronSuperaxe IRON_SUPERAXE = new IronSuperaxe(IronSupertool, 8, -3.5f, new Item.Settings().group(SUPERTOOL_GROUP));
    public static final IronExcavator IRON_EXCAVATOR = new IronExcavator(IronSupertool, 4.5f, -3.5f, new Item.Settings().group(SUPERTOOL_GROUP));
    public static final IronPlow IRON_PLOW = new IronPlow(IronSupertool, 4, new Item.Settings().group(SUPERTOOL_GROUP));

    //Gold
    public static final GoldSupertool GoldSupertool = new GoldSupertool();
    public static final GoldCraterCreator GOLD_CRATER_CREATOR = new GoldCraterCreator(GoldSupertool, 4, -3.3f, new Item.Settings().group(SUPERTOOL_GROUP));
    public static final GoldDrill GOLD_DRILL = new GoldDrill(GoldSupertool, 4, -3.3f, new Item.Settings().group(SUPERTOOL_GROUP));
    public static final GoldSuperaxe GOLD_SUPERAXE = new GoldSuperaxe(GoldSupertool, 8, -3.5f, new Item.Settings().group(SUPERTOOL_GROUP));
    public static final GoldExcavator GOLD_EXCAVATOR = new GoldExcavator(GoldSupertool, 4.5f, -3.5f, new Item.Settings().group(SUPERTOOL_GROUP));
    public static final GoldPlow GOLD_PLOW = new GoldPlow(GoldSupertool, 4, new Item.Settings().group(SUPERTOOL_GROUP));
    
    //Diamond
    public static final DiamondSupertool DiamondSupertool = new DiamondSupertool();
    public static final DiamondCraterCreator DIAMOND_CRATER_CREATOR = new DiamondCraterCreator(DiamondSupertool, 4, -3.3f, new Item.Settings().group(SUPERTOOL_GROUP));
    public static final DiamondDrill DIAMOND_DRILL = new DiamondDrill(DiamondSupertool, 4, -3.3f, new Item.Settings().group(SUPERTOOL_GROUP));
    public static final DiamondSuperaxe DIAMOND_SUPERAXE = new DiamondSuperaxe(DiamondSupertool, 8, -3.5f, new Item.Settings().group(SUPERTOOL_GROUP));
    public static final DiamondExcavator DIAMOND_EXCAVATOR = new DiamondExcavator(DiamondSupertool, 4.5f, -3.5f, new Item.Settings().group(SUPERTOOL_GROUP));
    public static final DiamondPlow DIAMOND_PLOW = new DiamondPlow(DiamondSupertool, 4, new Item.Settings().group(SUPERTOOL_GROUP));

    //Tags
    public static final Tag<Block> STONEY = TagRegistry.block(new Identifier(modid, "stoney"));
    public static final Tag<Block> ORES = TagRegistry.block(new Identifier(modid, "ores"));
    @Override
    public void onInitialize() {

        /*
        This section simply registers the items into the game,
        using the variables that have been defined above.

        new Identifier(modid, "item_name"), item_name is defining what item_name is identified as.
        For example, new Identifier(modid, "emerald_sword"), emerald_sword defines emerald_sword as enhancedgear:emerald_sword.
        The identifier is what you would type in the /give command to get the item.
         */

        //Emerald tools
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_sword"), EMERALD_SWORD);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_pickaxe"), EMERALD_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_axe"), EMERALD_AXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_shovel"), EMERALD_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_hoe"), EMERALD_HOE);

        //Obsidian tools
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_sword"), OBSIDIAN_SWORD);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_pickaxe"), OBSIDIAN_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_axe"), OBSIDIAN_AXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_shovel"), OBSIDIAN_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_hoe"), OBSIDIAN_HOE);

        //Ruby tools
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_sword"), RUBY_SWORD);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_pickaxe"), RUBY_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_axe"), RUBY_AXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_shovel"), RUBY_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_hoe"), RUBY_HOE);

        //Emerald armor
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_helmet"), EMERALD_HELMET);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_chestplate"), EMERALD_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_leggings"), EMERALD_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_boots"), EMERALD_BOOTS);

        //Obsidian armor
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_helmet"), OBSIDIAN_HELMET);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_chestplate"), OBSIDIAN_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_leggings"), OBSIDIAN_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_boots"), OBSIDIAN_BOOTS);

        //Ruby armor
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_helmet"), RUBY_HELMET);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_chestplate"), RUBY_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_leggings"), RUBY_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_boots"), RUBY_BOOTS);

        //Stone armor
        Registry.register(Registry.ITEM, new Identifier(modid, "stone_helmet"), STONE_HELMET);
        Registry.register(Registry.ITEM, new Identifier(modid, "stone_vest"), STONE_VEST);
        Registry.register(Registry.ITEM, new Identifier(modid, "stone_leg_plating"), STONE_LEG_PLATING);
        Registry.register(Registry.ITEM, new Identifier(modid, "stone_boots"), STONE_BOOTS);

        Registry.register(Registry.ITEM, new Identifier(modid, "ruby"), RUBY);

        //Both Block and BlockItem must be registered for it to be place-able and in the inventory
        Registry.register(Registry.BLOCK, new Identifier(modid, "ruby_ore"), RUBY_ORE);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_ore"), new BlockItem(RUBY_ORE, new Item.Settings().group(GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(modid, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_block"), new BlockItem(RUBY_BLOCK, new Item.Settings().group(GROUP)));

        //Super tools

        //Iron
        Registry.register(Registry.ITEM, new Identifier(modid, "iron_superaxe"), IRON_SUPERAXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "iron_crater_creator"), IRON_CRATER_CREATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "iron_drill"), IRON_DRILL);
        Registry.register(Registry.ITEM, new Identifier(modid, "iron_excavator"), IRON_EXCAVATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "iron_plow"), IRON_PLOW);

        //Gold
        Registry.register(Registry.ITEM, new Identifier(modid, "gold_superaxe"), GOLD_SUPERAXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "gold_crater_creator"), GOLD_CRATER_CREATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "gold_drill"), GOLD_DRILL);
        Registry.register(Registry.ITEM, new Identifier(modid, "gold_excavator"), GOLD_EXCAVATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "gold_plow"), GOLD_PLOW);

        //Diamond
        Registry.register(Registry.ITEM, new Identifier(modid, "diamond_superaxe"), DIAMOND_SUPERAXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "diamond_crater_creator"), DIAMOND_CRATER_CREATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "diamond_drill"), DIAMOND_DRILL);
        Registry.register(Registry.ITEM, new Identifier(modid, "diamond_excavator"), DIAMOND_EXCAVATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "diamond_plow"), DIAMOND_PLOW);

        //Cycles through all biomes, then checks for new ones. See handleBiome to see what they do for each biome
        Registry.BIOME.forEach(this::handleBiome);
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> handleBiome(biome));
    }
    //Generates blocks in whatever biome is put into it. Only does ruby_ore right now
    public void handleBiome(Biome biome) {
        if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
            biome.addFeature(
                    GenerationStep.Feature.UNDERGROUND_ORES,
                    Feature.ORE.configure(
                            new OreFeatureConfig(
                                    OreFeatureConfig.Target.NATURAL_STONE,
                                    RUBY_ORE.getDefaultState(),
                                    5        //maximum vein size
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
    public static void veinMiner(BlockPos pos, Block block, Tag <Block> canMine, World world, ItemStack stack, LivingEntity miner) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                for (int z = -1; z < 2; z++) {
                    BlockPos current = pos.add(x, y, z);
                    BlockState state = world.getBlockState(current);
                    Block currentBlock = state.getBlock();
                    if (canMine.contains(block)) {
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
    public static void cubeMiner(BlockPos pos, Tag<Block> canMine, World world, int diameter, ItemStack stack, LivingEntity miner) {
        int min = (diameter / 2) * -1;
        int max = (min * -1) + 1;
        for (int x = min; x < max; x++) {
            for (int y = min; y < max; y++) {
                for (int z = min; z < max; z++) {
                    BlockPos current = pos.add(x, y, z);
                    BlockState state = world.getBlockState(current);
                    Block block = state.getBlock();
                    if (canMine.contains(block)) {
                        if (stack.getDamage() < stack.getMaxDamage()) {
                            world.breakBlock(current, true);
                            stack.damage(1, miner, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                        }
                    }
                }
            }
        }
    }
    public static void cubeMiner(BlockPos pos, Item toolType, World world, int diameter, ItemStack stack, LivingEntity miner) {
        int min = (diameter / 2) * -1;
        int max = (min * -1) + 1;
        for (int x = min; x < max; x++) {
            for (int y = min; y < max; y++) {
                for (int z = min; z < max; z++) {
                    BlockPos current = pos.add(x, y, z);
                    BlockState state = world.getBlockState(current);
                    if (toolType.getMiningSpeed(stack, state) > 1) {
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
                    if ((block.equals(Blocks.DIRT) && (world.getBlockState(current.up()).getBlock().equals(Blocks.AIR) || world.getBlockState(current.up()).getBlock().equals(Blocks.CAVE_AIR)))
                            || (block.equals(Blocks.GRASS_BLOCK) && (world.getBlockState(current.up()).getBlock().equals(Blocks.AIR) || world.getBlockState(current.up()).getBlock().equals(Blocks.CAVE_AIR)))) {
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