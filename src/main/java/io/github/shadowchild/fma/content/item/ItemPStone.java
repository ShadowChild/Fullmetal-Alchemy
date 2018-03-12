package io.github.shadowchild.fma.content.item;


import io.github.shadowchild.fma.content.ItemBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemPStone extends ItemBase {

    private final boolean isFake;

    public ItemPStone(String label, boolean isFake) {

        super(label);
        this.isFake = isFake;
        this.setMaxStackSize(1);
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack) {

        return true;
    }

    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {

        return isFake ? EnumRarity.UNCOMMON : EnumRarity.EPIC;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        tooltip.add("A stone which is said to break the law of exchange!");
        if(isFake) tooltip.add("Something doesn't seem quite right with this Stone...");
    }
}
