package io.github.shadowchild.fma.content.block;


import io.github.shadowchild.fma.Fullmetal;
import io.github.shadowchild.fma.init.BlocksInit;
import io.github.shadowchild.fma.utils.IMeshable;
import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IMeshable {

    public BlockBase(String label) {

        super(Material.IRON);
        this.setUnlocalizedName(label);
        this.setRegistryName(label);
        this.setCreativeTab(Refs.TAB);
        BlocksInit.BLOCKS.add(this);
        BlocksInit.ITEM_BLOCKS.add(createItemBlock());
    }

    public Item createItemBlock() {

        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    public void registerModels() {

        Fullmetal.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
