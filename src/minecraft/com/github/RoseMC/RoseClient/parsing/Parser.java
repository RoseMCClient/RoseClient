package com.github.RoseMC.RoseClient.parsing;

import java.util.*;
import java.io.*;
import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;

import com.github.RoseMC.RoseClient.json.*;
import com.github.RoseMC.RoseClient.utils.*;

public class Parser
{
	public static Mod ParseMod(String url) throws ClientProtocolException, IOException
	{
		Mod mod = new Mod();
		HttpGet req = new HttpGet(url);
		HttpResponse res = Wrapper.httpclient.execute(req);
		
		Scanner reqScanner = new Scanner(res.getEntity().getContent());
		Section currentSection = null;
		
		while(reqScanner.hasNextLine())
		{
			String line = reqScanner.nextLine();
			
			JSONSerializable js = GSONHelpers.instance.gson.fromJson(line, JSONSerializable.class);
			
			if(js.getType().equals("section"))
			{
				Section sect = GSONHelpers.instance.gson.fromJson(line, Section.class);
				
				currentSection = sect;
				mod.addSection(sect);
			}
			else if(js.getType().equals("call"))
			{
				Call call = GSONHelpers.instance.gson.fromJson(line, Call.class);
				
				mod.addCall(currentSection, call);
			}
		}
		reqScanner.close();
		return mod;
	}
}