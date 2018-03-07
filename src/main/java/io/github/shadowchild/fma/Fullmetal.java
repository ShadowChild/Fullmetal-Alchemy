package io.github.shadowchild.fma;


import io.github.shadowchild.fma.common.Proxy;
import io.github.shadowchild.fma.utils.Refs;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Refs.MOD_ID, name = Refs.MOD_NAME, version = Refs.MOD_VERSION)
public class Fullmetal {

    @Mod.Instance
    public static Fullmetal instance;

    @SidedProxy(clientSide = Refs.CLIENT_PROXY, serverSide = Refs.COMMON_PROXY)
    public static Proxy proxy;

    static {

        FluidRegistry.enableUniversalBucket();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {

        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {

        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {

        proxy.postInit(e);
    }
}
