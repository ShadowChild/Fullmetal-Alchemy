package io.github.shadowchild.fma.reg;


import io.github.shadowchild.fma.init.BlocksInit;
import io.github.shadowchild.fma.init.ItemsInit;
import io.github.shadowchild.fma.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> e) {

        e.getRegistry().registerAll(ItemsInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> e) {

        e.getRegistry().registerAll(BlocksInit.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {

        for(Item item : ItemsInit.ITEMS) {

            if(item instanceof IHasModel) {

                ((IHasModel) item).registerModels();
            }
        }

        for(Block block : BlocksInit.BLOCKS){

            if(block instanceof IHasModel){

                ((IHasModel) block).registerModels();
            }
        }
    }
}
