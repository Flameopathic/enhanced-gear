package flameopathic.enhancedgear.materials.supertoolmaterials;

import flameopathic.enhancedgear.EnhancedGear;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ObsidianSupertool implements ToolMaterial {
    @Override
    public int getDurability() {
        return 2222;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 2f;
    }

    @Override
    public float getAttackDamage() {
        return 1;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 14;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(EnhancedGear.COMPRESSED_OBSIDIAN);
    }
}
