package com.cyphering;

import java.util.Scanner;

public class HIlli {
		public static void main(String[] args) 
	{
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the PlainText....");
		String Plaintext=sc.nextLine();
		System.out.println("Enter the Key....");
		String Key=sc.nextLine();
		
		String EncryptedMsg=null;
		char Alphabet[] ={'a','b','c','d','e','f','g','h','i','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int n=2;
		while(n>0) 
		{
			if(Key.length() == 1)
			{
				n=1;
				break;
			}
			else if(Key.length()%n==0)
				break;
			else 
				n++;			
		}
		System.out.println("The n is....."+n);
		int AlphabetIndex=0,KeyIndex=0,PlaintextIndex=0,RowIndex=0,ColumnIndex=0;
		int KeyArray[][]=new int[n][n];
		int PlainTextArray[][]=new int[n][n];
		while(KeyIndex < Key.length())
		{
			AlphabetIndex=0;
			while(AlphabetIndex < Alphabet.length) 
			{
			if(Key.charAt(KeyIndex)==Alphabet[AlphabetIndex])
			{
				while(RowIndex < n)
				{
					while(ColumnIndex < n)
					{
						KeyArray[RowIndex][ColumnIndex]=AlphabetIndex;
							KeyIndex++;
							ColumnIndex++;
							break;
					}
					RowIndex++;
					break;
				}
				break;
			}
			AlphabetIndex++;
			}
//				for(int i=0;i<n;i++)
//				{
//					for(int j=0;j<n;j++)
//					{
//						if(PlaintextIndex < Plaintext.length() && Plaintext.charAt(PlaintextIndex)==Alphabet[AlphabetIndex])
//						{	
//							PlainTextArray[j][i]=AlphabetIndex;
//							PlaintextIndex++;
//					}
//				}
//			}
//			AlphabetIndex++;
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(KeyArray[i][j]+" ");
			}
			System.out.println();
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(PlainTextArray[j][i]+" ");
			}
			System.out.println();
		}
		
	}
}


