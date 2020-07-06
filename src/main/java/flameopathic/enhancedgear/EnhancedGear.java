package flameopathic.enhancedgear;

import flameopathic.enhancedgear.armor.*;
import flameopathic.enhancedgear.blocks.*;
import flameopathic.enhancedgear.items.EnderiteCrystal;
import flameopathic.enhancedgear.items.Onyx;
import flameopathic.enhancedgear.items.Ruby;
import flameopathic.enhancedgear.items.supertools.diamond.*;
import flameopathic.enhancedgear.items.supertools.emerald.*;
import flameopathic.enhancedgear.items.supertools.enderite.*;
import flameopathic.enhancedgear.items.supertools.gold.*;
import flameopathic.enhancedgear.items.supertools.iron.*;
import flameopathic.enhancedgear.items.supertools.netherite.*;
import flameopathic.enhancedgear.items.supertools.obsidian.ObsidianCraterCreator;
import flameopathic.enhancedgear.items.supertools.obsidian.ObsidianDrill;
import flameopathic.enhancedgear.items.supertools.ruby.*;
import flameopathic.enhancedgear.items.tools.emerald.*;
import flameopathic.enhancedgear.items.tools.enderite.*;
import flameopathic.enhancedgear.items.tools.obsidian.*;
import flameopathic.enhancedgear.items.tools.ruby.*;
import flameopathic.enhancedgear.materials.armormaterials.*;
import flameopathic.enhancedgear.materials.supertoolmaterials.*;
import flameopathic.enhancedgear.materials.toolmaterials.EmeraldTool;
import flameopathic.enhancedgear.materials.toolmaterials.ObsidianTool;
import flameopathic.enhancedgear.materials.toolmaterials.RubyTool;
import flameopathic.enhancedgear.util.CustomOreFeatureConfig;
import flameopathic.enhancedgear.util.Util;
import flameopathic.enhancedgear.enchantments.Cultivation;
import flameopathic.enhancedgear.enchantments.Pathmaker;
import flameopathic.enhancedgear.items.EnderiteShard;
import flameopathic.enhancedgear.items.supertools.obsidian.ObsidianExcavator;
import flameopathic.enhancedgear.items.supertools.obsidian.ObsidianPlow;
import flameopathic.enhancedgear.items.supertools.obsidian.ObsidianBattleAxe;
import flameopathic.enhancedgear.materials.toolmaterials.EnderiteTool;
import flameopathic.enhancedgear.networking.NetherPortalPacket;
import flameopathic.enhancedgear.util.CustomOreFeature;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.Map;

