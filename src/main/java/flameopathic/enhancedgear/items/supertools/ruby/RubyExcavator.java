package flameopathic.enhancedgear.items.supertools.ruby;

import flameopathic.enhancedgear.supertoolbases.ExcavatorItem;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;

import java.util.Random;

public class RubyExcavator extends ExcavatorItem {
    public RubyExcavator(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
        Random random = new Random();
        EnchantmentHelper.enchant(random, stack, 15, false);
    }
}