package io.github.shadowchild.fma.utils;


import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.shadowchild.fma.damage.FakeStoneDamageSource;
import io.github.shadowchild.fma.init.InitItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fluids.Fluid;

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
    public static final DamageSource FAKE_STONE_FAILURE = new FakeStoneDamageSource();

    public static final int SOUL_VOLUME = Fluid.BUCKET_VOLUME;
    public static final double ENTITY_SOUL_VOLUME = ((double)Fluid.BUCKET_VOLUME / 16d);

    private static class FMATab extends CreativeTabs {

        public FMATab() {

            super("tab_fma");
        }

        @Override
        public ItemStack getTabIconItem() {

            return new ItemStack(InitItems.stone_philosopher);
        }
    }
}
