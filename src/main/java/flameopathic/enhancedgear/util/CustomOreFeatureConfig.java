package flameopathic.enhancedgear.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.FeatureConfig;

public class CustomOreFeatureConfig implements FeatureConfig {
    public static final Codec<CustomOreFeatureConfig> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(
                BlockState.CODEC.fieldOf("target").forGetter((customOreFeatureConfig) -> {
                    return customOreFeatureConfig.target;
                }),
                BlockState.CODEC.fieldOf("state").forGetter((customOreFeatureConfig) -> {
                    return customOreFeatureConfig.state;
                }), Codec.INT.fieldOf("size").withDefault(0).forGetter((customOreFeatureConfig) -> {
                    return customOreFeatureConfig.size;
                })).apply(instance, CustomOreFeatureConfig::new);
    });
    public final BlockState target;
    public final int size;
    public final BlockState state;

    public CustomOreFeatureConfig(BlockState target, BlockState state, int size) {
        this.size = size;
        this.state = state;
        this.target = target;
    }
}

