package io.github.shadowchild.fma.content.block;


import io.github.shadowchild.fma.content.base.BaseBlockHorizontal;
import io.github.shadowchild.fma.content.tileentity.TileEntityTransmuteRune;
import io.github.shadowchild.fma.init.InitBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMaterialMatcher;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nullable;

public class TransmuteRuneBlock extends BaseBlockHorizontal {

    private BlockPattern circle_pattern;

    public TransmuteRuneBlock(String label) {

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

    @Override
    public boolean hasTileEntity(IBlockState state) {

        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {

        return new TileEntityTransmuteRune();
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {

        super.onBlockPlacedBy(world, pos, state, placer, stack);

        Block rune = world.getBlockState(pos).getBlock();
        if(rune instanceof TransmuteRuneBlock){

            // Attempt to create the circle
            BlockPattern.PatternHelper helper = ((TransmuteRuneBlock)rune).getOrCreateBlockPattern().match(world, pos);
            if(helper != null) {

                // TODO: Add transmuting and effects here
                world.playBroadcastSound(1038, pos.add(1, 0, 1), 0);
            }
        }
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {

        TileEntity tile = world.getTileEntity(pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack = itemHandler.getStackInSlot(0);
        if (!stack.isEmpty()) {

            EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntity(item);
        }
        super.breakBlock(world, pos, state);
    }

    // WIP Method
    public void doTransmute(World world, BlockPos pos) {

        if(!world.isRemote) {

            TileEntity tile = world.getTileEntity(pos);
            IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);

            // TODO: check transmuate recipes here
            itemHandler.insertItem(0, new ItemStack(Items.COOKIE), false);
            tile.markDirty();
            IBlockState state = world.getBlockState(pos);
            world.notifyBlockUpdate(pos, state, state, 3);
        }
    }
}
