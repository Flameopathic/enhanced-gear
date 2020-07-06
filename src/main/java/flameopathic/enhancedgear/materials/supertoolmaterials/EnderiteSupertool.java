package flameopathic.enhancedgear.materials.supertoolmaterials;

import flameopathic.enhancedgear.EnhancedGear;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EnderiteSupertool implements ToolMaterial {
    @Override
    public int getDurability() {
        return 2300;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 3f;
    }

    @Override
    public float getAttackDamage() {
        return 2;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 20;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(EnhancedGear.ENDERITE_CRYSTAL);
    }
}
