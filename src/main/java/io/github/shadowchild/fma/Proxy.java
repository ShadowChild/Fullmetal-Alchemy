package io.github.shadowchild.fma;


import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.Objects;

public class Proxy {

    public void preInit(FMLPreInitializationEvent e) {

    }

    public void init(FMLInitializationEvent e) {

        FluidUtil.getFilledBucket(Objects.requireNonNull(
                FluidRegistry.getFluidStack("soul", Fluid.BUCKET_VOLUME))).getItem().setCreativeTab(Refs.TAB);
    }

    public void postInit(FMLPostInitializationEvent e) {

    }

    public void registerItemRenderer(Item item, int metadata, String id) {

    }

    public void initRenders() {

    }
}
