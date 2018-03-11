package io.github.shadowchild.fma.content.item;


import baubles.api.BaubleType;
import baubles.api.IBauble;
import io.github.shadowchild.fma.content.ItemBase;
import io.github.shadowchild.fma.utils.NBTUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

import javax.annotation.Nullable;
import java.util.List;

public class ItemSoulVessel extends ItemBase implements IBauble {

    public ItemSoulVessel(String label) {

        super(label, "vessel");
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

        NBTTagCompound tag = NBTUtils.getModTagCompound(stack);
        int souls = tag.getInteger(NBTUtils.SOUL_NBT_TAG);
        if(souls > 0) tooltip.add("Souls Collected: " + souls);
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {

        NBTTagCompound tag = NBTUtils.getModTagCompound(stack);
        int souls = tag.getInteger(NBTUtils.SOUL_NBT_TAG);

        return 1 - ((double)souls / (double)this.getMaxDamage(stack));
    }

    @Override
    public int getRGBDurabilityForDisplay(ItemStack stack) {

        return super.getRGBDurabilityForDisplay(stack);
    }

    @Override
    public int getMaxDamage(ItemStack stack) {

        // Holds 16 times the normal bucket value
        return Fluid.BUCKET_VOLUME * 16;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {

        NBTTagCompound tag = NBTUtils.getModTagCompound(stack);
        int souls = tag.getInteger(NBTUtils.SOUL_NBT_TAG);
        return souls > 0;
    }
}
