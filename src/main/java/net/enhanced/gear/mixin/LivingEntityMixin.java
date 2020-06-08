package net.enhanced.gear.mixin;

import net.enhanced.gear.EnhancedGear;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DefaultedList;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

	@Shadow @Final private DefaultedList<ItemStack> equippedArmor;

	public LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject( at = @At("HEAD"), method = "tick")
	private void tick(CallbackInfo info) {
		ItemStack helmetStack = equippedArmor.get(3);
		ItemStack chestplateStack = equippedArmor.get(2);
		ItemStack leggingsStack = equippedArmor.get(1);
		ItemStack bootsStack = equippedArmor.get(0);

		if(helmetStack.getItem().equals(EnhancedGear.OBSIDIAN_HELMET)){
			if(chestplateStack.getItem().equals(EnhancedGear.OBSIDIAN_CHESTPLATE)){
				if(leggingsStack.getItem().equals(EnhancedGear.OBSIDIAN_LEGGINGS)){
					if(bootsStack.getItem().equals(EnhancedGear.OBSIDIAN_BOOTS)){
						((LivingEntity)(Object)this).addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20, 1, false, false));
					}
				}
			}
		}
		if(helmetStack.getItem().equals(EnhancedGear.EMERALD_HELMET)){
			((LivingEntity)(Object)this).addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 20, 0, false, false));
		}
		if(chestplateStack.getItem().equals(EnhancedGear.EMERALD_CHESTPLATE)){
			((LivingEntity)(Object)this).addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 0, false, false));
		}
		if(leggingsStack.getItem().equals(EnhancedGear.EMERALD_LEGGINGS)){
			((LivingEntity)(Object)this).addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20, 0, false, false));
		}
		if(bootsStack.getItem().equals(EnhancedGear.EMERALD_BOOTS)){
			((LivingEntity)(Object)this).addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20, 0, false, false));
		}
	}
}
