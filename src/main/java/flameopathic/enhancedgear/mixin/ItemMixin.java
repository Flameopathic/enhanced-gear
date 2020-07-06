package flameopathic.enhancedgear.mixin;

import flameopathic.enhancedgear.EnhancedGear;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {

    @Inject(at = @At(value = "TAIL"), method = "getMiningSpeedMultiplier", cancellable = true)
    public void getMiningSpeed(ItemStack stack, BlockState state, CallbackInfoReturnable<Float> cir){
        if (stack.getItem().equals(EnhancedGear.IRON_EXCAVATOR) && Items.IRON_SHOVEL.getMiningSpeedMultiplier(stack, state) > 1) {
            cir.setReturnValue(1f);
        }
        if (stack.getItem().equals(EnhancedGear.GOLDEN_EXCAVATOR) && Items.GOLDEN_SHOVEL.getMiningSpeedMultiplier(stack, state) > 1) {
            cir.setReturnValue(2f);
        }
        if (stack.getItem().equals(EnhancedGear.DIAMOND_EXCAVATOR) && Items.DIAMOND_SHOVEL.getMiningSpeedMultiplier(stack, state) > 1) {
            cir.setReturnValue(1f);
        }
        if (stack.getItem().equals(EnhancedGear.EMERALD_EXCAVATOR) && EnhancedGear.EMERALD_SHOVEL.getMiningSpeedMultiplier(stack, state) > 1) {
            cir.setReturnValue(1f);
        }
        if (stack.getItem().equals(EnhancedGear.RUBY_EXCAVATOR) && EnhancedGear.RUBY_SHOVEL.getMiningSpeedMultiplier(stack, state) > 1) {
            cir.setReturnValue(1f);
        }
        if (stack.getItem().equals(EnhancedGear.OBSIDIAN_EXCAVATOR) && EnhancedGear.OBSIDIAN_SHOVEL.getMiningSpeedMultiplier(stack, state) > 1) {
            cir.setReturnValue(1f);
        }
    }
}
