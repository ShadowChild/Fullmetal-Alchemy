package io.github.shadowchild.fma.content.item;


import baubles.api.BaubleType;
import baubles.api.IBauble;
import io.github.shadowchild.fma.content.ItemBase;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemSoulVessel extends ItemBase implements IBauble {

    public ItemSoulVessel(String label) {

        super(label);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {

        return BaubleType.BELT;
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack) {

        return true;
    }

    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {

        return EnumRarity.RARE;
    }
}
