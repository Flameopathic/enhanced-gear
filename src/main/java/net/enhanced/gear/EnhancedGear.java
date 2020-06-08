package net.enhanced.gear;

import net.enhanced.gear.armor.EmeraldArmorBase;
import net.enhanced.gear.armor.ObsidianArmorBase;
import net.enhanced.gear.armor.RubyArmorBase;
import net.enhanced.gear.armor.StoneArmorBase;
import net.enhanced.gear.blocks.RubyBlock;
import net.enhanced.gear.blocks.RubyOre;
import net.enhanced.gear.items.Ruby;
import net.enhanced.gear.items.tools.*;
import net.enhanced.gear.materials.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class EnhancedGear implements ModInitializer {

    //Something to lessen typing
    public static final String modid = "enhancedgear";

    //Main group with all modded items in it
    public static final ItemGroup GROUP = FabricItemGroupBuilder.create(new Identifier(modid, "group"))
            .icon(() -> new ItemStack(EnhancedGear.obsidian_chestplate))
            .appendItems(stacks ->
            {
                /*
                Items in here are in the custom group.
                Their order dictates their order in the group.
                ItemStack.EMPTY will make an open slot
                 */

                //Emerald armor
                stacks.add(new ItemStack(EnhancedGear.emerald_helmet));
                stacks.add(new ItemStack(EnhancedGear.emerald_chestplate));
                stacks.add(new ItemStack(EnhancedGear.emerald_leggings));
                stacks.add(new ItemStack(EnhancedGear.emerald_boots));

                //Emerald tools
                stacks.add(new ItemStack(EnhancedGear.emerald_sword));
                stacks.add(new ItemStack(EnhancedGear.emerald_pickaxe));
                stacks.add(new ItemStack(EnhancedGear.emerald_axe));
                stacks.add(new ItemStack(EnhancedGear.emerald_shovel));
                stacks.add(new ItemStack(EnhancedGear.emerald_hoe));

                //Obsidian armor
                stacks.add(new ItemStack(EnhancedGear.obsidian_helmet));
                stacks.add(new ItemStack(EnhancedGear.obsidian_chestplate));
                stacks.add(new ItemStack(EnhancedGear.obsidian_leggings));
                stacks.add(new ItemStack(EnhancedGear.obsidian_boots));

                //Obsidian tools
                stacks.add(new ItemStack(EnhancedGear.obsidian_sword));
                stacks.add(new ItemStack(EnhancedGear.obsidian_pickaxe));
                stacks.add(new ItemStack(EnhancedGear.obsidian_axe));
                stacks.add(new ItemStack(EnhancedGear.obsidian_shovel));
                stacks.add(new ItemStack(EnhancedGear.obsidian_hoe));

                //Ruby armor
                stacks.add(new ItemStack(EnhancedGear.ruby_helmet));
                stacks.add(new ItemStack(EnhancedGear.ruby_chestplate));
                stacks.add(new ItemStack(EnhancedGear.ruby_leggings));
                stacks.add(new ItemStack(EnhancedGear.ruby_boots));

                //Ruby tools
                stacks.add(new ItemStack(EnhancedGear.ruby_sword));
                stacks.add(new ItemStack(EnhancedGear.ruby_pickaxe));
                stacks.add(new ItemStack(EnhancedGear.ruby_axe));
                stacks.add(new ItemStack(EnhancedGear.ruby_shovel));
                stacks.add(new ItemStack(EnhancedGear.ruby_hoe));

                //Stone armor
                stacks.add(new ItemStack(EnhancedGear.stone_helmet));
                stacks.add(new ItemStack(EnhancedGear.stone_vest));
                stacks.add(new ItemStack(EnhancedGear.stone_leg_plating));
                stacks.add(new ItemStack(EnhancedGear.stone_boots));

                //Other
                stacks.add(new ItemStack(EnhancedGear.ruby));
                stacks.add(new ItemStack(EnhancedGear.ruby_ore));
                stacks.add(new ItemStack(EnhancedGear.ruby_block));
            })
            .build();
    /*
    This next area is for item definitions, which I have put all of the settings into.
    Their respective classes are only used for the constructors and any extra functionality to be added to the item.
     */

    //Emerald tools
    public static final EmeraldSword emerald_sword = new EmeraldSword(new EmeraldTool(), 3, -2.4f, new Item.Settings().group(GROUP));
    public static final EmeraldPickaxe emerald_pickaxe = new EmeraldPickaxe(new EmeraldTool(), 3, -2.8f, new Item.Settings().group(GROUP));
    public static final EmeraldAxe emerald_axe = new EmeraldAxe(new EmeraldTool(), 5, -3, new Item.Settings().group(GROUP));
    public static final EmeraldShovel emerald_shovel = new EmeraldShovel(new EmeraldTool(), 1.5f, -3f, new Item.Settings().group(GROUP));
    public static final EmeraldHoe emerald_hoe = new EmeraldHoe(new EmeraldTool(), -2.8f, new Item.Settings().group(GROUP));

    //Emerald armor
    public static final EmeraldArmorBase emerald_helmet = new EmeraldArmorBase(new EmeraldArmor(), EquipmentSlot.HEAD, new Item.Settings().group(GROUP));
    public static final EmeraldArmorBase emerald_chestplate = new EmeraldArmorBase(new EmeraldArmor(), EquipmentSlot.CHEST, new Item.Settings().group(GROUP));
    public static final EmeraldArmorBase emerald_leggings = new EmeraldArmorBase(new EmeraldArmor(), EquipmentSlot.LEGS, new Item.Settings().group(GROUP));
    public static final EmeraldArmorBase emerald_boots = new EmeraldArmorBase(new EmeraldArmor(), EquipmentSlot.FEET, new Item.Settings().group(GROUP));

    //Obsidian tools
    public static final ObsidianSword obsidian_sword = new ObsidianSword(new ObsidianTool(), 3, -2.4f, new Item.Settings().group(GROUP));
    public static final ObsidianPickaxe obsidian_pickaxe = new ObsidianPickaxe(new ObsidianTool(), 3, -2.8f, new Item.Settings().group(GROUP));
    public static final ObsidianAxe obsidian_axe = new ObsidianAxe(new ObsidianTool(), 5f, -3f, new Item.Settings().group(GROUP));
    public static final ObsidianShovel obsidian_shovel = new ObsidianShovel(new ObsidianTool(), 1.5f, -3f, new Item.Settings().group(GROUP));
    public static final ObsidianHoe obsidian_hoe = new ObsidianHoe(new ObsidianTool(), -2.8f, new Item.Settings().group(GROUP));

    //Obsidian armor
    public static final ObsidianArmorBase obsidian_helmet = new ObsidianArmorBase(new ObsidianArmor(), EquipmentSlot.HEAD, new Item.Settings().group(GROUP));
    public static final ObsidianArmorBase obsidian_chestplate = new ObsidianArmorBase(new ObsidianArmor(), EquipmentSlot.CHEST, new Item.Settings().group(GROUP));
    public static final ObsidianArmorBase obsidian_leggings = new ObsidianArmorBase(new ObsidianArmor(), EquipmentSlot.LEGS, new Item.Settings().group(GROUP));
    public static final ObsidianArmorBase obsidian_boots = new ObsidianArmorBase(new ObsidianArmor(), EquipmentSlot.FEET, new Item.Settings().group(GROUP));

    //Ruby tools
    public static final RubySword ruby_sword = new RubySword(new RubyTool(), 3, -2.4f, new Item.Settings().group(GROUP));
    public static final RubyPickaxe ruby_pickaxe = new RubyPickaxe(new RubyTool(), 3, -2.8f, new Item.Settings().group(GROUP));
    public static final RubyAxe ruby_axe = new RubyAxe(new RubyTool(), 5f, -3f, new Item.Settings().group(GROUP));
    public static final RubyShovel ruby_shovel = new RubyShovel(new RubyTool(), 1.5f, -3f, new Item.Settings().group(GROUP));
    public static final RubyHoe ruby_hoe = new RubyHoe(new RubyTool(), -2.8f, new Item.Settings().group(GROUP));

    //Ruby armor
    public static final RubyArmorBase ruby_helmet = new RubyArmorBase(new RubyArmor(), EquipmentSlot.HEAD, new Item.Settings().group(GROUP));
    public static final RubyArmorBase ruby_chestplate = new RubyArmorBase(new RubyArmor(), EquipmentSlot.CHEST, new Item.Settings().group(GROUP));
    public static final RubyArmorBase ruby_leggings = new RubyArmorBase(new RubyArmor(), EquipmentSlot.LEGS, new Item.Settings().group(GROUP));
    public static final RubyArmorBase ruby_boots = new RubyArmorBase(new RubyArmor(), EquipmentSlot.FEET, new Item.Settings().group(GROUP));

    //Stone armor
    public static final StoneArmorBase stone_helmet = new StoneArmorBase(new StoneArmor(), EquipmentSlot.HEAD, new Item.Settings().group(GROUP));
    public static final StoneArmorBase stone_vest = new StoneArmorBase(new StoneArmor(), EquipmentSlot.CHEST, new Item.Settings().group(GROUP));
    public static final StoneArmorBase stone_leg_plating = new StoneArmorBase(new StoneArmor(), EquipmentSlot.LEGS, new Item.Settings().group(GROUP));
    public static final StoneArmorBase stone_boots = new StoneArmorBase(new StoneArmor(), EquipmentSlot.FEET, new Item.Settings().group(GROUP));

    public static final Ruby ruby = new Ruby(new Item.Settings().group(GROUP));

    public static final Block ruby_ore = new RubyOre(FabricBlockSettings.of(Material.EARTH).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.STONE).strength(3, 3f));
    public static final Block ruby_block = new RubyBlock(FabricBlockSettings.of(Material.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES).sounds(BlockSoundGroup.METAL).strength(3, 3f));
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
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_sword"), emerald_sword);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_pickaxe"), emerald_pickaxe);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_axe"), emerald_axe);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_shovel"), emerald_shovel);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_hoe"), emerald_hoe);

        //Obsidian tools
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_sword"), obsidian_sword);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_pickaxe"), obsidian_pickaxe);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_axe"), obsidian_axe);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_shovel"), obsidian_shovel);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_hoe"), obsidian_hoe);

        //Ruby tools
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_sword"), ruby_sword);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_pickaxe"), ruby_pickaxe);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_axe"), ruby_axe);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_shovel"), ruby_shovel);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_hoe"), ruby_hoe);

        //Emerald armor
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_helmet"), emerald_helmet);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_chestplate"), emerald_chestplate);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_leggings"), emerald_leggings);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_boots"), emerald_boots);

        //Obsidian armor
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_helmet"), obsidian_helmet);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_chestplate"), obsidian_chestplate);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_leggings"), obsidian_leggings);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_boots"), obsidian_boots);

        //Ruby armor
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_helmet"), ruby_helmet);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_chestplate"), ruby_chestplate);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_leggings"), ruby_leggings);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_boots"), ruby_boots);

        //Stone armor
        Registry.register(Registry.ITEM, new Identifier(modid, "stone_helmet"), stone_helmet);
        Registry.register(Registry.ITEM, new Identifier(modid, "stone_vest"), stone_vest);
        Registry.register(Registry.ITEM, new Identifier(modid, "stone_leg_plating"), stone_leg_plating);
        Registry.register(Registry.ITEM, new Identifier(modid, "stone_boots"), stone_boots);

        Registry.register(Registry.ITEM, new Identifier(modid, "ruby"), ruby);

        //Both Block and BlockItem must be registered for it to be place-able and in the inventory
        Registry.register(Registry.BLOCK, new Identifier(modid, "ruby_ore"), ruby_ore);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_ore"), new BlockItem(ruby_ore, new Item.Settings().group(GROUP)));
        Registry.register(Registry.BLOCK, new Identifier(modid, "ruby_block"), ruby_block);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_block"), new BlockItem(ruby_block, new Item.Settings().group(GROUP)));

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
                                    ruby_ore.getDefaultState(),
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
}