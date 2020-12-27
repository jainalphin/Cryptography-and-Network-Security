package com.cyphering;

import java.io.CharConversionException;
import java.util.Scanner;

public class PoyAlphabetic 
{
	public static void main(String[] args) 
	{
		System.out.println("Enter the msg...");
		Scanner sc = new Scanner(System.in);
		String msg=sc.nextLine();
		System.out.println("Enter the key...");
		String key=sc.nextLine();
		String CypherText="";
		
		for(int i=0;i<msg.length();i++)
		{
			
			if(i<key.length() )
			{
				int KeyInt= key.charAt(i)- 97;
				int MsgInt=(msg.charAt(i)+KeyInt-97) % 26 +97;
				char finalCt = (char)MsgInt;
				CypherText +=finalCt;
			}
			else
			{
				int KeyInt= key.charAt(i%key.length())- 97;
				int MsgInt=(msg.charAt(i)+KeyInt-97) % 26 +97;
				char finalCt = (char)MsgInt;
				CypherText +=finalCt;
			}
		}
		System.out.println("Cipher Text is...."+CypherText);
		String DecipherText="";
		for(int i=0;i<CypherText.length();i++)
		{
			
			if(i<key.length() )
			{
				int KeyInt= key.charAt(i)- 97;
				int MsgInt=(CypherText.charAt(i)-KeyInt-97+26) % 26 +97;
				char finalCt = (char)MsgInt;
				DecipherText +=finalCt;
			}
			else
			{
				int KeyInt= key.charAt(i%key.length())- 97;
				int MsgInt=(CypherText.charAt(i)-KeyInt-97+26) % 26 +97;
				char finalCt = (char)MsgInt;
				DecipherText +=finalCt;
			}
		}
		System.out.println("Deciphering...."+DecipherText);
	}
}
