package net.enhanced.gear.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import java.util.List;

public class Ruby extends Item {

    public Ruby(Settings settings) {
        super(settings);

    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.enhancedgear.ruby.newline").styled((style) -> style.setColor(Formatting.RED)));
        tooltip.add(new TranslatableText("item.enhancedgear.ruby.warning_1").styled((style) -> style.setColor(Formatting.RED)));
        tooltip.add(new TranslatableText("item.enhancedgear.ruby.warning_2").styled((style) -> style.setColor(Formatting.RED)));
        tooltip.add(new TranslatableText("item.enhancedgear.ruby.warning_3").styled((style) -> style.setColor(Formatting.RED)));
        tooltip.add(new TranslatableText("item.enhancedgear.ruby.warning_4").styled((style) -> style.setColor(Formatting.RED)));
    }
}