package io.github.shadowchild.fma.content.fluid;


import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.awt.*;

public class FluidBase extends Fluid {

    public static Fluid soul_fluid;

    public FluidBase(String fluidName, Color color) {

        super(fluidName, new ResourceLocation(Refs.MOD_ID, "blocks/fluids/" + fluidName + "_still"), new ResourceLocation(Refs.MOD_ID, "blocks/fluids/" + fluidName + "_flowing"), color);

        FluidRegistry.registerFluid(this);
        FluidRegistry.addBucketForFluid(this);
    }
}
