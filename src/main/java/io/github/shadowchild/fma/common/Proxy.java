package io.github.shadowchild.fma.common;


import io.github.shadowchild.fma.content.fluid.FluidBase;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.awt.*;

public class Proxy {

    public void preInit(FMLPreInitializationEvent e) {

        FluidBase.soul_fluid = new FluidBase("soul", Color.DARK_GRAY).setGaseous(true).setViscosity(-1000).setDensity(-1000);
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }

    public void registerItemRenderer(Item item, int metadata, String id) {

    }
}
