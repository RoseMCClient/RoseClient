package com.github.RoseMC.RoseClient;

import org.lwjgl.opengl.*;

import com.mojang.authlib.*;
import com.mojang.authlib.yggdrasil.*;

import net.minecraft.client.*;
import net.minecraft.util.*;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

public class RoseClient
{
	public static String CLIENT = "RoseClient";
	public static String VERSION = "Alpha v1.1";
	
	public static void StartClient()
	{
		Display.setTitle(CLIENT+" "+VERSION);
	}
	
	public static void OnAuth() throws Exception
	{
		File loginCache = new File(".login_cache");
		
		String username = "";
		String password = "";
		
		if(loginCache.exists())
		{
			Scanner fileScanner = new Scanner(loginCache);
			
			username = fileScanner.nextLine();
			password = fileScanner.nextLine();
			
			fileScanner.close();
		}
		else
		{
			username = JOptionPane.showInputDialog("Please enter your mojang account email: ");
			password = JOptionPane.showInputDialog("Please enter your mojang account password: ");
		}
		
		YggdrasilUserAuthentication auth = (YggdrasilUserAuthentication) new YggdrasilAuthenticationService(Proxy.NO_PROXY, "").createUserAuthentication(Agent.MINECRAFT);
		
		auth.setUsername(username);
		auth.setPassword(password);
		
		auth.logIn();
		
		Minecraft.getMinecraft().session = new Session(auth.getSelectedProfile().getName(), auth.getSelectedProfile().getId().toString(), auth.getAuthenticatedToken(), "mojang");
		
		FileWriter fw = new FileWriter(loginCache);
		fw.write(username+System.lineSeparator());
		fw.write(password);
		fw.close();
	}
}
