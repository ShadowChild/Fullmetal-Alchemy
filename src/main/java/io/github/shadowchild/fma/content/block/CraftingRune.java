package io.github.shadowchild.fma.content.block;


import io.github.shadowchild.fma.content.base.BaseBlockHorizontal;
import io.github.shadowchild.fma.content.tileentity.TileEntityTransmuteRune;
import io.github.shadowchild.fma.init.InitBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMaterialMatcher;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class CraftingRune extends BaseBlockHorizontal {

    private BlockPattern circle_pattern;

    public CraftingRune(String label) {

        super(label, Material.ROCK);
    }

    public BlockPattern getOrCreateBlockPattern() {

        if(circle_pattern == null) {

            // Pattern is 9x9 (W x H) rather than 7x9 so that it can be rotated
            // and still create a circle
            String[] pattern_up = new String[] {
                    "....v....",
                    ".........",
                    ".>.....<.",
                    ".........",
                    "....@....",
                    ".........",
                    ".>.....<.",
                    ".........",
                    "....^...."
            };
            circle_pattern = FactoryBlockPattern.start()
                    .aisle(pattern_up)
                    .where('.', BlockWorldState.hasState(BlockStateMatcher.ANY))
                    .where('v', BlockWorldState.hasState(BlockMaterialMatcher.forMaterial(InitBlocks.RUNE)))
                    .where('>', BlockWorldState.hasState(BlockMaterialMatcher.forMaterial(InitBlocks.RUNE)))
                    .where('<', BlockWorldState.hasState(BlockMaterialMatcher.forMaterial(InitBlocks.RUNE)))
                    .where('^', BlockWorldState.hasState(BlockMaterialMatcher.forMaterial(InitBlocks.RUNE)))
                    .where('@', BlockWorldState.hasState(BlockStateMatcher.forBlock(InitBlocks.crafting_rune)))
                    .build();
        }

        return circle_pattern;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {

        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {

        return new TileEntityTransmuteRune();
    }
}
