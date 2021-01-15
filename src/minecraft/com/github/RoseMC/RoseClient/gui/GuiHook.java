package com.github.RoseMC.RoseClient.gui;

import java.awt.Color;

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
	}
}
