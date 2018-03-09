package io.github.shadowchild.fma;


import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EntityKilledHandler {

    @SubscribeEvent
    public static void onEntityKilled(LivingDeathEvent e) {

        EntityLivingBase entity = e.getEntityLiving();

        System.out.println("Entity Killed");
    }
}
