package io.github.shadowchild.fma.handler;


import baubles.api.BaublesApi;
import io.github.shadowchild.fma.api.FullmetalAPI;
import io.github.shadowchild.fma.init.InitItems;
import io.github.shadowchild.fma.utils.NBTUtils;
import io.github.shadowchild.fma.utils.Refs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EntityKilledHandler {

    @SubscribeEvent
    public static void onEntityKilled(LivingDeathEvent e) {

        Entity source = e.getSource().getTrueSource();
        if(!(source instanceof EntityPlayer)) return;

        int vesselEquipped = BaublesApi.isBaubleEquipped((EntityPlayer)source, InitItems.vessel_soul);
        if(vesselEquipped != -1) {

            EntityLivingBase entity = e.getEntityLiving();
            if(FullmetalAPI.getEntitySoulBlacklist().contains(entity.getClass())) return;

            EntityPlayer player = (EntityPlayer)source;
            ItemStack vessel = BaublesApi.getBaublesHandler(player).getStackInSlot(vesselEquipped);
            NBTTagCompound tag = NBTUtils.getModTagCompound(vessel);
            double souls = tag.getDouble(NBTUtils.SOUL_NBT_TAG) + Refs.ENTITY_SOUL_VOLUME;
            if(souls > vessel.getMaxDamage()) {

                souls = vessel.getMaxDamage();
                player.sendMessage(new TextComponentString("Unable to collect any more Souls in this Vessel!"));
            }
            tag.setDouble(NBTUtils.SOUL_NBT_TAG, souls);
        }
    }
}
