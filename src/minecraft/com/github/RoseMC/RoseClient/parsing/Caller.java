package com.github.RoseMC.RoseClient.parsing;

public class Caller
{
	public static void callSection(Mod m, Section s)
	{
		Section selected = null;
		for(Section sect : m.getSections().keySet())
		{
			if(sect.name.equals(s.name))
			{
				selected = sect;
				break;
			}
		}
		
		for(Call c : m.getSections().get(selected))
		{
			if(c.function.equals("println") && c.args.size() == 1)
			{
				System.out.println("[MOD] "+c.args.get(0));
			}
		}
	}
}
