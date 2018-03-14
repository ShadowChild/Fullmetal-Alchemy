package io.github.shadowchild.fma.content.base;


import io.github.shadowchild.fma.Fullmetal;
import io.github.shadowchild.fma.init.ItemsInit;
import io.github.shadowchild.fma.utils.IMeshable;
import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IMeshable {

    public ItemBase(String label) {

        this.setUnlocalizedName(label);
        this.setRegistryName(label);
        this.setCreativeTab(Refs.TAB);
        ItemsInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {

        Fullmetal.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
