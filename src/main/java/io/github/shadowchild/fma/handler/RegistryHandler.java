package io.github.shadowchild.fma.handler;


import io.github.shadowchild.fma.content.base.BaseBlock;
import io.github.shadowchild.fma.content.base.BaseItem;
import io.github.shadowchild.fma.utils.Refs;
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

        e.getRegistry().registerAll(Refs.ITEMS.toArray(new Item[0]));
        e.getRegistry().registerAll(Refs.ITEM_BLOCKS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> e) {

        e.getRegistry().registerAll(Refs.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {

        for(Item item : Refs.ITEMS) {

            if(item instanceof BaseItem) {

                ((BaseItem) item).registerModels();
            }
        }

        for(Block block : Refs.BLOCKS){

            if(block instanceof BaseBlock){

                ((BaseBlock) block).registerModels();
            }
        }
    }
}
