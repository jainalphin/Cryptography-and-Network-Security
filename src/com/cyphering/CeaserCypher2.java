package com.cyphering;

import java.util.Scanner;

public class CeaserCypher2 {
	static String CypherText = "";
	static int key;
	static String plain_text =""; 
	
	public static void main(String[] args) 
	{
		Scanner sc =new Scanner(System.in);//
		System.out.println("Enter the plan text.....");
		String s1 = sc.nextLine();
		System.out.println("Enter the key....");
		key = sc.nextInt();
		
		for(int i=0;i<s1.length();i++)
		{
			if(Character.isLowerCase(s1.charAt(i)))
			{
				int ct=(s1.charAt(i)+key-97) % 26 +97;
				//System.out.println(ct);
				char finalCt = (char)ct;
				CypherText +=finalCt;
			}
			else
			{
				int ct=(s1.charAt(i)+key-65) % 26 +65;
				//System.out.println(ct);
				char finalCt = (char)ct;
				CypherText +=finalCt;
			}
			
		}
		System.out.println("Encrypted Code : "+CypherText);
		
		for(int i=0;i<CypherText.length();i++)
		{
			if(Character.isLowerCase(CypherText.charAt(i)))
			{
				int pt = (CypherText.charAt(i)-97-key )%26 + 97;
				char finalpt = (char) (pt<97 ?pt+26 : pt );
				plain_text += finalpt;
				
			}
			else
			{
				int pt = (CypherText.charAt(i)-key-65) % 26 +65;
				char finalpt = (char)(pt<65 ?pt+26 : pt );
				plain_text =plain_text+finalpt;
			}
			
		}
		System.out.println("Decrypted Code : "+plain_text);

	}

}
