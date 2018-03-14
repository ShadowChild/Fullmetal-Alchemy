package io.github.shadowchild.fma.content.item;


import baubles.api.BaubleType;
import baubles.api.IBauble;
import io.github.shadowchild.fma.content.base.BaseItem;
import io.github.shadowchild.fma.utils.NBTUtils;
import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class SoulVesselItem extends BaseItem implements IBauble {

    public SoulVesselItem(String label) {

        super(label);
        this.setMaxStackSize(1);
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {

        return BaubleType.BELT;
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack) {

        return true;
    }

    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {

        return EnumRarity.RARE;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        double percentage = getSoulPercentage(stack);
        if(percentage > 0.0d) tooltip.add("Souls Collected: " + percentage);
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {

        NBTTagCompound tag = NBTUtils.getModTagCompound(stack);
        double souls = tag.getDouble(NBTUtils.SOUL_NBT_TAG);

        return 1 - (souls / (double)this.getMaxDamage(stack));
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {

        return super.getRGBDurabilityForDisplay(stack);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {

        // Holds 16 times the normal bucket value
        return Refs.SOUL_VOLUME * 16;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {

        return getSoulPercentage(stack) > 0.0d;
    }

    /**
     *
     * @param vessel - the ItemStack of the Soul Vessel
     * @return a value above 0.0 to mark percentage souls contained within.
     */
    public double getSoulPercentage(ItemStack vessel) {

        double ret;

        NBTTagCompound tag = NBTUtils.getModTagCompound(vessel);
        double souls = tag.getDouble(NBTUtils.SOUL_NBT_TAG);

        ret = souls / (double)Refs.SOUL_VOLUME;

        return ret;
    }
}
