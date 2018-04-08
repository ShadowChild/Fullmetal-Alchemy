package io.github.shadowchild.fma.content.item;


import io.github.shadowchild.fma.Fullmetal;
import io.github.shadowchild.fma.content.base.BaseItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ChalkStickItem extends BaseItem {

    public ChalkStickItem(String label) {

        super(label);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        player.setActiveHand(hand);

        return EnumActionResult.SUCCESS;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {

        return EnumAction.BOW;
    }

    @Override
    public void onUsingTick(ItemStack stack, EntityLivingBase player, int count) {

        // We only want it to call on the client
        // Proxy still used in case of ClassNotFound Exceptions
        if(player.world.isRemote)
            Fullmetal.proxy.updateCircleDrawing(stack, player, count);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {

        // Try to recognise circle

        // Clear points cache
        Fullmetal.proxy.clearCircleCache();
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {

        return 72000;
    }
}
