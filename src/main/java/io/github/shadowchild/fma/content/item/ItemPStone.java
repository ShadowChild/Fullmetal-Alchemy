package io.github.shadowchild.fma.content.item;


import io.github.shadowchild.fma.content.ItemBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemPStone extends ItemBase {

    private final boolean isFake;

    public ItemPStone(String label, boolean isFake) {

        super(label, "stone");
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
}
