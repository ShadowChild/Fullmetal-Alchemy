package io.github.shadowchild.fma.client;


import io.github.shadowchild.util.geometry.Point;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.util.List;

@SideOnly(Side.CLIENT)
public class RenderWorldHandler {

    public static List<Point> circlePointsList;
    public static EnumFacing circleFacingPosition;
    public static BlockPos positionHit;

    @SubscribeEvent
    public void renderPoints(RenderWorldLastEvent e) {

        if (circlePointsList == null) return;
        // Show the player what they're drawing.

        EntityPlayerSP player = Minecraft.getMinecraft().player;
        double xDif = player.lastTickPosX + (player.posX - player.lastTickPosX) * e.getPartialTicks();
        double yDif = player.lastTickPosY + (player.posY - player.lastTickPosY) * e.getPartialTicks();
        double zDif = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * e.getPartialTicks();

        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.disableTexture2D();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();

        GlStateManager.pushMatrix();

        // Move to draw position and orientation.
        GlStateManager.translate(positionHit.getX() - xDif + 0.5, positionHit.getY() - yDif + 0.5, positionHit.getZ() - zDif + 0.5);
        switch (circleFacingPosition) {

            case DOWN:	GL11.glRotatef(90.0f, -1,  0, 0); break;
            case UP:	GL11.glRotatef(90.0f,  1,  0, 0); break;
            case NORTH: break;
            case SOUTH: GL11.glRotatef(180.0f, 0,  1, 0); break;
            case WEST:	GL11.glRotatef(90.0f,  0,  1, 0); break;
            case EAST: GL11.glRotatef(90.0f,  0, -1, 0); break;
        }
        GL11.glTranslatef(-0.5f, -0.5f, -0.502f);

        Tessellator tes = Tessellator.getInstance();
        BufferBuilder builder = tes.getBuffer();

        // Draw thicker black line.
        GlStateManager.color(0.0f, 0.0f, 0.0f, 0.5f);
        GlStateManager.glLineWidth(8.0f);
        builder.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION);
        for (Point p : circlePointsList)
            builder.pos(p.x, p.y, 0).endVertex();
        tes.draw();

        // Draw thinner white line.
        GlStateManager.color(0.7f, 0.7f, 0.9f, 0.5f);
        GlStateManager.glLineWidth(6.0f);
        builder.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION);
        for (Point p : circlePointsList)
            builder.pos(p.x, p.y, 0).endVertex();
        tes.draw();

        GlStateManager.popMatrix();

        GlStateManager.enableDepth();
        GlStateManager.enableLighting();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public static void clearCache() {

    }
}
