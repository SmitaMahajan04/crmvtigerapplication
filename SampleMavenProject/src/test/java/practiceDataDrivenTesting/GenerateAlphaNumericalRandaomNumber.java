package practiceDataDrivenTesting;

import java.util.Random;

public class GenerateAlphaNumericalRandaomNumber {
	public static void main(String[] args) {
		int n=20;
		//choose acharacter random from this string
		String alphaNumercString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		//create a string buffer size of alphaNumericString
		StringBuilder sb=new StringBuilder(n);
		
		for(int i=0;i<n ;i++)
		{
			//generate a random number between 0 to AlphanumericString variable lenght
			int index=(int)(alphaNumercString.length()*Math.random());
			
			//add character one bye one in end of sb
			sb.append(alphaNumercString.charAt(index));
		
		}
		System.out.println(sb);
	}

}
