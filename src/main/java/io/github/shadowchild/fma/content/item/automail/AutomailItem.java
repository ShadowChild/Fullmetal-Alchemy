package io.github.shadowchild.fma.content.item.automail;


import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import baubles.api.render.IRenderBauble;
import io.github.shadowchild.fma.content.item.WearableItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class AutomailItem extends WearableItem implements IRenderBauble {

    public AutomailItem(String label) {

        super(label, BaubleType.BODY);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

        IBaublesItemHandler handler = BaublesApi.getBaublesHandler(playerIn);

        // 5 is the slow of the BODY bauble type
        handler.setStackInSlot(5, playerIn.getHeldItem(handIn));
        handler.setChanged(5, true);

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void onPlayerBaubleRender(ItemStack stack, EntityPlayer player, RenderType type, float partialTicks) {

        // TODO: Forward everythig here to a client only class
        // TODO: Find way of rendering when in 1st person
    }
}
