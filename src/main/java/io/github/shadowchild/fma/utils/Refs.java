package io.github.shadowchild.fma.utils;


import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Refs {

    public static final String MOD_ID = "fullmetal";
    public static final String MOD_NAME = "Fullmetal Alchemy";
    public static final String MOD_VERSION = "0.0.1"; // Version uses the MAJOR.MINOR.BUILD system.
    public static final String DEPENDENCIES = "required-after:baubles@[1.5.2,);";

    public static final String COMMON_PROXY = "io.github.shadowchild.fma.Proxy";
    public static final String CLIENT_PROXY = "io.github.shadowchild.fma.client.ClientProxy";

    public static final Random RANDOM = new Random();
    public static final Logger LOGGER = LogManager.getLogger("Fullmetal");

    public static final CreativeTabs TAB = new FMATab();

    public static final int SOUL_VOLUME = Fluid.BUCKET_VOLUME;
    public static final double ENTITY_SOUL_VOLUME = ((double)Fluid.BUCKET_VOLUME / 16d);

    public static final List<Item> ITEMS = new ArrayList<>();
    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final List<Item> ITEM_BLOCKS = new ArrayList<>();

    private static class FMATab extends CreativeTabs {

        public FMATab() {

            super("tab_fma");
        }

        @Override
        public ItemStack getTabIconItem() {

            return new ItemStack(Items.COOKIE);
        }
    }
}
