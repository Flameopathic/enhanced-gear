package flameopathic.enhancedgear.items.supertools.ruby;

import flameopathic.enhancedgear.supertoolbases.DrillItem;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

import java.util.Random;

public class RubyDrill extends DrillItem {

    public RubyDrill(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
        Random random = new Random();
        EnchantmentHelper.enchant(random, stack, 15, false);
    }
}