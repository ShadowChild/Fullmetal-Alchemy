package io.github.shadowchild.fma.content.item;


import baubles.api.BaubleType;
import baubles.api.IBauble;
import io.github.shadowchild.fma.content.base.BaseItem;
import net.minecraft.item.ItemStack;

public class WearableItem extends BaseItem implements IBauble {

    private BaubleType baubleType;

    public WearableItem(String label, BaubleType baubleType) {

        super(label);
        this.baubleType = baubleType;
        this.setMaxStackSize(1);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {

        return baubleType;
    }
}
