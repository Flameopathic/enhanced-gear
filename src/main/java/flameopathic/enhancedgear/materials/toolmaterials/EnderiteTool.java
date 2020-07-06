package flameopathic.enhancedgear.materials.toolmaterials;
import flameopathic.enhancedgear.EnhancedGear;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class EnderiteTool implements ToolMaterial {

    @Override
    public int getDurability() {
        return 2300;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.0f;
    }

    @Override
    public float getAttackDamage() {
        return 4.0f;
    }

    @Override
    public int getMiningLevel() {
        return 4;
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