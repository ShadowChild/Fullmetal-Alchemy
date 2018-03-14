package io.github.shadowchild.fma.content.item;


import baubles.api.BaubleType;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class InscribedWearableItem extends WearableItem {

    public InscribedWearableItem(String label, BaubleType baubleType) {

        super(label, baubleType);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        tooltip.add("This trinket has been inscribed with Transmute Circle");
    }
}
