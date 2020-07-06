package flameopathic.enhancedgear.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)

public abstract class EnchantmentMixin{

    @Shadow public abstract Text getName(int level);

    @Inject(at = @At(value = "RETURN"), method = "isAcceptableItem", cancellable = true)
    public void isAcceptableItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        System.out.println(this.getName(1));
//        if (this.getName(1).equals())
    }
}
