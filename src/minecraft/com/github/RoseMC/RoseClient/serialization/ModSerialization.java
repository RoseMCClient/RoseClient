package com.github.RoseMC.RoseClient.serialization;

import java.util.*;
import java.util.logging.*;
import java.io.*;

import com.github.RoseMC.RoseClient.parsing.*;

public class ModSerialization
{
	private static List<Mod> MODS = new ArrayList<Mod>();
	private static List<String> URLS = new ArrayList<String>();
	
	public static void loadMods()
	{
		File modCache = new File(".mod_cache");
		
		if(modCache.exists())
		{
			try
			{
				Scanner sc = new Scanner(modCache);
				while(sc.hasNextLine())
				{
					if(sc.hasNext())
					{
						String modUrl = sc.nextLine();
						
						ModSerialization.URLS.add(modUrl);
						Logger.getGlobal().info("Added mod "+modUrl+"!");
					}
				}
				sc.close();
				
				for(String i : ModSerialization.URLS)
				{
					Mod m = Parser.ParseMod(i);
					ModSerialization.MODS.add(m);
					Section init = new Section();
					init.type = "section";
					init.name = "onInit";
					Caller.callSection(m, init);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				FileWriter fw = new FileWriter(modCache);
				fw.write("");
				fw.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void addMod(String URL)
	{
		if(ModSerialization.URLS.contains(URL))
		{
			Logger.getGlobal().info("Mod already installed (mod: "+URL+")!");
		}
		else
		{
			try
			{
				FileWriter fw = new FileWriter(new File(".mod_cache"), true);
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write(URL);
				bw.newLine();
				bw.close();
				fw.close();
				loadMods();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
