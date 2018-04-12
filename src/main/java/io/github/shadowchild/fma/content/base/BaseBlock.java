package io.github.shadowchild.fma.content.base;


import io.github.shadowchild.fma.Fullmetal;
import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BaseBlock extends Block {

    public BaseBlock(String label, Material material) {

        super(material);
        this.setUnlocalizedName(label);
        this.setRegistryName(label);
        this.setCreativeTab(Refs.TAB);
        Refs.ITEM_BLOCKS.add(createItemBlock());
    }

    public Item createItemBlock() {

        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    public void registerModels() {

        Fullmetal.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
