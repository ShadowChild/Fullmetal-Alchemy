package io.github.shadowchild.fma.content.base;


import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BaseBlockHorizontal extends BaseBlock {

    private static final PropertyDirection FACING = BlockHorizontal.FACING;

    public BaseBlockHorizontal(String label, Material material) {

        super(label, material);
        this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {

        EnumFacing facing = placer.getHorizontalFacing();
        world.setBlockState(pos, state.withProperty(FACING, facing), 2);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta & 3));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex();
    }

    @Override
    protected BlockStateContainer createBlockState() {

        if(FACING == null) {

            return new BlockStateContainer(this, PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL));
        }
        return new BlockStateContainer(this, FACING);
    }
}
