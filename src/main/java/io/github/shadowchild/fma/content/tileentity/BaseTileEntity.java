package io.github.shadowchild.fma.content.tileentity;


import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

import javax.annotation.Nullable;

public class BaseTileEntity extends TileEntity {

    // EVERYTHING BELOW HERE NEEDED TO SYNC CLIENT AND SERVER DATA
    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {

        NBTTagCompound tagCompound = writeToNBT(new NBTTagCompound());
        return new SPacketUpdateTileEntity(getPos(), 1, tagCompound);
    }

    @Override
    public NBTTagCompound getUpdateTag() {

        return writeToNBT(new NBTTagCompound());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {

        this.readFromNBT(packet.getNbtCompound());
    }
}
