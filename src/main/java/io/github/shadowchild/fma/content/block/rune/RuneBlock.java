package io.github.shadowchild.fma.content.block.rune;


import io.github.shadowchild.fma.api.FullmetalAPI;
import io.github.shadowchild.fma.api.RuneType;
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

        super(label, FullmetalAPI.RUNE);
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
}
