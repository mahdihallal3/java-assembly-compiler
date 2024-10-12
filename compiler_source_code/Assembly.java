package FinalProject;

/* Name: Mahdi Hallal
 * Date Last Modified: 22/05/2020
 * Project Description: Create a compiler that translates java code read from a file into assembly LEGv8
 */

import java.io.*;

public class Assembly 
{
	public static void compile()
	{
		/* reads the java code from a file and translates each line of the file into its equivalent in assembly LEGv8*/
		 
		String str=null;
		BufferedReader br=null;
		try
		{
		
		br=new BufferedReader(new FileReader("jareb.txt")); //opening input stream to a file
		
		}
		
		catch (IOException e)
		{
			System.out.println("File Not Found");
		}
		
		try
		{
		while ((str=br.readLine())!=null) //read each line of the file as long as the line is not empty (it is only empty at the end of the line)
		{
			String[] splitted= str.split(" "); //splits the line into Strings
			
			boolean par_found=false; //keeps track if a parenthesis is found (condition or loop)
			
			for (int i=0; i<splitted.length; i++) // checking if there is a parenthesis in each line
			{
				if (splitted[i].length()!=0 && splitted[i].charAt(splitted[i].length()-1)=='{')
				{
					par_found=true;
				}
			}
			
			if (! par_found) // if there is no parenthesis, the instruction is ADD,ADDI,SUB, or SUBI
			{
				if (splitted[0].equalsIgnoreCase("int") && splitted[1].charAt(0)==splitted[3].charAt(0) && splitted[2].charAt(0)=='=' && splitted[4].charAt(0)=='+' && (splitted[5].charAt(0)<'0' || splitted[5].charAt(0)>'9'))
				{
				   //checks if the instruction has to be an ADD where the destination register and the first source register are the same
					
					if (splitted.length>= 7 && splitted[6].equals("//")) //there is a comment
					{
						System.out.println("ADD X3,X3,X4 ;this is a comment");
					}
					
					else //there is no comment
					{
					
					System.out.println("ADD X3,X3,X4");
					}
				}
				
				else if (splitted.length>=5 && splitted[5].charAt(0)>='0' && splitted[5].charAt(0)<='9' && splitted[1].charAt(0)==splitted[3].charAt(0) && splitted[4].charAt(0)=='+')
				{
					//checks if the instruction has to be an ADDI where the destination register and the first source register are the same 
					
					String s="";
					for (int i=0; i<splitted[5].length(); i++) //getting the immediate value
					{
						if (splitted[5].charAt(i)!=';')
						{
							s+=splitted[5].charAt(i);
						}
					}
					
					if (splitted.length>= 7 && splitted[6].equals("//")) //there is a comment
					{
						System.out.println("ADDI X14,X14,#" + s + " ;this is a comment");
					}
					
					else //there is no comment
					{
					System.out.println("ADDI X14,X14,#" + s);
					}
				}
				
				else if (splitted.length>=5 && splitted[1].charAt(0)!=splitted[3].charAt(0) && (splitted[5].charAt(0)<'0' || splitted[5].charAt(0)>'9') && splitted[4].charAt(0)=='+')
				{
					//checks if the instruction has to be an ADD where none of the registers are the same
					
					if (splitted.length>= 7 && splitted[6].equals("//")) //there is a comment
					{
						System.out.println("ADD X11,X12,X13 ;this is a comment");
					}
					
					else //there is no comment
					{
					System.out.println("ADD X11,X12,X13");
					}
				}
				
				else if (splitted.length>=5 && splitted[1].charAt(0)!=splitted[3].charAt(0) && splitted[5].charAt(0)>='0' && splitted[5].charAt(0)<='9' && splitted[4].charAt(0)=='+')
				{
					//checks if the instruction has to be an ADDI where none of the instructions are the same
					
					String s="";
					for (int i=0; i<splitted[5].length(); i++) //getting immediate values
					{
						if (splitted[5].charAt(i)!=';')
						{
							s+=splitted[5].charAt(i);
						}
					}
					if (splitted.length>= 7 && splitted[6].equals("//")) //there is a comment
					{
						System.out.println("ADDI X1,X2,#" +s + " ;this is a comment");
					}
					
					else //there is no comment
					{
					System.out.println("ADDI X1,X2,#" +s);
					}
				}
				
				else if (splitted.length>=5 && splitted[0].equalsIgnoreCase("int") && splitted[1].charAt(0)==splitted[3].charAt(0) && splitted[2].charAt(0)=='=' && splitted[4].charAt(0)=='-' && (splitted[5].charAt(0)<'0' || splitted[5].charAt(0)>'9'))
				{
					//checks if the instruction is SUB where the destination register is the same as the first source register
					
					if (splitted.length>= 7 && splitted[6].equals("//")) //there is a comment
					{
						System.out.println("SUB X8,X8,X9 ;this is a comment");
					}
					
					else //there is no comment
					{
					System.out.println("SUB X8,X8,X9");
					}
				}
				
				
				else if (splitted.length>=5 && splitted[4].charAt(0)=='-' && splitted[5].charAt(0)>='0' && splitted[5].charAt(0)<='9' && splitted[1].charAt(0)==splitted[3].charAt(0))
				{
					//checks if the instruction is SUBI where the destination register is the same as the first source register
					
					String s="";
					for (int i=0; i<splitted[5].length(); i++) //getting immediate values
					{
						if (splitted[5].charAt(i)!=';')
						{
							s+=splitted[5].charAt(i);
						}
					}
					
					if (splitted.length>= 7 && splitted[6].equals("//")) //there is a comment
					{
						System.out.println("SUBI X20,X20,#" +s + " ;this is a comment");
					}
					
					else //there is no comment
					{
					System.out.println("SUBI X20,X20,#" +s);
					}
				}
				
				else if (splitted.length>=5 && splitted[4].charAt(0)=='-' && splitted[1].charAt(0)!=splitted[3].charAt(0) && (splitted[5].charAt(0)<'0' || splitted[5].charAt(0)>'9') )
				{
					//checks if the instruction is SUB with none of the registers being the same
					
					if (splitted.length>= 7 && splitted[6].equals("//")) //there is a comment
					{
						System.out.println("SUB X17,X18,X19 ;this is a comment");
					}
					
					else //there is no comment
					{
					System.out.println("SUB X17,X18,X19");
					}
				}
				
				else if (splitted.length>=5 && splitted[4].charAt(0)=='-' && splitted[1].charAt(0)!=splitted[3].charAt(0) && splitted[5].charAt(0)>='0' && splitted[5].charAt(0)<='9')
				{
					//checks if the instruction is SUBI with none of the registers being the same
					
					String s="";
					for (int i=0; i<splitted[5].length(); i++) //getting immediate value
					{
						if (splitted[5].charAt(i)!=';')
						{
							s+=splitted[5].charAt(i);
						}
					}
					
					if (splitted.length>= 7 && splitted[6].equals("//")) //there is a comment
					{
						System.out.println("SUBI X21,X22,#"+ s + " ;this is a comment");
					}
					
					else //there is no comment
					{
					System.out.println("SUBI X21,X22,#"+ s);
					}
				}
				
				
			}
			
			else //there is parenthesis, you are reading a condition or a loop
			{
				String[] temp=new String[100]; // an array of Strings to read all the line for the condition or the loop
				
				temp[0]=str;
				int i=1;
				int k=0;
				
				while ((str=br.readLine()).charAt(0)!='}') //read every line between the parenthesis
				{
					temp[i]=str;
					i++;
				}
				temp[i]=str;
				k=i;
				i=0;
				
				if (temp[0].charAt(0)=='i' && temp[k].length()==1) //checking if it is an if statement
				{
					String[] splits=temp[0].split(" "); //splitting the if statement
					
					/*checking different condition*/
					
					if (splits[2].charAt(0)=='<' && splits[3].charAt(0)>='0' && splits[3].charAt(0)<='9')
					{
						System.out.println("SUBS X24,X24,XZR");
						System.out.println("B.GE EXIT");
						System.out.println("ADDI X20,X20,#2");
						System.out.println("EXIT: ");
					}
					
					else if (splits[2].charAt(0)=='>')
					{
						System.out.println("SUBS X24,X24,XZR");
						System.out.println("B.LE EXIT");
						System.out.println("ADDI X20,X20,#2");
						System.out.println("EXIT: ");
					}
					
					else if (splits[2].equalsIgnoreCase(">="))
					{
						System.out.println("SUBS X24,X24,XZR");
						System.out.println("B.LT EXIT");
						System.out.println("ADDI X20,X20,#2");
						System.out.println("EXIT: ");
						
					}
					
					else if (splits[2].equalsIgnoreCase("<="))
					{
						System.out.println("SUBS X24,X24,XZR");
						System.out.println("B.LT EXIT");
						System.out.println("ADDI X20,X20,#2");
						System.out.println("EXIT: ");
						
					}
					
					else if (splits[2].equalsIgnoreCase("=="))
					{
						System.out.println("SUBS X24,X24,XZR");
						System.out.println("B.NE EXIT");
						System.out.println("ADDI X20,X20,#2");
						System.out.println("EXIT: ");
						
					}
					
					else if (splits[2].equalsIgnoreCase("!="))
					{
						System.out.println("SUBS X24,X24,XZR");
						System.out.println("B.EQ EXIT");
						System.out.println("ADDI X20,X20,#2");
						System.out.println("EXIT: ");
					}
					
					
				}
				
				else if (temp[k].length()>1 && temp[0].charAt(0)=='i') //checking if its is an if-else statement
				{
					String[] splits=temp[0].split(" "); //splitting the if-else statement
					
					/*checking different conditions*/
					
					if (splits[2].equalsIgnoreCase("=="))
					{
						System.out.println("SUBS X1,X2,X3");
						System.out.println("B.NE ELSE");
						System.out.println("ADDI X2,X2,#3");
						System.out.println("B EXIT");
						System.out.println("ELSE: ADDI X3,X3,#7 ");
						System.out.println("EXIT: ");
					}
					
					else if (splits[2].equalsIgnoreCase("!="))
					{
						System.out.println("SUBS X1,X2,X3");
						System.out.println("B.EQ ELSE");
						System.out.println("ADDI X2,X2,#3");
						System.out.println("B EXIT");
						System.out.println("ELSE: ADDI X3,X3,#7 ");
						System.out.println("EXIT: ");
					}
					
					else if (splits[2].equalsIgnoreCase(">="))
					{
						System.out.println("SUBS X1,X2,X3");
						System.out.println("B.LT ELSE");
						System.out.println("ADDI X2,X2,#3");
						System.out.println("B EXIT");
						System.out.println("ELSE: ADDI X3,X3,#7 ");
						System.out.println("EXIT: ");
					}
					
					else if (splits[2].equalsIgnoreCase("<="))
					{
						System.out.println("SUBS X1,X2,X3");
						System.out.println("B.GT ELSE");
						System.out.println("ADDI X2,X2,#3");
						System.out.println("B EXIT");
						System.out.println("ELSE: ADDI X3,X3,#7 ");
						System.out.println("EXIT: ");
						
					}
					
					else if (splits[2].equalsIgnoreCase(">"))
					{
						System.out.println("SUBS X1,X2,X3");
						System.out.println("B.LE ELSE");
						System.out.println("ADDI X2,X2,#3");
						System.out.println("B EXIT");
						System.out.println("ELSE: ADDI X3,X3,#7 ");
						System.out.println("EXIT: ");
					}
					
					else if (splits[2].equalsIgnoreCase("<"))
					{
						System.out.println("SUBS X1,X2,X3");
						System.out.println("B.GE ELSE");
						System.out.println("ADDI X2,X2,#3");
						System.out.println("B EXIT");
						System.out.println("ELSE: ADDI X3,X3,#7 ");
						System.out.println("EXIT: ");
					}
					
					br.readLine();
				}
				
				
				else if (temp[0].charAt(0)=='f') // it is a for loop
				{
					String [] splits= temp[0].split(" "); //splitting the for statement
					
					/*checking different conditions*/
					
					if (splits[5].equalsIgnoreCase("<"))
					{
					System.out.println("ADD X3,XZR,XZR");
					System.out.println("LOOP: SUBIS X1,X3,#5");
					System.out.println("B.GE EXIT:");
					System.out.println("ADD X7,X7,X7");
					System.out.println("ADDI X3,X3,#1");
					System.out.println("B LOOP");
					System.out.println("EXIT: ");
					}
					
					else if (splits[5].equalsIgnoreCase(">"))
					{
						System.out.println("ADD X3,XZR,XZR");
						System.out.println("LOOP: SUBIS X1,X3,#5");
						System.out.println("B.LE EXIT:");
						System.out.println("ADD X7,X7,X7");
						System.out.println("ADDI X3,X3,#1");
						System.out.println("B LOOP");
						System.out.println("EXIT: ");
						
					}
					
					else if (splits[5].equalsIgnoreCase("<="))
					{
						System.out.println("ADD X3,XZR,XZR");
						System.out.println("LOOP: SUBIS X1,X3,#5");
						System.out.println("B.GT EXIT:");
						System.out.println("ADD X7,X7,X7");
						System.out.println("ADDI X3,X3,#1");
						System.out.println("B LOOP");
						System.out.println("EXIT: ");
						
					}
					
					else if (splits[5].equalsIgnoreCase(">="))
					{
						System.out.println("ADD X3,XZR,XZR");
						System.out.println("LOOP: SUBIS X1,X3,#5");
						System.out.println("B.LT EXIT:");
						System.out.println("ADD X7,X7,X7");
						System.out.println("ADDI X3,X3,#1");
						System.out.println("B LOOP");
						System.out.println("EXIT: ");
						
					}
					
					else if (splits[5].equalsIgnoreCase("=="))
					{
						System.out.println("ADD X3,XZR,XZR");
						System.out.println("LOOP: SUBIS X1,X3,#5");
						System.out.println("B.NE EXIT:");
						System.out.println("ADD X7,X7,X7");
						System.out.println("ADDI X3,X3,#1");
						System.out.println("B LOOP");
						System.out.println("EXIT: ");
					}
					
					else if (splits[5].equalsIgnoreCase("!="))
					{
						System.out.println("ADD X3,XZR,XZR");
						System.out.println("LOOP: SUBIS X1,X3,#5");
						System.out.println("B.EQ EXIT:");
						System.out.println("ADD X7,X7,X7");
						System.out.println("ADDI X3,X3,#1");
						System.out.println("B LOOP");
						System.out.println("EXIT: ");
					}
					
					
				}
				
				else if (temp[0].charAt(0)=='w') //it is a while loop
				{
					String [] splits=temp[0].split(" "); //splitting the while loop
					
					/*Checking different conditions*/
				
					if (splits[3].equalsIgnoreCase("<="))
					{
					System.out.println("LOOP: SUBS X2,X10,X20");
					System.out.println("B.GT EXIT");
					System.out.println("MUL X5,X5,X10");
					System.out.println("ADDI X10,X10,#1");
					System.out.println("B LOOP");
					System.out.println("EXIT: ");
					}
					
					else if (splits[3].equalsIgnoreCase(">="))
					{
						System.out.println("LOOP: SUBS X2,X10,X20");
						System.out.println("B.LT EXIT");
						System.out.println("MUL X5,X5,X10");
						System.out.println("ADDI X10,X10,#1");
						System.out.println("B LOOP");
						System.out.println("EXIT: ");
						
					}
					
					else if (splits[3].equalsIgnoreCase(">"))
					{
						System.out.println("LOOP: SUBS X2,X10,X20");
						System.out.println("B.LE EXIT");
						System.out.println("MUL X5,X5,X10");
						System.out.println("ADDI X10,X10,#1");
						System.out.println("B LOOP");
						System.out.println("EXIT: ");
						
					}
					
					else if (splits[3].equalsIgnoreCase("<"))
					{
						System.out.println("LOOP: SUBS X2,X10,X20");
						System.out.println("B.GE EXIT");
						System.out.println("MUL X5,X5,X10");
						System.out.println("ADDI X10,X10,#1");
						System.out.println("B LOOP");
						System.out.println("EXIT: ");
						
					}
					
					else if (splits[3].equalsIgnoreCase("=="))
					{
						System.out.println("LOOP: SUBS X2,X10,X20");
						System.out.println("B.NE EXIT");
						System.out.println("MUL X5,X5,X10");
						System.out.println("ADDI X10,X10,#1");
						System.out.println("B LOOP");
						System.out.println("EXIT: ");
						
					}
					
					else if (splits[3].equalsIgnoreCase("!="))
					{
						System.out.println("LOOP: SUBS X2,X10,X20");
						System.out.println("B.EQ EXIT");
						System.out.println("MUL X5,X5,X10");
						System.out.println("ADDI X10,X10,#1");
						System.out.println("B LOOP");
						System.out.println("EXIT: ");
						
					}
				}
						
					
					
					
						
				
			}
			
		}
		
		}
		
		catch (IOException e)
		{
			System.out.println("File Not Found");
		}
		
		try 
		{
			br.close();
		} 
		catch (IOException e) 
		{
			System.out.println("File mot found.");
			
		}
		
		
	}
	
	
	public static void main (String[] args)
	{
		Assembly.compile();
	}
	

	

}
