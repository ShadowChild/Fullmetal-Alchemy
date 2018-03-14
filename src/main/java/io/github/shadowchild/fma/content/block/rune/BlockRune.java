package io.github.shadowchild.fma.content.block.rune;


import io.github.shadowchild.fma.content.base.BlockBaseHorizontal;
import net.minecraft.block.state.IBlockState;

public class BlockRune extends BlockBaseHorizontal {

    private final RuneType runeType;

    public BlockRune(String label, RuneType runeType) {

        super(label);
        this.runeType = runeType;
    }

    public RuneType getRuneType() {

        return runeType;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {

        return true;
    }

    @Override
    public boolean isFullBlock(IBlockState state) {

        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {

        return false;
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
