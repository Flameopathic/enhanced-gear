package net.enhanced.gear.mixin;

import net.enhanced.gear.EnhancedGear;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;



@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin {

    @Shadow public abstract ItemStack getStack();

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ItemEntity;scheduleVelocityUpdate()V"), method = "damage", cancellable = true)
    public void damage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if(this.getStack().getItem() == EnhancedGear.OBSIDIAN_AXE || this.getStack().getItem() == EnhancedGear.OBSIDIAN_BOOTS || this.getStack().getItem() == EnhancedGear.OBSIDIAN_CHESTPLATE || this.getStack().getItem() == EnhancedGear.OBSIDIAN_HELMET || this.getStack().getItem() == EnhancedGear.OBSIDIAN_HOE || this.getStack().getItem() == EnhancedGear.OBSIDIAN_LEGGINGS || this.getStack().getItem() == EnhancedGear.OBSIDIAN_PICKAXE || this.getStack().getItem() == EnhancedGear.OBSIDIAN_SHOVEL || this.getStack().getItem() == EnhancedGear.OBSIDIAN_SWORD) {
            cir.setReturnValue(false);
        }
    }
}
