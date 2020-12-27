package com.cyphering;

import java.util.Arrays;
import java.util.Scanner;

public class PlainFairCipher {
	public static void main(String[] args) 
	{ 
		System.out.println("Enter the key......"); 
		Scanner sc = new Scanner(System.in); 
	 String Key =sc.nextLine(); 
	 for(int i=0;i<Key.length();i++)
	 {
		 if(i+1 < Key.length())
		 {
			 if(Key.charAt(i)==Key.charAt(i+1))
			 {
				 String msg1=Key.substring(0,i+1);
				 String msg2 = Key.substring(i+1);
				 Key = msg1+'z'+msg2;
			 }
		 } 
	 }
	 char Alphabet[] ={'a','b','c','d','e','f','g','h','i','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	 char Alphabet2[]=new char[26-Key.length()];
	  
	  char KeyArray[][]= new char[5][5];
	  
	  //small variable..... 
	  int AlphabetIndex=0,KeyIndex=0;
	  int flag[]=new int[25];
	  Arrays.fill(flag, 0);
	  
	  //flag value deciding...........
	  for(int i=0;i<Key.length();i++) 
	  { 
		  while(AlphabetIndex < Alphabet.length)
		  {
			  if(Key.charAt(i)==Alphabet[AlphabetIndex])
			  {
				flag[AlphabetIndex]=1;
			  }
			  AlphabetIndex++;
		  }
		  AlphabetIndex=0;
	  }
	  //put character in alphbet2.............
	  AlphabetIndex=0;
	  for(int i=0;i<25;i++)
	  {
		if(flag[i]==1)
			continue;
		else
		{
			Alphabet2[AlphabetIndex]=Alphabet[i];
			AlphabetIndex++;
		}
	  }
	  //now putting value in keyarray....
	  AlphabetIndex=0;
	  for(int i=0;i<5;i++) 
	  { 
		  for(int j=0;j<5;j++) 
		  { 
			  if(KeyIndex==Key.length())
			  {
				  	  KeyArray[i][j]=Alphabet2[AlphabetIndex]; 
				  	  AlphabetIndex++; 
		  	  } 
			  else {
					  KeyArray[i][j]=Key.charAt(KeyIndex); 
					  KeyIndex++; 
					}
			  }
		  }	
		//printing key array...............
		  for (int i = 0; i < 5; i++) { for (int j = 0; j < 5; j++) {
		  System.out.print(KeyArray[i][j] + " "); } System.out.println(); }
		 
		 // printing msessage.....
		System.out.println("Enter the Message");
		String Message = sc.nextLine();
		Message = (Message.length()%2==0 ? Message : Message+"z");
		//get the formated message........
		System.out.println("message is...."+Message);
		int m=0,x1,y1,x2,y2;
		String CipherText="";
		int flag2=0;
		while (m < Message.length())
		{
			flag2 = 0;
			for (int i=0;i<5;i++) 
			{
				if (flag2==0) 
				{
					for (int j=0;j<5;j++) 
					{
						if(flag2==0 && Message.charAt(m)==KeyArray[i][j]) 
						{
							x1 = i;
							y1 = j;
							m++;
							flag2 = 1;
							int flag1 = 0;
							for(int i1=0;i1<5;i1++)
							{
								if (flag1 == 0)
								{
									for(int j1=0;j1<5;j1++)
									{
										if (flag1==0 && Message.charAt(m)==KeyArray[i1][j1])
										{
											x2=i1;
											y2=j1;
											m++;
											if (x1==x2)
											{
												CipherText=CipherText+KeyArray[x1][(y1+1)%5]+KeyArray[x2][(y2+1)%5];// flag1=1;
											} else if (y1==y2)
											{
												CipherText=CipherText+KeyArray[(x1+1)%5][y1]+KeyArray[(x2+1)%5][y2];// flag1=1;
											} else 
											{
												CipherText=CipherText+KeyArray[x1][y2]+KeyArray[x2][y1];// flag1=1;
											}
											flag1 = 1;
										}
									}
								}
							}
						}

					}
				} else
					break;
			}
		}
		System.out.println("cipher text is..."+CipherText);
		
		String DecipherText="";
		m=0;
		while (m < CipherText.length())
		{
			flag2 = 0;
			for (int i=0;i<5;i++) 
			{
				if (flag2==0) 
				{
					for (int j=0;j<5;j++) 
					{
						if(flag2==0 && CipherText.charAt(m)==KeyArray[i][j]) 
						{
							x1 = i;
							y1 = j;
							m++;
							flag2 = 1;
							int flag1 = 0;
							for(int i1=0;i1<5;i1++)
							{
								if (flag1 == 0)
								{
									for(int j1=0;j1<5;j1++)
									{
										if (flag1==0 && CipherText.charAt(m)==KeyArray[i1][j1])
										{
											x2=i1;
											y2=j1;
											m++;
											if (x1==x2)
											{
												DecipherText=DecipherText+KeyArray[x1][(y1+4)%5]+KeyArray[x2][(y2+4)%5];// flag1=1;
											} else if (y1==y2)
											{
												DecipherText=DecipherText+KeyArray[(x1+4)%5][y1]+KeyArray[(x2+4)%5][y2];// flag1=1;
											} else 
											{
												DecipherText=DecipherText+KeyArray[x1][y2]+KeyArray[x2][y1];// flag1=1;
											}
											flag1 = 1;
										}
									}
								}
							}
						}

					}
				} else
					break;
			}
		}
		
		System.out.println("Decipher Text...."+DecipherText);
	}
}
