package io.github.shadowchild.fma.content.item;


import baubles.api.BaubleType;
import baubles.api.IBauble;
import io.github.shadowchild.fma.content.ItemBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemAmuletCircle extends ItemBase implements IBauble {

    public ItemAmuletCircle(String label) {

        super(label, "wearable");
        this.setMaxStackSize(1);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {

        return BaubleType.AMULET;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        tooltip.add("An Amulet inscribed with Transmute Circle");
    }
}
