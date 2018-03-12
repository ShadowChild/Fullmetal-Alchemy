package io.github.shadowchild.fma.init;


import baubles.api.BaubleType;
import io.github.shadowchild.fma.content.ItemBase;
import io.github.shadowchild.fma.content.item.ItemAmuletCircle;
import io.github.shadowchild.fma.content.item.ItemPStone;
import io.github.shadowchild.fma.content.item.ItemSoulVessel;
import io.github.shadowchild.fma.content.item.ItemWearable;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemsInit {

    public static final List<Item> ITEMS = new ArrayList<>();

    // Vessels
    public static final ItemBase vessel_soul = new ItemSoulVessel("vessel_soul");

    // Stones
    public static final ItemPStone stone_red = new ItemPStone("stone_red", true);
    public static final ItemPStone stone_phil = new ItemPStone("stone_phil", false);

    // Trinkets
    public static final ItemBase trinket_amulet = new ItemWearable("trinket_amulet", BaubleType.AMULET);

    // Power Trinkets
    public static final ItemBase trinket_amulet_circle = new ItemAmuletCircle("trinket_amulet_circle");
}
