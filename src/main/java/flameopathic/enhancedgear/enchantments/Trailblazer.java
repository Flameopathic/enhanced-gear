package flameopathic.enhancedgear.enchantments;

import flameopathic.enhancedgear.supertoolbases.ExcavatorItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

public class Trailblazer extends Enchantment {
    public Trailblazer(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return 7;
    }

    @Override
    public int getMaxPower(int level) {
        return 100000;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof ExcavatorItem;
    }
}
