package com.github.RoseMC.RoseClient.utils;

public abstract class Service 
{
	private ServiceHandler handler;
	
	public abstract void OnStart() throws Exception;
	
	public ServiceHandler getHandler()
	{
		return this.handler;
	}
}
