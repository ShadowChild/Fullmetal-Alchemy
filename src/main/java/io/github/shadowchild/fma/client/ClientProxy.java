package io.github.shadowchild.fma.client;


import io.github.shadowchild.fma.Proxy;
import io.github.shadowchild.util.geometry.Point;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.concurrent.CopyOnWriteArrayList;

public class ClientProxy extends Proxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {

        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {

        super.init(e);
        MinecraftForge.EVENT_BUS.register(new RenderWorldHandler());
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {

        super.postInit(e);
    }

    @Override
    public void registerItemRenderer(Item item, int metadata, String id) {

        ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), id));
    }

    @Override
    public void initRenders() {

    }

    @Override
    public void updateCircleDrawing(ItemStack stack, EntityLivingBase player, int ticks) {

        RayTraceResult pos = Minecraft.getMinecraft().objectMouseOver;
        if(pos == null || pos.typeOfHit != RayTraceResult.Type.BLOCK) return;

//        Minecraft.getMinecraft().playerController.resetBlockRemoving();
        if(RenderWorldHandler.circlePointsList == null) {

            RenderWorldHandler.circlePointsList = new CopyOnWriteArrayList<>();
            RenderWorldHandler.circleFacingPosition = pos.sideHit;
            RenderWorldHandler.positionHit = pos.getBlockPos();
        }

        Point point = null;
        BlockPos posHit = RenderWorldHandler.positionHit;
        switch(RenderWorldHandler.circleFacingPosition) {

            // TODO: Map this correctly
            case DOWN: point = new Point(pos.hitVec.x - posHit.getX(), 1 - (pos.hitVec.z - posHit.getZ())); break;
            case UP: point = new Point(     pos.hitVec.x - posHit.getX(),  pos.hitVec.z - posHit.getZ()); break;
            case NORTH: point = new Point(     pos.hitVec.x - posHit.getX(),  pos.hitVec.y - posHit.getY()); break;
            case SOUTH: point = new Point(1 - (pos.hitVec.x - posHit.getX()), pos.hitVec.y - posHit.getY()); break;
            case WEST: point = new Point(1 - (pos.hitVec.z - posHit.getZ()), pos.hitVec.y - posHit.getY()); break;
            case EAST: point = new Point(     pos.hitVec.z - posHit.getZ(),  pos.hitVec.y - posHit.getY()); break;
        }
        if (!RenderWorldHandler.circlePointsList.isEmpty()) {
            double distance = point.distanceTo(RenderWorldHandler.circlePointsList.get(RenderWorldHandler.circlePointsList.size() - 1));
            if (distance < 0.005 || distance > 0.7)
                // Return if new point is too close or far to last point.
                return;
        }
        RenderWorldHandler.circlePointsList.add(point);
    }

    @Override
    public void clearCircleCache() {

        RenderWorldHandler.clearCache();
    }
}
