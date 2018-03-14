package io.github.shadowchild.fma.content.item;


import io.github.shadowchild.fma.content.base.ItemBase;
import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemPStone extends ItemBase {

    private final boolean isFake;

    public ItemPStone(String label, boolean isFake) {

        super(label);
        this.isFake = isFake;
        this.setMaxStackSize(1);
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack) {

        return true;
    }

    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {

        return isFake ? EnumRarity.UNCOMMON : EnumRarity.EPIC;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        tooltip.add("A stone which is said to break the law of exchange!");
        if(isFake) tooltip.add("Something doesn't seem quite right with this Stone...");
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {

        if(isFake && !worldIn.isRemote) {

            int rand1 = Refs.RANDOM.nextInt(15);
            int rand2 = Refs.RANDOM.nextInt(15);
            if(rand1 == rand2) {

                player.inventory.deleteStack(player.getHeldItem(hand));
                player.attackEntityFrom(Refs.FAKE_STONE_FAILURE, player.getHealth() + 5f);
                worldIn.createExplosion(player, player.posX, player.posY, player.posZ, 2f, true);
                return new ActionResult<>(EnumActionResult.FAIL, player.getHeldItem(hand));
            }
        }
        return super.onItemRightClick(worldIn, player, hand);
    }
}
