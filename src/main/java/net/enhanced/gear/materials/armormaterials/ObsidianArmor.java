package net.enhanced.gear.materials.armormaterials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;

import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class ObsidianArmor implements ArmorMaterial {

    private static final int[] baseDura = new int[] {13, 15, 16, 11};
    private static final double[] protection = new double[] { 1, 5, 6, 3 };

    @Override
    public int getDurability(EquipmentSlot slot) {
        return baseDura[slot.getEntitySlotId()]*37;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return (int) (protection[slot.getEntitySlotId()] * 1.4);
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_CHAIN;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.OBSIDIAN);
    }

    @Override
    public String getName() {
        return "obsidian";
    }

    @Override
    public float getToughness() {
        return 2;
    }
    
}