package com.github.RoseMC.RoseClient.json;

import com.google.gson.*;

public class GSONHelpers
{
	public Gson gson = new Gson();
	
	public static GSONHelpers instance;
	
	public GSONHelpers()
	{
		if(GSONHelpers.instance == null)
		{
			GSONHelpers.instance = this;
		}
	}
}