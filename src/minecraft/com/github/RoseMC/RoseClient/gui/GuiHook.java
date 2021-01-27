package com.github.RoseMC.RoseClient.gui;

import java.awt.*;

import com.github.RoseMC.RoseClient.*;
import com.github.RoseMC.RoseClient.game.*;
import com.github.RoseMC.RoseClient.utils.*;

import net.minecraft.client.*;
import net.minecraft.client.gui.*;

public class GuiHook
{
	public static void Render(float partialTicks)
	{
		ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
		Wrapper.drawRect(0f, 0f, Wrapper.fontRenderer.getStringWidth(RoseClient.CLIENT+" "+RoseClient.VERSION+"                              "), 80f, new Color(0.0f, 0.0f, 0.0f, 0.5f).getRGB());
		Wrapper.fontRenderer.drawStringWithShadow(RoseClient.CLIENT+" "+RoseClient.VERSION, 5, 5, Color.WHITE.getRGB());
		
		Wrapper.fontRenderer.drawStringWithShadow("Sprint: ", 5, 15, Color.WHITE.getRGB());
		
		if(GameValues.SPRINTING)
		{
			Wrapper.fontRenderer.drawStringWithShadow("         ON (G to enable, H to disable)", 5, 15, Color.GREEN.getRGB());
		}
		else
		{
			Wrapper.fontRenderer.drawStringWithShadow("         OFF (G to enable, H to disable", 5, 15, Color.RED.getRGB());
		}
		
		Wrapper.fontRenderer.drawStringWithShadow("Boost FPS: ", 5, 25, Color.WHITE.getRGB());
		
		if(GameValues.BOOSTFPS)
		{
			Wrapper.fontRenderer.drawStringWithShadow("              ON (B to enable, N to disable", 5, 25, Color.GREEN.getRGB());
		}
		else
		{
			Wrapper.fontRenderer.drawStringWithShadow("              OFF  (B to enable, N to disable", 5, 25, Color.RED.getRGB());
		}
		
		if(Minecraft.getMinecraft().getDebugFPS() >= 60)
		{
			Wrapper.fontRenderer.drawStringWithShadow("FPS: "+Minecraft.getMinecraft().getDebugFPS(), 5, 35, Color.GREEN.getRGB());
		}
		else if(Minecraft.getMinecraft().getDebugFPS() >= 30)
		{
			Wrapper.fontRenderer.drawStringWithShadow("FPS: "+Minecraft.getMinecraft().getDebugFPS(), 5, 35, Color.YELLOW.getRGB());
		}
		else if(Minecraft.getMinecraft().getDebugFPS() >= 10)
		{
			Wrapper.fontRenderer.drawStringWithShadow("FPS: "+Minecraft.getMinecraft().getDebugFPS(), 5, 35, Color.ORANGE.getRGB());
		}
		else
		{
			Wrapper.fontRenderer.drawStringWithShadow("FPS: "+Minecraft.getMinecraft().getDebugFPS(), 5, 35, Color.RED.getRGB());
		}
		
		// Coords
		
		Wrapper.fontRenderer.drawStringWithShadow("X: "+Math.round(Minecraft.getMinecraft().thePlayer.posX), 5, 50, Color.WHITE.getRGB());
		Wrapper.fontRenderer.drawStringWithShadow("Y: "+Math.round(Minecraft.getMinecraft().thePlayer.posY), 5, 60, Color.WHITE.getRGB());
		Wrapper.fontRenderer.drawStringWithShadow("Z: "+Math.round(Minecraft.getMinecraft().thePlayer.posZ), 5, 70, Color.WHITE.getRGB());
		
		// Improve FPS
		
		if(GameValues.BOOSTFPS)
		{
			Minecraft.getMinecraft().gameSettings.enableVsync = false;
			Minecraft.getMinecraft().gameSettings.limitFramerate = Integer.MAX_VALUE;
		}
		else
		{
			Minecraft.getMinecraft().gameSettings.enableVsync = true;
			Minecraft.getMinecraft().gameSettings.limitFramerate = 60;
		}
		
		// Zoom
		
		if(GameValues.ZOOMED)
		{
			Minecraft.getMinecraft().gameSettings.fovSetting = 30;
		}
		else
		{
			Minecraft.getMinecraft().gameSettings.fovSetting = GameValues.FOV;
		}
	}
}
