package io.github.shadowchild.fma.content;


import io.github.shadowchild.fma.Fullmetal;
import io.github.shadowchild.fma.init.ItemsInit;
import io.github.shadowchild.fma.utils.IHasModel;
import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String label, String registrySubFolder) {

        this.setUnlocalizedName(label);

        if(!registrySubFolder.isEmpty()) registrySubFolder = registrySubFolder + "/";

        this.setRegistryName(registrySubFolder + label);
        this.setCreativeTab(Refs.TAB);
        ItemsInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {

        Fullmetal.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
