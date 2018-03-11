package io.github.shadowchild.fma.init;


import io.github.shadowchild.fma.content.item.ItemAmuletCircle;
import io.github.shadowchild.fma.content.item.ItemPStone;
import io.github.shadowchild.fma.content.item.ItemSoulVessel;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsInit {

    public static final List<Item> ITEMS = new ArrayList<>();

    // Vessels
    public static final Item vessel_soul = new ItemSoulVessel("vessel_soul");

    // Stones
    public static final ItemPStone stone_red = new ItemPStone("stone_red", true);
    public static final ItemPStone stone_phil = new ItemPStone("stone_phil", false);

    // Wearables
    public static final Item amulet_circle = new ItemAmuletCircle("amulet_circle");
}
