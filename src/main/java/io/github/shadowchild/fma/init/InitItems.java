package io.github.shadowchild.fma.init;


import io.github.shadowchild.fma.content.base.BaseItem;
import io.github.shadowchild.fma.content.item.ChalkStickItem;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class InitItems {

    public static final List<Item> ITEMS = new ArrayList<>();

    public static final BaseItem chalk_stick = new ChalkStickItem("chalk_stick");
}
