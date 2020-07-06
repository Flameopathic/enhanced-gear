package flameopathic.enhancedgear.keybindings;

import flameopathic.enhancedgear.networking.NetherPortalPacket;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.network.PacketByteBuf;

public class ObsidianArmorAbility extends KeyBinding {
    public ObsidianArmorAbility(String translationKey, int code, String category) {
        super(translationKey, code, category);
    }
    @Override
    public void setPressed(final boolean pressed) {
        if (!this.isPressed() && pressed) {
            this.onPress();
        }
        super.setPressed(pressed);
    }
    protected void onPress() {
        ClientSidePacketRegistry.INSTANCE.sendToServer(NetherPortalPacket.NETHER_PORTAL_PACKET, new PacketByteBuf(Unpooled.buffer()));
    }
}

