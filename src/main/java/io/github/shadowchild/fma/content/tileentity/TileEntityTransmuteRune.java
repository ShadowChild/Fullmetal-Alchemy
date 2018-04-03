package io.github.shadowchild.fma.content.tileentity;


import com.google.common.primitives.Ints;
import io.github.shadowchild.fma.Fullmetal;
import io.github.shadowchild.fma.api.RuneType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class TileEntityTransmuteRune extends BaseTileEntity {

    private List<Integer> connectedRunes = new ArrayList<>(6);
    public ItemStackHandler inventory = new ItemStackHandler(1) {

        @Override
        protected void onContentsChanged(int slot) {

            TileEntity te = world.getTileEntity(pos);
            if(!world.isRemote && te instanceof TileEntityTransmuteRune) {

                ((TileEntityTransmuteRune)te).lastChangeTime = world.getTotalWorldTime();
                connectedRunes.forEach(integer -> Fullmetal.LOGGER.info(RuneType.getFromInt(integer)));
                Fullmetal.LOGGER.info(((TileEntityTransmuteRune)te).connectedRunes);
                sendUpdates();
            }
        }
    };

    @Override
    public void onLoad() {

        if(!world.isRemote) {

            lastChangeTime = world.getTotalWorldTime();
            sendUpdates();
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {

        inventory.deserializeNBT(compound.getCompoundTag("inventory"));
        if(compound.hasKey("runes")) {

            int[] runes = compound.getIntArray("runes");
            connectedRunes = Ints.asList(runes);
        }
        super.readFromNBT(compound);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {

        compound.setTag("inventory", inventory.serializeNBT());
        compound.setIntArray("runes", Ints.toArray(connectedRunes));
        return super.writeToNBT(compound);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {

        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {

        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)inventory : super.getCapability(capability, facing);
    }

    public List<Integer> getConnectedRunes() {

        return connectedRunes;
    }

    public void addRune(int rune) {

        this.connectedRunes.add(rune);
    }
}
