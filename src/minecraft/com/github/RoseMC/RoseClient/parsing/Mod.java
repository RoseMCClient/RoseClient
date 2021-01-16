package com.github.RoseMC.RoseClient.parsing;

import java.util.*;

public class Mod
{
	private Map<Section, List<Call>> sections = new HashMap<Section, List<Call>>();
	
	public void addSection(Section section)
	{
		sections.put(section, new ArrayList<Call>());
	}
	
	public void addCall(Section section, Call call)
	{
		sections.get(section).add(call);
	}
	
	public Map<Section, List<Call>> getSections()
	{
		return this.sections;
	}
	
	public boolean hasSection(Section section)
	{
		return sections.containsKey(section);
	}
}
