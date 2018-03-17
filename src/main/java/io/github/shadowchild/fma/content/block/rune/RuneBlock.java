package io.github.shadowchild.fma.content.block.rune;


import io.github.shadowchild.fma.content.base.BaseBlock;
import io.github.shadowchild.fma.init.InitBlocks;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMaterialMatcher;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;

public class RuneBlock extends BaseBlock {

    private final RuneType runeType;

    private BlockPattern circle_pattern;

    public RuneBlock(String label, RuneType runeType) {

        super(label, InitBlocks.RUNE);
        this.runeType = runeType;
    }

    public RuneType getRuneType() {

        return runeType;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {

        return false;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {

        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {

        return false;
    }

    public BlockPattern getOrCreateBlockPattern() {

        if(circle_pattern == null) {

            String[] pattern_up = new String[] {
                    "....v....",
                    ".........",
                    ".>.....<.",
                    ".........",
                    ".........",
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
                .build();
        }

        return circle_pattern;
    }

    public enum RuneType {

        // Base
        EARTH,
        FIRE,
        WATER,
        AIR,

        // Tria Prima
        SULFUR,
        MERCURY,
        SALT,

        // Other
        COPPER,
        SILVER,
        GOLD,
        IRON,
        ANTIMONY,
        TIN,
        PLATINUM,
        LEAD,
        ARSENIC,
        PHOSPHORUS,
        BISMUTH,
        MAGNESIUM,
        ZINC,
        POTASH
    }
}
