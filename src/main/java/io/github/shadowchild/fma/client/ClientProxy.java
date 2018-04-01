package io.github.shadowchild.fma.client;


import io.github.shadowchild.fma.Proxy;
import io.github.shadowchild.fma.client.render.TransmuteRuneRenderer;
import io.github.shadowchild.fma.content.tileentity.TileEntityTransmuteRune;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends Proxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {

        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {

        super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {

        super.postInit(e);
    }

    @Override
    public void registerItemRenderer(Item item, int metadata, String id) {

        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), id));
    }

    @Override
    public void initRenders() {

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTransmuteRune.class, new TransmuteRuneRenderer());
    }
}
