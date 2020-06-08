package net.enhanced.gear.materials;

import net.enhanced.gear.EnhancedGear;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class RubyTool implements ToolMaterial {

    @Override
    public int getDurability() {
        return 1000;
    }

    @Override
    public float getMiningSpeed() {
        return 8.0f;
    }

    @Override
    public float getAttackDamage() {
        return 3.0f;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 200;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(EnhancedGear.RUBY);
    }
    
}