import static flameopathic.enhancedgear.networking.NetherPortalPacket.NETHER_PORTAL_PACKET;

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

                //Enderite armor
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_HELMET));
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_CHESTPLATE));
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_LEGGINGS));
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_BOOTS));

                //Enderite tools
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_SWORD));
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_PICKAXE));
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_AXE));
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_SHOVEL));
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_HOE));

                //Stone armor
                stacks.add(new ItemStack(EnhancedGear.STONE_HELMET));
                stacks.add(new ItemStack(EnhancedGear.STONE_VEST));
                stacks.add(new ItemStack(EnhancedGear.STONE_LEG_PLATING));
                stacks.add(new ItemStack(EnhancedGear.STONE_BOOTS));

                //Items
                stacks.add(new ItemStack(EnhancedGear.RUBY));
                stacks.add(new ItemStack(EnhancedGear.ONYX));
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_SHARD));
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_CRYSTAL));

                //Blocks
                stacks.add(new ItemStack(EnhancedGear.RUBY_ORE));
                stacks.add(new ItemStack(EnhancedGear.RUBY_BLOCK));
                stacks.add(new ItemStack(EnhancedGear.COMPRESSED_OBSIDIAN));
                stacks.add(new ItemStack(EnhancedGear.FRACTURED_END_STONE));
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_BLOCK));
            })
            .build();

    public static final ItemGroup SUPERTOOL_GROUP = FabricItemGroupBuilder.create(new Identifier(modid, "supertool_group"))
            .icon(() -> new ItemStack(EnhancedGear.IRON_CRATER_CREATOR))
            .appendItems(stacks ->
            {
                //Iron
                stacks.add(new ItemStack(EnhancedGear.IRON_CRATER_CREATOR));
                stacks.add(new ItemStack(EnhancedGear.IRON_DRILL));
                stacks.add(new ItemStack(EnhancedGear.IRON_BATTLE_AXE));
                stacks.add(new ItemStack(EnhancedGear.IRON_EXCAVATOR));
                stacks.add(new ItemStack(EnhancedGear.IRON_PLOW));

                //Gold
                stacks.add(new ItemStack(EnhancedGear.GOLDEN_CRATER_CREATOR));
                stacks.add(new ItemStack(EnhancedGear.GOLDEN_DRILL));
                stacks.add(new ItemStack(EnhancedGear.GOLDEN_BATTLE_AXE));
                stacks.add(new ItemStack(EnhancedGear.GOLDEN_EXCAVATOR));
                stacks.add(new ItemStack(EnhancedGear.GOLDEN_PLOW));

                //Diamond
                stacks.add(new ItemStack(EnhancedGear.DIAMOND_CRATER_CREATOR));
                stacks.add(new ItemStack(EnhancedGear.DIAMOND_DRILL));
                stacks.add(new ItemStack(EnhancedGear.DIAMOND_BATTLE_AXE));
                stacks.add(new ItemStack(EnhancedGear.DIAMOND_EXCAVATOR));
                stacks.add(new ItemStack(EnhancedGear.DIAMOND_PLOW));

                //Netherite
                stacks.add(new ItemStack(EnhancedGear.NETHERITE_CRATER_CREATOR));
                stacks.add(new ItemStack(EnhancedGear.NETHERITE_DRILL));
                stacks.add(new ItemStack(EnhancedGear.NETHERITE_BATTLE_AXE));
                stacks.add(new ItemStack(EnhancedGear.NETHERITE_EXCAVATOR));
                stacks.add(new ItemStack(EnhancedGear.NETHERITE_PLOW));

                //Emerald
                stacks.add(new ItemStack(EnhancedGear.EMERALD_CRATER_CREATOR));
                stacks.add(new ItemStack(EnhancedGear.EMERALD_DRILL));
                stacks.add(new ItemStack(EnhancedGear.EMERALD_BATTLE_AXE));
                stacks.add(new ItemStack(EnhancedGear.EMERALD_EXCAVATOR));
                stacks.add(new ItemStack(EnhancedGear.EMERALD_PLOW));

                //Ruby
                stacks.add(new ItemStack(EnhancedGear.RUBY_CRATER_CREATOR));
                stacks.add(new ItemStack(EnhancedGear.RUBY_DRILL));
                stacks.add(new ItemStack(EnhancedGear.RUBY_BATTLE_AXE));
                stacks.add(new ItemStack(EnhancedGear.RUBY_EXCAVATOR));
                stacks.add(new ItemStack(EnhancedGear.RUBY_PLOW));

                //Obsidian
                stacks.add(new ItemStack(EnhancedGear.OBSIDIAN_CRATER_CREATOR));
                stacks.add(new ItemStack(EnhancedGear.OBSIDIAN_DRILL));
                stacks.add(new ItemStack(EnhancedGear.OBSIDIAN_BATTLE_AXE));
                stacks.add(new ItemStack(EnhancedGear.OBSIDIAN_EXCAVATOR));
                stacks.add(new ItemStack(EnhancedGear.OBSIDIAN_PLOW));

                //Obsidian
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_CRATER_CREATOR));
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_DRILL));
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_BATTLE_AXE));
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_EXCAVATOR));
                stacks.add(new ItemStack(EnhancedGear.ENDERITE_PLOW));
            })
            .build();
    /*
    This next area is for definitions, which I have put all of the settings into.
    Their respective classes are only used for the constructors and any extra functionality to be added to the item.
    */

    //Group simplification
    public static final Item.Settings MAIN = new Item.Settings().group(GROUP);
    public static final Item.Settings SUPERTOOL = new Item.Settings().group(SUPERTOOL_GROUP);

    //Emerald tools
    public static final flameopathic.enhancedgear.materials.toolmaterials.EmeraldTool EmeraldTool = new EmeraldTool();
    public static final EmeraldSword EMERALD_SWORD = new EmeraldSword(EmeraldTool, 3, -2.4f, MAIN);
    public static final EmeraldPickaxe EMERALD_PICKAXE = new EmeraldPickaxe(EmeraldTool, 1, -3f, MAIN);
    public static final EmeraldAxe EMERALD_AXE = new EmeraldAxe(EmeraldTool, 5, -3, MAIN);
    public static final EmeraldShovel EMERALD_SHOVEL = new EmeraldShovel(EmeraldTool, 1.5f, -3f, MAIN);
    public static final EmeraldHoe EMERALD_HOE = new EmeraldHoe(EmeraldTool, -3, 3f, MAIN);

    //Emerald armor
    public static final flameopathic.enhancedgear.materials.armormaterials.EmeraldArmor EmeraldArmor = new EmeraldArmor();
    public static final EmeraldArmorBase EMERALD_HELMET = new EmeraldArmorBase(EmeraldArmor, EquipmentSlot.HEAD, MAIN);
    public static final EmeraldArmorBase EMERALD_CHESTPLATE = new EmeraldArmorBase(EmeraldArmor, EquipmentSlot.CHEST, MAIN);
    public static final EmeraldArmorBase EMERALD_LEGGINGS = new EmeraldArmorBase(EmeraldArmor, EquipmentSlot.LEGS, MAIN);
    public static final EmeraldArmorBase EMERALD_BOOTS = new EmeraldArmorBase(EmeraldArmor, EquipmentSlot.FEET, MAIN);

    //Obsidian tools
    public static final flameopathic.enhancedgear.materials.toolmaterials.ObsidianTool ObsidianTool = new ObsidianTool();
    public static final ObsidianSword OBSIDIAN_SWORD = new ObsidianSword(ObsidianTool, 3, -2.4f, MAIN);
    public static final ObsidianPickaxe OBSIDIAN_PICKAXE = new ObsidianPickaxe(ObsidianTool, 1, -3f, MAIN);
    public static final ObsidianAxe OBSIDIAN_AXE = new ObsidianAxe(ObsidianTool, 5f, -3f, MAIN);
    public static final ObsidianShovel OBSIDIAN_SHOVEL = new ObsidianShovel(ObsidianTool, 1.5f, -3f, MAIN);
    public static final ObsidianHoe OBSIDIAN_HOE = new ObsidianHoe(ObsidianTool, -3, 3f, MAIN);

    //Obsidian armor
    public static final flameopathic.enhancedgear.materials.armormaterials.ObsidianArmor ObsidianArmor = new ObsidianArmor();
    public static final ObsidianArmorBase OBSIDIAN_HELMET = new ObsidianArmorBase(ObsidianArmor, EquipmentSlot.HEAD, MAIN);
    public static final ObsidianArmorBase OBSIDIAN_CHESTPLATE = new ObsidianArmorBase(ObsidianArmor, EquipmentSlot.CHEST, MAIN);
    public static final ObsidianArmorBase OBSIDIAN_LEGGINGS = new ObsidianArmorBase(ObsidianArmor, EquipmentSlot.LEGS, MAIN);
    public static final ObsidianArmorBase OBSIDIAN_BOOTS = new ObsidianArmorBase(ObsidianArmor, EquipmentSlot.FEET, MAIN);

    //Ruby tools
    public static final flameopathic.enhancedgear.materials.toolmaterials.RubyTool RubyTool = new RubyTool();
    public static final RubySword RUBY_SWORD = new RubySword(RubyTool, 3, -2.4f, MAIN);
    public static final RubyPickaxe RUBY_PICKAXE = new RubyPickaxe(RubyTool, 1, -3f, MAIN);
    public static final RubyAxe RUBY_AXE = new RubyAxe(RubyTool, 5, -3f, MAIN);
    public static final RubyShovel RUBY_SHOVEL = new RubyShovel(RubyTool, 1.5f, -3f, MAIN);
    public static final RubyHoe RUBY_HOE = new RubyHoe(RubyTool, -3, 3f, MAIN);

    //Ruby armor
    public static final flameopathic.enhancedgear.materials.armormaterials.RubyArmor RubyArmor = new RubyArmor();
    public static final RubyArmorBase RUBY_HELMET = new RubyArmorBase(RubyArmor, EquipmentSlot.HEAD, MAIN);
    public static final RubyArmorBase RUBY_CHESTPLATE = new RubyArmorBase(RubyArmor, EquipmentSlot.CHEST, MAIN);
    public static final RubyArmorBase RUBY_LEGGINGS = new RubyArmorBase(RubyArmor, EquipmentSlot.LEGS, MAIN);
    public static final RubyArmorBase RUBY_BOOTS = new RubyArmorBase(RubyArmor, EquipmentSlot.FEET, MAIN);

    //Enderite tools
    public static final EnderiteTool EnderiteTool = new EnderiteTool();
    public static final EnderiteSword ENDERITE_SWORD = new EnderiteSword(EnderiteTool, 3, -2.4f, MAIN);
    public static final EnderitePickaxe ENDERITE_PICKAXE = new EnderitePickaxe(EnderiteTool, 1, -3f, MAIN);
    public static final EnderiteAxe ENDERITE_AXE = new EnderiteAxe(EnderiteTool, 5, -3, MAIN);
    public static final EnderiteShovel ENDERITE_SHOVEL = new EnderiteShovel(EnderiteTool, 1.5f, -3f, MAIN);
    public static final EnderiteHoe ENDERITE_HOE = new EnderiteHoe(EnderiteTool, -3, 3f, MAIN);

    //Enderite armor
    public static final flameopathic.enhancedgear.materials.armormaterials.EnderiteArmor EnderiteArmor = new EnderiteArmor();
    public static final EnderiteArmorBase ENDERITE_HELMET = new EnderiteArmorBase(EnderiteArmor, EquipmentSlot.HEAD, MAIN);
    public static final EnderiteArmorBase ENDERITE_CHESTPLATE = new EnderiteArmorBase(EnderiteArmor, EquipmentSlot.CHEST, MAIN);
    public static final EnderiteArmorBase ENDERITE_LEGGINGS = new EnderiteArmorBase(EnderiteArmor, EquipmentSlot.LEGS, MAIN);
    public static final EnderiteArmorBase ENDERITE_BOOTS = new EnderiteArmorBase(EnderiteArmor, EquipmentSlot.FEET, MAIN);

    //Stone armor
    public static final flameopathic.enhancedgear.materials.armormaterials.StoneArmor StoneArmor = new StoneArmor();
    public static final StoneArmorBase STONE_HELMET = new StoneArmorBase(StoneArmor, EquipmentSlot.HEAD, MAIN);
    public static final StoneArmorBase STONE_VEST = new StoneArmorBase(StoneArmor, EquipmentSlot.CHEST, MAIN);
    public static final StoneArmorBase STONE_LEG_PLATING = new StoneArmorBase(StoneArmor, EquipmentSlot.LEGS, MAIN);
    public static final StoneArmorBase STONE_BOOTS = new StoneArmorBase(StoneArmor, EquipmentSlot.FEET, MAIN);

    //Supertools
    //Iron
    public static final flameopathic.enhancedgear.materials.supertoolmaterials.IronSupertool IronSupertool = new IronSupertool();
    public static final IronCraterCreator IRON_CRATER_CREATOR = new IronCraterCreator(IronSupertool, 4, -3.3f, SUPERTOOL);
    public static final IronDrill IRON_DRILL = new IronDrill(IronSupertool, 4, -3.3f, SUPERTOOL);
    public static final IronBattleAxe IRON_BATTLE_AXE = new IronBattleAxe(IronSupertool, 8, -3.5f, SUPERTOOL);
    public static final IronExcavator IRON_EXCAVATOR = new IronExcavator(IronSupertool, 4.5f, -3.5f, SUPERTOOL);
    public static final IronPlow IRON_PLOW = new IronPlow(IronSupertool, 4, -3.5f, SUPERTOOL);

    //Gold
    public static final GoldenSupertool GoldenSupertool = new GoldenSupertool();
    public static final GoldenCraterCreator GOLDEN_CRATER_CREATOR = new GoldenCraterCreator(GoldenSupertool, 4, -3.3f, SUPERTOOL);
    public static final GoldenDrill GOLDEN_DRILL = new GoldenDrill(GoldenSupertool, 4, -3.3f, SUPERTOOL);
    public static final GoldenBattleAxe GOLDEN_BATTLE_AXE = new GoldenBattleAxe(GoldenSupertool, 8, -3.5f, SUPERTOOL);
    public static final GoldenExcavator GOLDEN_EXCAVATOR = new GoldenExcavator(GoldenSupertool, 4.5f, -3.5f, SUPERTOOL);
    public static final GoldenPlow GOLDEN_PLOW = new GoldenPlow(GoldenSupertool, 4, -3.5f, SUPERTOOL);

    //Diamond
    public static final flameopathic.enhancedgear.materials.supertoolmaterials.DiamondSupertool DiamondSupertool = new DiamondSupertool();
    public static final DiamondCraterCreator DIAMOND_CRATER_CREATOR = new DiamondCraterCreator(DiamondSupertool, 4, -3.3f, SUPERTOOL);
    public static final DiamondDrill DIAMOND_DRILL = new DiamondDrill(DiamondSupertool, 4, -3.3f, SUPERTOOL);
    public static final DiamondBattleAxe DIAMOND_BATTLE_AXE = new DiamondBattleAxe(DiamondSupertool, 8, -3.5f, SUPERTOOL);
    public static final DiamondExcavator DIAMOND_EXCAVATOR = new DiamondExcavator(DiamondSupertool, 4.5f, -3.5f, SUPERTOOL);
    public static final DiamondPlow DIAMOND_PLOW = new DiamondPlow(DiamondSupertool, 4, -3.5f, SUPERTOOL);

    //Emerald
    public static final flameopathic.enhancedgear.materials.supertoolmaterials.EmeraldSupertool EmeraldSupertool = new EmeraldSupertool();
    public static final EmeraldCraterCreator EMERALD_CRATER_CREATOR = new EmeraldCraterCreator(EmeraldSupertool, 4, -3.3f, SUPERTOOL);
    public static final EmeraldDrill EMERALD_DRILL = new EmeraldDrill(EmeraldSupertool, 4, -3.3f, SUPERTOOL);
    public static final EmeraldBattleAxe EMERALD_BATTLE_AXE = new EmeraldBattleAxe(EmeraldSupertool, 8, -3.5f, SUPERTOOL);
    public static final EmeraldExcavator EMERALD_EXCAVATOR = new EmeraldExcavator(EmeraldSupertool, 4.5f, -3.5f, SUPERTOOL);
    public static final EmeraldPlow EMERALD_PLOW = new EmeraldPlow(EmeraldSupertool, 4, -3.5f, SUPERTOOL);

    //Ruby
    public static final flameopathic.enhancedgear.materials.supertoolmaterials.RubySupertool RubySupertool = new RubySupertool();
    public static final RubyCraterCreator RUBY_CRATER_CREATOR = new RubyCraterCreator(RubySupertool, 4, -3.3f, SUPERTOOL);
    public static final RubyDrill RUBY_DRILL = new RubyDrill(RubySupertool, 4, -3.3f, SUPERTOOL);
    public static final RubyBattleAxe RUBY_BATTLE_AXE = new RubyBattleAxe(RubySupertool, 8, -3.5f, SUPERTOOL);
    public static final RubyExcavator RUBY_EXCAVATOR = new RubyExcavator(RubySupertool, 4.5f, -3.5f, SUPERTOOL);
    public static final RubyPlow RUBY_PLOW = new RubyPlow(RubySupertool, 4, -3.5f, SUPERTOOL);

    //Obsidian
    public static final ObsidianSupertool ObsidianSupertool = new ObsidianSupertool();
    public static final ObsidianCraterCreator OBSIDIAN_CRATER_CREATOR = new ObsidianCraterCreator(ObsidianSupertool, 4, -3.3f, SUPERTOOL);
    public static final ObsidianDrill OBSIDIAN_DRILL = new ObsidianDrill(ObsidianSupertool, 4, -3.3f, SUPERTOOL);
    public static final ObsidianBattleAxe OBSIDIAN_BATTLE_AXE = new ObsidianBattleAxe(ObsidianSupertool, 8, -3.5f, SUPERTOOL);
    public static final ObsidianExcavator OBSIDIAN_EXCAVATOR = new ObsidianExcavator(ObsidianSupertool, 4.5f, -3.5f, SUPERTOOL);
    public static final ObsidianPlow OBSIDIAN_PLOW = new ObsidianPlow(ObsidianSupertool, 4, -3.5f, SUPERTOOL);

    //Netherite
    public static final NetheriteSupertool NetheriteSupertool = new NetheriteSupertool();
    public static final NetheriteCraterCreator NETHERITE_CRATER_CREATOR = new NetheriteCraterCreator(NetheriteSupertool, 5, -3.3f, SUPERTOOL);
    public static final NetheriteDrill NETHERITE_DRILL = new NetheriteDrill(NetheriteSupertool, 5, -3.3f, SUPERTOOL);
    public static final NetheriteBattleAxe NETHERITE_BATTLE_AXE = new NetheriteBattleAxe(NetheriteSupertool, 9, -3.5f, SUPERTOOL);
    public static final NetheriteExcavator NETHERITE_EXCAVATOR = new NetheriteExcavator(NetheriteSupertool, 5.5f, -3.5f, SUPERTOOL);
    public static final NetheritePlow NETHERITE_PLOW = new NetheritePlow(NetheriteSupertool, 5, -3.5f, SUPERTOOL);

    //Enderite
    public static final flameopathic.enhancedgear.materials.supertoolmaterials.EnderiteSupertool EnderiteSupertool = new EnderiteSupertool();
    public static final EnderiteCraterCreator ENDERITE_CRATER_CREATOR = new EnderiteCraterCreator(EnderiteSupertool, 4, -3.3f, SUPERTOOL);
    public static final EnderiteDrill ENDERITE_DRILL = new EnderiteDrill(EnderiteSupertool, 4, -3.3f, SUPERTOOL);
    public static final EnderiteBattleAxe ENDERITE_BATTLE_AXE = new EnderiteBattleAxe(EnderiteSupertool, 8, -3.5f, SUPERTOOL);
    public static final EnderiteExcavator ENDERITE_EXCAVATOR = new EnderiteExcavator(EnderiteSupertool, 4.5f, -3.5f, SUPERTOOL);
    public static final EnderitePlow ENDERITE_PLOW = new EnderitePlow(EnderiteSupertool, 4, -3.5f, SUPERTOOL);

    //Other Items
    public static final Ruby RUBY = new Ruby(MAIN);
    public static final EnderiteShard ENDERITE_SHARD = new EnderiteShard(MAIN);
    public static final EnderiteCrystal ENDERITE_CRYSTAL = new EnderiteCrystal(MAIN);
    public static final Onyx ONYX = new Onyx(MAIN);

    //Blocks
    public static final CompressedObsidian COMPRESSED_OBSIDIAN = new CompressedObsidian(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 3).sounds(BlockSoundGroup.STONE).strength(10, 10f).lightLevel(7));
    public static final FracturedEndStone FRACTURED_END_STONE = new FracturedEndStone(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 4).sounds(BlockSoundGroup.STONE).strength(5, 5f));
    public static final EnderiteBlock ENDERITE_BLOCK = new EnderiteBlock(FabricBlockSettings.of(Material.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.METAL).strength(10, 10f));
    public static final RubyOre RUBY_ORE = new RubyOre(FabricBlockSettings.of(Material.STONE).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.STONE).strength(3, 3f));
    public static final RubyBlock RUBY_BLOCK = new RubyBlock(FabricBlockSettings.of(Material.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES, 2).sounds(BlockSoundGroup.METAL).strength(3, 3f));

    //Enchantments
    public static final Cultivation CULTIVATION = new Cultivation(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.BREAKABLE, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    public static final Pathmaker PATHMAKER = new Pathmaker(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.BREAKABLE, new EquipmentSlot[] {EquipmentSlot.MAINHAND});

    //Tags
    public static final Tag<Block> STONEY = TagRegistry.block(new Identifier(modid, "stoney"));
    public static final Tag<Block> ORES = TagRegistry.block(new Identifier(modid, "ores"));
    public static final Tag<Item> PLOWS = TagRegistry.item(new Identifier(modid, "plows"));
    public static final Tag<Item> EXCAVATORS = TagRegistry.item(new Identifier(modid, "excavators"));

    //Other
    public static final CustomOreFeature CUSTOM_ORE_FEATURE = new CustomOreFeature(CustomOreFeatureConfig.CODEC);

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

        //Enderite tools
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_sword"), ENDERITE_SWORD);
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_pickaxe"), ENDERITE_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_axe"), ENDERITE_AXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_shovel"), ENDERITE_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_hoe"), ENDERITE_HOE);

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

        //Obsidian armor
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_helmet"), ENDERITE_HELMET);
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_chestplate"), ENDERITE_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_leggings"), ENDERITE_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_boots"), ENDERITE_BOOTS);

        //Super tools

        //Iron
        Registry.register(Registry.ITEM, new Identifier(modid, "iron_battle_axe"), IRON_BATTLE_AXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "iron_crater_creator"), IRON_CRATER_CREATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "iron_drill"), IRON_DRILL);
        Registry.register(Registry.ITEM, new Identifier(modid, "iron_excavator"), IRON_EXCAVATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "iron_plow"), IRON_PLOW);

        //Gold
        Registry.register(Registry.ITEM, new Identifier(modid, "golden_battle_axe"), GOLDEN_BATTLE_AXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "golden_crater_creator"), GOLDEN_CRATER_CREATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "golden_drill"), GOLDEN_DRILL);
        Registry.register(Registry.ITEM, new Identifier(modid, "golden_excavator"), GOLDEN_EXCAVATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "golden_plow"), GOLDEN_PLOW);

        //Diamond
        Registry.register(Registry.ITEM, new Identifier(modid, "diamond_battle_axe"), DIAMOND_BATTLE_AXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "diamond_crater_creator"), DIAMOND_CRATER_CREATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "diamond_drill"), DIAMOND_DRILL);
        Registry.register(Registry.ITEM, new Identifier(modid, "diamond_excavator"), DIAMOND_EXCAVATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "diamond_plow"), DIAMOND_PLOW);

        //Emerald
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_battle_axe"), EMERALD_BATTLE_AXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_crater_creator"), EMERALD_CRATER_CREATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_drill"), EMERALD_DRILL);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_excavator"), EMERALD_EXCAVATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "emerald_plow"), EMERALD_PLOW);

        //Ruby
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_battle_axe"), RUBY_BATTLE_AXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_crater_creator"), RUBY_CRATER_CREATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_drill"), RUBY_DRILL);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_excavator"), RUBY_EXCAVATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_plow"), RUBY_PLOW);

        //Obsidian
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_battle_axe"), OBSIDIAN_BATTLE_AXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_crater_creator"), OBSIDIAN_CRATER_CREATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_drill"), OBSIDIAN_DRILL);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_excavator"), OBSIDIAN_EXCAVATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "obsidian_plow"), OBSIDIAN_PLOW);

        //Netherite
        Registry.register(Registry.ITEM, new Identifier(modid, "netherite_battle_axe"), NETHERITE_BATTLE_AXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "netherite_crater_creator"), NETHERITE_CRATER_CREATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "netherite_drill"), NETHERITE_DRILL);
        Registry.register(Registry.ITEM, new Identifier(modid, "netherite_excavator"), NETHERITE_EXCAVATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "netherite_plow"), NETHERITE_PLOW);

        //Enderite
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_battle_axe"), ENDERITE_BATTLE_AXE);
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_crater_creator"), ENDERITE_CRATER_CREATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_drill"), ENDERITE_DRILL);
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_excavator"), ENDERITE_EXCAVATOR);
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_plow"), ENDERITE_PLOW);

        //Other items
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby"), RUBY);
        Registry.register(Registry.ITEM, new Identifier(modid, "onyx"), ONYX);
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_shard"), ENDERITE_SHARD);
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_crystal"), ENDERITE_CRYSTAL);

        //Both Block and BlockItem must be registered for it to be place-able and in the inventory
        Registry.register(Registry.BLOCK, new Identifier(modid, "ruby_ore"), RUBY_ORE);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_ore"), new BlockItem(RUBY_ORE, MAIN));
        Registry.register(Registry.BLOCK, new Identifier(modid, "ruby_block"), RUBY_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(modid, "ruby_block"), new BlockItem(RUBY_BLOCK, MAIN));
        Registry.register(Registry.BLOCK, new Identifier(modid, "compressed_obsidian"), COMPRESSED_OBSIDIAN);
        Registry.register(Registry.ITEM, new Identifier(modid, "compressed_obsidian"), new BlockItem(COMPRESSED_OBSIDIAN, MAIN));
        Registry.register(Registry.BLOCK, new Identifier(modid, "fractured_end_stone"), FRACTURED_END_STONE);
        Registry.register(Registry.ITEM, new Identifier(modid, "fractured_end_stone"), new BlockItem(FRACTURED_END_STONE, MAIN));
        Registry.register(Registry.BLOCK, new Identifier(modid, "enderite_block"), ENDERITE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(modid, "enderite_block"), new BlockItem(ENDERITE_BLOCK, MAIN));

        //Enchantments
        Registry.register(Registry.ENCHANTMENT, new Identifier(modid, "cultivation"), CULTIVATION);
        Registry.register(Registry.ENCHANTMENT, new Identifier(modid, "pathmaker"), PATHMAKER);

        //Packets
        ServerSidePacketRegistry.INSTANCE.register(NETHER_PORTAL_PACKET, new NetherPortalPacket());
        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (Map.Entry<PlayerEntity, Integer> entry : NetherPortalPacket.players.entrySet())
            if (entry.getValue() > 0) {
                entry.getKey().setInNetherPortal(entry.getKey().getBlockPos());
                NetherPortalPacket.players.put(entry.getKey(), entry.getValue() - 1);
            } else if (entry.getValue() == 0) {
                NetherPortalPacket.players.remove(entry.getKey());
            }
        });

        //These cycle through all biomes, then checks for new ones. See handleBiome to see what they do for each biome
        Registry.BIOME.forEach(Util::handleBiome);
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> Util.handleBiome(biome));
    }
}