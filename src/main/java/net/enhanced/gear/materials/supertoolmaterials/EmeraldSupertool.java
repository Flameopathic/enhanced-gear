package net.enhanced.gear.materials.supertoolmaterials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EmeraldSupertool implements ToolMaterial {
    @Override
    public int getDurability() {
        return 1561;
    }

    @Override
    public float getMiningSpeed() {
        return 2f;
    }

    @Override
    public float getAttackDamage() {
        return 1;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.EMERALD_BLOCK);
    }
}
