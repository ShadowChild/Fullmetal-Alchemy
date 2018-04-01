package io.github.shadowchild.fma;


import io.github.shadowchild.fma.api.FullmetalAPI;
import io.github.shadowchild.fma.content.fluid.BaseFluid;
import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Proxy {

    public void preInit(FMLPreInitializationEvent e) {

        initBlacklist();
        BaseFluid.soul_fluid = new BaseFluid("soul", Color.DARK_GRAY).setGaseous(true).setViscosity(-1000).setDensity(-1000);
    }

    private void initBlacklist() {

        ArrayList<Class<? extends EntityLivingBase>> lst = new ArrayList<>();
        lst.add(EntityHusk.class);
        lst.add(EntityStray.class);
        lst.add(EntityWitherSkeleton.class);
        lst.add(EntitySkeleton.class);
        lst.add(EntityZombie.class);
        // TODO: Add More!

        FullmetalAPI.addEntityToSoulBlacklist(lst);
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
