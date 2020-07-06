package flameopathic.enhancedgear.networking;

import flameopathic.enhancedgear.EnhancedGear;
import net.fabricmc.fabric.api.network.PacketConsumer;
import net.fabricmc.fabric.api.network.PacketContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class NetherPortalPacket implements PacketConsumer {
    public static final Identifier NETHER_PORTAL_PACKET = new Identifier ("enhancedgear", "nether_portal_packet");
    public static Map<PlayerEntity, Integer> players = new HashMap<>();

    @Override
    public void accept(PacketContext packetContext, PacketByteBuf packetByteBuf) {
        PlayerEntity player = packetContext.getPlayer();
        ItemStack helmetStack = player.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack chestplateStack = player.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack leggingsStack = player.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack bootsStack = player.getEquippedStack(EquipmentSlot.FEET);


        if(helmetStack.getItem().equals(EnhancedGear.OBSIDIAN_HELMET)){
            if(chestplateStack.getItem().equals(EnhancedGear.OBSIDIAN_CHESTPLATE)){
                if(leggingsStack.getItem().equals(EnhancedGear.OBSIDIAN_LEGGINGS)){
                    if(bootsStack.getItem().equals(EnhancedGear.OBSIDIAN_BOOTS)){
                        if (player.isOnFire()) {
                            players.put(player, 100);
                            packetContext.getPlayer().addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 250, 3, false, false));
                        }
                    }
                }
            }
        }
    }
}
