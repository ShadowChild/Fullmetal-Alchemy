package io.github.shadowchild.fma.content.base;


import io.github.shadowchild.fma.Fullmetal;
import io.github.shadowchild.fma.init.InitBlocks;
import io.github.shadowchild.fma.utils.IMeshable;
import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BaseBlock extends Block implements IMeshable {

    public BaseBlock(String label, Material material) {

        super(material);
        this.setUnlocalizedName(label);
        this.setRegistryName(label);
        this.setCreativeTab(Refs.TAB);
        InitBlocks.BLOCKS.add(this);
        InitBlocks.ITEM_BLOCKS.add(createItemBlock());
    }

    public Item createItemBlock() {

        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public void registerModels() {

        Fullmetal.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
