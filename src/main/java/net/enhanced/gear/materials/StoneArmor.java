package net.enhanced.gear.materials;

import net.enhanced.gear.EnhancedGear;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class StoneArmor implements ArmorMaterial {

    private static final int[] baseDura = new int[] {13, 15, 16, 11};
    private static final int[] protection = new int[] { 1, 2, 3, 1 };

    @Override
    public int getDurability(EquipmentSlot slot) {
        return baseDura[slot.getEntitySlotId()]*6;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return protection[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_CHAIN;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.STONE);
    }

    @Override
    public String getName() {
        return "stone";
    }

    @Override
    public float getToughness() {
        return 0;
    }
    
}