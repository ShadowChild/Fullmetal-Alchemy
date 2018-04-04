package io.github.shadowchild.fma.content.item;


import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import io.github.shadowchild.fma.content.base.BaseItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class WearableItem extends BaseItem implements IBauble {

    private BaubleType baubleType;

    public WearableItem(String label, BaubleType baubleType) {

        super(label);
        this.baubleType = baubleType;
        this.setMaxStackSize(1);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {

        return baubleType;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        // Allows equipping a bauble by right clicking with it
        IBaublesItemHandler handler = BaublesApi.getBaublesHandler(playerIn);

        int[] slots = this.baubleType.getValidSlots();

        // check if slot contains an item
        for(int i : slots) {

            ItemStack stack = handler.getStackInSlot(i);
            if(!ItemStack.areItemsEqual(ItemStack.EMPTY, stack) && !stack.isEmpty()) {

                handler.setStackInSlot(i, playerIn.getHeldItem(handIn));
            }
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
