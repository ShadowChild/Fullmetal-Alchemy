package io.github.shadowchild.fma.content.item;


import baubles.api.BaubleType;
import baubles.api.render.IRenderBauble;
import io.github.shadowchild.fma.utils.NBTUtils;
import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class SoulVesselItem extends WearableItem implements IRenderBauble {

    public SoulVesselItem(String label) {

        super(label, BaubleType.BELT);
        this.setMaxStackSize(1);
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

        return 1 - (tag.getDouble(NBTUtils.SOUL_NBT_TAG) / (double)this.getMaxDamage(stack));
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {

        return super.getRGBDurabilityForDisplay(stack);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {

        // Holds 4 Buckets worth of souls
        return Refs.SOUL_VOLUME * 4;
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
    private double getSoulPercentage(ItemStack vessel) {

        NBTTagCompound tag = NBTUtils.getModTagCompound(vessel);

        return tag.getDouble(NBTUtils.SOUL_NBT_TAG) / (double)Refs.SOUL_VOLUME;
    }

    @Override
    public void onPlayerBaubleRender(ItemStack stack, EntityPlayer player, RenderType type, float partialTicks) {

    }
}
