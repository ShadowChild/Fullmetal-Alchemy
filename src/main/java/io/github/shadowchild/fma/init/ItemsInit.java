package io.github.shadowchild.fma.init;


import io.github.shadowchild.fma.content.item.ItemPStone;
import io.github.shadowchild.fma.content.item.ItemSoulVessel;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsInit {

    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Item soul_vessel = new ItemSoulVessel("soul_vessel");
    public static final ItemPStone red_Stone = new ItemPStone("red_stone", true);
    public static final ItemPStone phil_stone = new ItemPStone("phil_stone", false);
}
