package io.github.shadowchild.fma.content;


import io.github.shadowchild.fma.Fullmetal;
import io.github.shadowchild.fma.init.ItemsInit;
import io.github.shadowchild.fma.utils.IHasModel;
import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

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
