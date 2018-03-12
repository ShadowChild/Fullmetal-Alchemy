package io.github.shadowchild.fma.utils;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

public class Refs {

    public static final String MOD_ID = "fullmetal";
    public static final String MOD_NAME = "Fullmetal Alchemy";
    public static final String MOD_VERSION = "0.0.1"; // Version uses the MAJOR.MINOR.BUILD system.
    public static final String DEPENDENCIES = "required-after:baubles@[1.5.2,);";

    public static final String COMMON_PROXY = "io.github.shadowchild.fma.common.Proxy";
    public static final String CLIENT_PROXY = "io.github.shadowchild.fma.client.ClientProxy";

    public static final CreativeTabs TAB = new FMATab();

    public static final int SOUL_VOLUME = Fluid.BUCKET_VOLUME;
    public static final double ENTITY_SOUL_VOLUME = ((double)Fluid.BUCKET_VOLUME / 16d);

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
