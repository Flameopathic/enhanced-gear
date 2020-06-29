package net.enhanced.gear.mixin;

import net.enhanced.gear.EnhancedGear;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tag.BlockTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    @Inject(at = @At(value = "TAIL"), method = "getBlockBreakingSpeed", cancellable = true)
    public void getBlockBreakingSpeed(BlockState block, CallbackInfoReturnable<Float> cir){
        ItemStack itemStack = this.getEquippedStack(EquipmentSlot.MAINHAND);
        Block blockType = block.getBlock();
        //Supertool Speed Changes
        //Iron
        if (itemStack.getItem().equals(EnhancedGear.IRON_CRATER_CREATOR) && EnhancedGear.STONEY.contains(blockType)) {
            cir.setReturnValue(1.5f);
        }
        if (itemStack.getItem().equals(EnhancedGear.IRON_DRILL) && EnhancedGear.ORES.contains(blockType)) {
            cir.setReturnValue(1.5f);
        }
        if (itemStack.getItem().equals(EnhancedGear.IRON_BATTLE_AXE) && BlockTags.LOGS.contains(blockType)) {
            cir.setReturnValue(1.5f);
        }
        if (itemStack.getItem().equals(EnhancedGear.IRON_EXCAVATOR) && Items.IRON_SHOVEL.getMiningSpeed(itemStack, block) > 1) {
            cir.setReturnValue(1.5f);
        }

        //Gold
        if (itemStack.getItem().equals(EnhancedGear.GOLDEN_CRATER_CREATOR) && EnhancedGear.STONEY.contains(blockType)) {
            cir.setReturnValue(2.5f);
        }
        if (itemStack.getItem().equals(EnhancedGear.GOLDEN_DRILL) && EnhancedGear.ORES.contains(blockType)) {
            cir.setReturnValue(2.5f);
        }
        if (itemStack.getItem().equals(EnhancedGear.GOLDEN_BATTLE_AXE) && BlockTags.LOGS.contains(blockType)) {
            cir.setReturnValue(2.5f);
        }
        if (itemStack.getItem().equals(EnhancedGear.GOLDEN_EXCAVATOR) && Items.GOLDEN_SHOVEL.getMiningSpeed(itemStack, block) > 1) {
            cir.setReturnValue(2.5f);
        }
    }
}
