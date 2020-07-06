package flameopathic.enhancedgear;

import flameopathic.enhancedgear.keybindings.ObsidianArmorAbility;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class EnhancedGearClient implements ClientModInitializer {

    public static final ObsidianArmorAbility OBSIDIAN_ARMOR_ABILITY = new ObsidianArmorAbility("obsidian_armor_ability", GLFW.GLFW_KEY_R, "Enhanced Gear");

    @Override
    public void onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(OBSIDIAN_ARMOR_ABILITY);
    }
}
