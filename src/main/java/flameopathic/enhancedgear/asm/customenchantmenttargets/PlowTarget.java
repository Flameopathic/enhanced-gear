package flameopathic.enhancedgear.asm.customenchantmenttargets;

import flameopathic.enhancedgear.mixin.EnchantmentTargetMixin;
import flameopathic.enhancedgear.supertoolbases.PlowItem;
import net.minecraft.item.Item;

public class PlowTarget extends EnchantmentTargetMixin {
    @Override
    public boolean isAcceptableItem(Item item) {
        return item instanceof PlowItem;
    }
}
