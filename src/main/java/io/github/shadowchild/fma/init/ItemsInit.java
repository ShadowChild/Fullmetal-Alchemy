package io.github.shadowchild.fma.init;


import baubles.api.BaubleType;
import io.github.shadowchild.fma.content.ItemBase;
import io.github.shadowchild.fma.content.item.ItemPStone;
import io.github.shadowchild.fma.content.item.ItemSoulVessel;
import io.github.shadowchild.fma.content.item.ItemWearable;
import io.github.shadowchild.fma.content.item.ItemWearableInscribed;
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
    public static final ItemBase trinket_ring = new ItemWearable("trinket_ring", BaubleType.RING);
    public static final ItemBase trinket_charm = new ItemWearable("trinket_charm", BaubleType.CHARM);

    // Power Trinkets
    public static final ItemWearable trinket_ring_inscribed = new ItemWearableInscribed("trinket_ring_inscribed", BaubleType.RING);
    public static final ItemWearable trinket_amulet_circle = new ItemWearableInscribed("trinket_amulet_inscribed", BaubleType.AMULET);
    public static final ItemWearable trinket_charm_inscribed = new ItemWearableInscribed("trinket_charm_inscribed", BaubleType.CHARM);
}
