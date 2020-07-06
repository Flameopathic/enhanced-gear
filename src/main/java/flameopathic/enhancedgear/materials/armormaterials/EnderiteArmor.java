package flameopathic.enhancedgear.materials.armormaterials;

import flameopathic.enhancedgear.EnhancedGear;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class EnderiteArmor implements ArmorMaterial {

    private static final int[] baseDura = new int[] {13, 15, 16, 11};
    private static final double[] protection = new double[] {4, 6, 8, 4};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return baseDura[slot.getEntitySlotId()]*40;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return (int) (protection[slot.getEntitySlotId()]);
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(EnhancedGear.ENDERITE_CRYSTAL);
    }

    @Override
    public String getName() {
        return "enderite";
    }

    @Override
    public float getToughness() {
        return 2;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.5F;
    }

}