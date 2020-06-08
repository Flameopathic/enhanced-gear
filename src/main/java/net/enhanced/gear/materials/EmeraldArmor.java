package net.enhanced.gear.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;

import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class EmeraldArmor implements ArmorMaterial {

    private static final int[] baseDura = new int[] {13, 15, 16, 11};
    private static final double[] protection = new double[] {1, 5, 6, 3};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return baseDura[slot.getEntitySlotId()]*7;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return (int) (protection[slot.getEntitySlotId()]* 2);
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
        return Ingredient.ofItems(Items.EMERALD);
    }

    @Override
    public String getName() {
        return "emerald";
    }

    @Override
    public float getToughness() {
        return 2;
    }
    
}