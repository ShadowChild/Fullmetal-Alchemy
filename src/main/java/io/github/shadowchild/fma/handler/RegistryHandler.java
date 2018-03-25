package io.github.shadowchild.fma.handler;


import io.github.shadowchild.fma.content.tileentity.TileEntityTransmuteRune;
import io.github.shadowchild.fma.init.InitBlocks;
import io.github.shadowchild.fma.init.InitItems;
import io.github.shadowchild.fma.utils.IMeshable;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> e) {

        e.getRegistry().registerAll(InitItems.ITEMS.toArray(new Item[0]));
        e.getRegistry().registerAll(InitBlocks.ITEM_BLOCKS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> e) {

        e.getRegistry().registerAll(InitBlocks.BLOCKS.toArray(new Block[0]));

        GameRegistry.registerTileEntity(TileEntityTransmuteRune.class, InitBlocks.crafting_rune.getRegistryName().toString());
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {

        for(Item item : InitItems.ITEMS) {

            if(item instanceof IMeshable) {

                ((IMeshable) item).registerModels();
            }
        }

        for(Block block : InitBlocks.BLOCKS){

            if(block instanceof IMeshable){

                ((IMeshable) block).registerModels();
            }
        }
    }
}
