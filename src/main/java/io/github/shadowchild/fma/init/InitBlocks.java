package io.github.shadowchild.fma.init;


import io.github.shadowchild.fma.content.block.AlchemyBenchBlock;
import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Refs.MOD_ID)
public class InitBlocks {

    @GameRegistry.ObjectHolder("alchemy_bench")
    public static final Block alchemy_bench = null;

    public static void init() {

        Refs.BLOCKS.add(new AlchemyBenchBlock("alchemy_bench"));
    }
}
