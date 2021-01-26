package com.github.RoseMC.RoseClient.parsing;

import net.minecraft.client.Minecraft;

public class Caller
{
	public static void callSection(Mod m, Section s)
	{
		String R1 = "", R2 = "", R3 = "", R4 = "", R5 = "", R6 = "";
		String scopedRegister = "";
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
				String output = "[MOD] "+c.args.get(0);
				
				if(!scopedRegister.equals(""))
				{
					String register = null;
					if(scopedRegister.equals("R1"))
					{
						register = R1;
					}
					else if(scopedRegister.equals("R2"))
					{
						register = R2;
					}
					else if(scopedRegister.equals("R3"))
					{
						register = R3;
					}
					else if(scopedRegister.equals("R4"))
					{
						register = R4;
					}
					else if(scopedRegister.equals("R5"))
					{
						register = R5;
					}
					else if(scopedRegister.equals("R6"))
					{
						register = R6;
					}
					
					output = output.replaceAll("%", register);
				}
				
				System.out.println(output);
			}
			else if(c.function.equals("regscope") && c.args.size() == 1)
			{
				String register = c.args.get(0);
				
				if(register.equals("R1") || register.equals("R2") || register.equals("R3") || register.equals("R4") || register.equals("R5") || register.equals("R6"))
				{
					scopedRegister = register;
				}
				else
				{
					throw new IllegalStateException("Invalid Register!");
				}
			}
			else if(c.function.equals("regset") && c.args.size() == 1)
			{
				String value = c.args.get(0);
				
				if(scopedRegister.equals("R1"))
				{
					R1 = value;
				}
				else if(scopedRegister.equals("R2"))
				{
					R2 = value;
				}
				else if(scopedRegister.equals("R3"))
				{
					R3 = value;
				}
				else if(scopedRegister.equals("R4"))
				{
					R4 = value;
				}
				else if(scopedRegister.equals("R5"))
				{
					R5 = value;
				}
				else if(scopedRegister.equals("R6"))
				{
					R6 = value;
				}
				else
				{
					throw new IllegalStateException("Invalid Register!");
				}
			}
			else if(c.function.equals("regclear") && c.args.size() == 0)
			{
				String value = "";
				
				if(scopedRegister.equals("R1"))
				{
					R1 = value;
				}
				else if(scopedRegister.equals("R2"))
				{
					R2 = value;
				}
				else if(scopedRegister.equals("R3"))
				{
					R3 = value;
				}
				else if(scopedRegister.equals("R4"))
				{
					R4 = value;
				}
				else if(scopedRegister.equals("R5"))
				{
					R5 = value;
				}
				else if(scopedRegister.equals("R6"))
				{
					R6 = value;
				}
				else
				{
					throw new IllegalStateException("Invalid Register!");
				}
			}
			else if(c.function.equals("regdescope") && c.args.size() == 0)
			{
				scopedRegister = "";
			}
			else if(c.function.equals("chat") && c.args.size() == 1)
			{
				String output = c.args.get(0);
				
				if(!scopedRegister.equals(""))
				{
					String register = null;
					if(scopedRegister.equals("R1"))
					{
						register = R1;
					}
					else if(scopedRegister.equals("R2"))
					{
						register = R2;
					}
					else if(scopedRegister.equals("R3"))
					{
						register = R3;
					}
					else if(scopedRegister.equals("R4"))
					{
						register = R4;
					}
					else if(scopedRegister.equals("R5"))
					{
						register = R5;
					}
					else if(scopedRegister.equals("R6"))
					{
						register = R6;
					}
					
					output = output.replaceAll("%", register);
				}
				
				Minecraft.getMinecraft().thePlayer.sendChatMessage(output);
			}
			else if(c.function.equals("ifdef") && c.args.size() == 2)
			{
				String name = c.args.get(0);
				Section section = new Section();
				section.name = name;
				
				String register = null;
				if(scopedRegister.equals("R1"))
				{
					register = R1;
				}
				else if(scopedRegister.equals("R2"))
				{
					register = R2;
				}
				else if(scopedRegister.equals("R3"))
				{
					register = R3;
				}
				else if(scopedRegister.equals("R4"))
				{
					register = R4;
				}
				else if(scopedRegister.equals("R5"))
				{
					register = R5;
				}
				else if(scopedRegister.equals("R6"))
				{
					register = R6;
				}
				
				if(register.equals(c.args.get(1)))
				{
					Caller.callSection(m, section);
				}
			}
			else if(c.function.equals("call") && c.args.size() == 1)
			{
				String name = c.args.get(0);
				Section section = new Section();
				section.name = name;
				
				Caller.callSection(m, section);
			}
		}
	}
}
