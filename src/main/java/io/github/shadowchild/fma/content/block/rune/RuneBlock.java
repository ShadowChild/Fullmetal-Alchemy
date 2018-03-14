package io.github.shadowchild.fma.content.block.rune;


import io.github.shadowchild.fma.content.base.BaseBlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class RuneBlock extends BaseBlockHorizontal {

    private final RuneType runeType;

    public RuneBlock(String label, RuneType runeType) {

        super(label, Material.CLOTH);
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
