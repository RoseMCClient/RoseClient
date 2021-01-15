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
		Wrapper.drawRect(0f, 0f, Wrapper.fontRenderer.getStringWidth(RoseClient.CLIENT+" "+RoseClient.VERSION+"    "), 50f, new Color(0.0f, 0.0f, 0.0f, 0.5f).getRGB());
		Wrapper.fontRenderer.drawStringWithShadow(RoseClient.CLIENT+" "+RoseClient.VERSION, 5, 5, Color.WHITE.getRGB());
		
		Wrapper.fontRenderer.drawStringWithShadow("Sprint: ", 5, 15, Color.WHITE.getRGB());
		
		if(GameValues.SPRINTING)
		{
			Wrapper.fontRenderer.drawStringWithShadow("         ON", 5, 15, Color.GREEN.getRGB());
		}
		else
		{
			Wrapper.fontRenderer.drawStringWithShadow("         OFF", 5, 15, Color.RED.getRGB());
		}
		
		Wrapper.fontRenderer.drawStringWithShadow("Boost FPS: ", 5, 25, Color.WHITE.getRGB());
		
		if(GameValues.BOOSTFPS)
		{
			Wrapper.fontRenderer.drawStringWithShadow("              ON", 5, 25, Color.GREEN.getRGB());
		}
		else
		{
			Wrapper.fontRenderer.drawStringWithShadow("              OFF", 5, 25, Color.RED.getRGB());
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
	}
}
