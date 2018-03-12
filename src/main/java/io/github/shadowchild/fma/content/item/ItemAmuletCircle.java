package io.github.shadowchild.fma.content.item;


import baubles.api.BaubleType;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemAmuletCircle extends ItemWearable {

    public ItemAmuletCircle(String label) {

        super(label, BaubleType.AMULET);
        this.setMaxStackSize(1);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        tooltip.add("An Amulet inscribed with Transmute Circle");
    }
}
