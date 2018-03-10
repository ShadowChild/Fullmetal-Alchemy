package io.github.shadowchild.fma.utils;


import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class NBTUtils {

    private static final String ITEM_NBT_CONST = "FMA";
    public static final String SOUL_NBT_TAG = "SOUL_COUNT";

    public static NBTTagCompound getModTagCompound(ItemStack stack) {

        NBTTagCompound ret;

        if(stack.hasTagCompound()) ret = stack.getOrCreateSubCompound(ITEM_NBT_CONST);
        else {

            stack.setTagCompound(new NBTTagCompound());
            ret = stack.getOrCreateSubCompound(ITEM_NBT_CONST);
        }

        return ret;
    }
}
