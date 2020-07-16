package flameopathic.enhancedgear.items.supertools.diamond;

import flameopathic.enhancedgear.supertoolbases.PlowItem;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static flameopathic.enhancedgear.util.Util.*;

public class DiamondPlow extends PlowItem {

    public DiamondPlow(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}