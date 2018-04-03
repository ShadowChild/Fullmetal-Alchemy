package io.github.shadowchild.fma.init;


import baubles.api.BaubleType;
import io.github.shadowchild.fma.content.base.BaseItem;
import io.github.shadowchild.fma.content.item.*;
import io.github.shadowchild.fma.content.item.automail.AutomailItem;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class InitItems {

    public static final List<Item> ITEMS = new ArrayList<>();

    // Vessels
    public static final BaseItem vessel_soul = new SoulVesselItem("vessel_soul");

    // Stones
    public static final PStoneItem stone_red = new PStoneItem("stone_red", true);
    public static final PStoneItem stone_philosopher = new PStoneItem("stone_philosopher", false);

    // Trinkets
    public static final BaseItem trinket_amulet = new WearableItem("trinket_amulet", BaubleType.AMULET);
    public static final BaseItem trinket_ring = new WearableItem("trinket_ring", BaubleType.RING);
    public static final BaseItem trinket_charm = new WearableItem("trinket_charm", BaubleType.CHARM);

    // Power Trinkets
    public static final WearableItem trinket_ring_inscribed = new InscribedWearableItem("trinket_ring_inscribed", BaubleType.RING);
    public static final WearableItem trinket_amulet_circle = new InscribedWearableItem("trinket_amulet_inscribed", BaubleType.AMULET);
    public static final WearableItem trinket_charm_inscribed = new InscribedWearableItem("trinket_charm_inscribed", BaubleType.CHARM);

    // Alchemical Items
    public static final ChalkItem alchemic_chalk = new ChalkItem("alchemic_chalk");

    // Msc Items
    public static final BaseItem chalk = new BaseItem("chalk");
    public static final BaseItem chalk_dust = new BaseItem("chalk_dust");

    // Automail
    public static final AutomailItem automail = new AutomailItem("automail");
}
