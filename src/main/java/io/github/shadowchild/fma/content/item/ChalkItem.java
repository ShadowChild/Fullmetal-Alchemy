package io.github.shadowchild.fma.content.item;


import io.github.shadowchild.fma.content.base.BaseItem;
import io.github.shadowchild.fma.content.block.TransmuteRuneBlock;
import io.github.shadowchild.fma.content.block.rune.RuneBlock;
import io.github.shadowchild.fma.init.InitBlocks;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class ChalkItem extends BaseItem {

    public ChalkItem(String label) {

        super(label);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        Block rune = worldIn.getBlockState(pos).getBlock();
        if(rune instanceof TransmuteRuneBlock) {

            return ((TransmuteRuneBlock)rune).doTransmute(worldIn, pos);
        } else {

            return placeRune(player, worldIn, pos, hand, facing);
        }
    }

    private EnumActionResult placeRune(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing) {

        boolean flag = worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos);
        BlockPos blockpos = flag ? pos : pos.offset(facing);
        ItemStack itemstack = player.getHeldItem(hand);

        if(player.canPlayerEdit(blockpos, facing, itemstack) && worldIn.mayPlace(worldIn.getBlockState(blockpos).getBlock(), blockpos, false, facing,null) && InitBlocks.rune_air.canPlaceBlockAt(worldIn, blockpos)) {

            RuneBlock rune = InitBlocks.RUNES.get(new Random().nextInt(InitBlocks.RUNES.size()));
            IBlockState state = rune.getDefaultState();
            worldIn.setBlockState(blockpos, state);

            if(player instanceof EntityPlayerMP) {

                CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP)player, blockpos, itemstack);
            }

            itemstack.shrink(1);
            return EnumActionResult.SUCCESS;
        } else {

            return EnumActionResult.FAIL;
        }
    }
}
