package io.github.shadowchild.fma.init;


import io.github.shadowchild.fma.content.item.ChalkStickItem;
import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Refs.MOD_ID)
public class InitItems {

    @GameRegistry.ObjectHolder("chalk_stick")
    public static final Item chalk_stick = null;

    public static void init() {

        Refs.ITEMS.add(new ChalkStickItem("chalk_stick"));
    }
}
