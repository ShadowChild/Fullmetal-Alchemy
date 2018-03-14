package io.github.shadowchild.fma.init;


import io.github.shadowchild.fma.content.base.BlockBase;
import io.github.shadowchild.fma.content.block.BlockSymbolReceptacle;
import io.github.shadowchild.fma.content.block.rune.BlockRune;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class BlocksInit {

    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final List<Item> ITEM_BLOCKS = new ArrayList<>();

    // Alchemic Blocks
    public static BlockBase receptacle = new BlockSymbolReceptacle("receptacle_symbol");

    // Runes
    public static BlockRune rune_air = new BlockRune("rune_air", BlockRune.RuneType.AIR);
}
