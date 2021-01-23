package com.github.RoseMC.RoseClient;

import org.lwjgl.opengl.*;

import com.github.RoseMC.RoseClient.game.*;
import com.github.RoseMC.RoseClient.json.*;
import com.github.RoseMC.RoseClient.parsing.*;
import com.github.RoseMC.RoseClient.serialization.*;
import com.github.RoseMC.RoseClient.utils.*;
import com.mojang.authlib.*;
import com.mojang.authlib.yggdrasil.*;

import net.minecraft.client.*;
import net.minecraft.util.*;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Logger;

import javax.swing.*;

public class RoseClient
{
	public static String CLIENT = "RoseClient";
	public static String VERSION = "Alpha v1.9";
	
	public static void StartClient()
	{
		Display.setTitle(CLIENT+" "+VERSION);
		
		// Initialize GSON
		new GSONHelpers();
		Logger.getGlobal().info("Initialized GSON!");
		ModSerialization.loadMods();
		GameValues.FOV = Minecraft.getMinecraft().gameSettings.fovSetting;
		
		// FullBright
		Minecraft.getMinecraft().gameSettings.gammaSetting = 1000f;
	}
	
	public static void OnAuth() throws Exception
	{
		ServiceManager.AddService(new LoginService());
		ServiceManager.InitServices();
	}
}
