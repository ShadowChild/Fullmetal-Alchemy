package io.github.shadowchild.fma;


import io.github.shadowchild.fma.init.InitBlocks;
import io.github.shadowchild.fma.init.InitItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Proxy {

    public void preInit(FMLPreInitializationEvent e) {

        InitItems.init();
        InitBlocks.init();
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }

    public void registerItemRenderer(Item item, int metadata, String id) {

    }

    public void initRenders() {

    }

    public void updateCircleDrawing(ItemStack stack, EntityLivingBase player, int ticks) {

    }

    public void clearCircleCache() {

    }
}
