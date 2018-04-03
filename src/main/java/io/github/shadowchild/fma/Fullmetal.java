package io.github.shadowchild.fma;


import io.github.shadowchild.fma.utils.Refs;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Refs.MOD_ID, name = Refs.MOD_NAME, version = Refs.MOD_VERSION, dependencies = Refs.DEPENDENCIES)
public class Fullmetal {

    @Mod.Instance
    public static Fullmetal instance;

    @SidedProxy(clientSide = Refs.CLIENT_PROXY, serverSide = Refs.COMMON_PROXY)
    public static Proxy proxy;

    public static final Logger LOGGER = LogManager.getLogger("Fullmetal");

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
        proxy.initRenders();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {

        proxy.postInit(e);
    }
}
