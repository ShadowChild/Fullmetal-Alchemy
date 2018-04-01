package io.github.shadowchild.fma.content.block.rune;


import io.github.shadowchild.fma.content.base.BaseBlock;
import io.github.shadowchild.fma.init.InitBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RuneBlock extends BaseBlock {

    private final RuneType runeType;

    public RuneBlock(String label, RuneType runeType) {

        super(label, InitBlocks.RUNE);
        this.runeType = runeType;
        InitBlocks.RUNES.add(this);
    }

    public RuneType getRuneType() {

        return runeType;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {

        switch(side) {

            case UP: {

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isBlockNormalCube(IBlockState blockState) {

        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {

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
