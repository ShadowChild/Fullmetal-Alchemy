package io.github.shadowchild.fma.content.base;


import io.github.shadowchild.fma.Fullmetal;
import io.github.shadowchild.fma.init.InitItems;
import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.item.Item;

public class BaseItem extends Item {

    public BaseItem(String label) {

        this.setUnlocalizedName(label);
        this.setRegistryName(label);
        this.setCreativeTab(Refs.TAB);
        InitItems.ITEMS.add(this);
    }

    public void registerModels() {

        Fullmetal.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
