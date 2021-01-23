package com.github.RoseMC.RoseClient.utils;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.*;

import com.mojang.authlib.*;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.*;
import com.mojang.authlib.yggdrasil.*;

import net.minecraft.client.*;
import net.minecraft.util.*;

public class LoginService extends Service
{
	@Override
	public void OnStart() throws Exception
	{
		File loginCache = new File(".login_cache");
		
		String username = "";
		String password = "";
		
		if(loginCache.exists())
		{
			Scanner fileScanner;
			fileScanner = new Scanner(loginCache);
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
		
		FileWriter fw;
		fw = new FileWriter(loginCache);
		fw.write(username+System.lineSeparator());
		fw.write(password);
		fw.close();
	}
}
