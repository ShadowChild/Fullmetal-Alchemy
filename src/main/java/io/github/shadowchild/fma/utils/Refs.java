package io.github.shadowchild.fma.utils;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Refs {

    public static final String MOD_ID = "fullmetal";
    public static final String MOD_NAME = "Fullmetal Alchemy";
    public static final String MOD_VERSION = "0.0.1"; // Version uses the MAJOR.MINOR.BUILD system.

    public static final String COMMON_PROXY = "io.github.shadowchild.fma.common.Proxy";
    public static final String CLIENT_PROXY = "io.github.shadowchild.fma.client.ClientProxy";

    public static final CreativeTabs TAB = new FMATab();

    private static class FMATab extends CreativeTabs {

        public FMATab() {

            super("tab_fma");
        }

        @Override
        public ItemStack getTabIconItem() {

            return new ItemStack(Items.ARMOR_STAND);
        }
    }
}
