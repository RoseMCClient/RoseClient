package com.github.RoseMC.RoseClient.utils;

import java.util.*;

public class ServiceManager
{
	public static List<Service> SERVICES = new ArrayList<Service>();
	
	public static void InitServices() throws Exception
	{
		for(Service s : ServiceManager.SERVICES)
		{
			s.OnStart();
		}
	}
	
	public static void AddService(Service s)
	{
		ServiceManager.SERVICES.add(s);
	}
	
	public static Service GetService(Class c)
	{
		for(Service s : ServiceManager.SERVICES)
		{
			if(c.isInstance(s))
			{
				return s;
			}
		}
		return null;
	}
}
