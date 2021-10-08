/**
 * 
 */
package com.revature.popractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Luis Rodriguez
 *
 */
public class CreditCardValidation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String cardOne = "1234567890123456";
		String msg1 = validate(cardOne) ? "Valid" : "Invalid"; 
		
		String cardTwo = "1234567890123452";
		String msg2 = validate(cardTwo) ? "Valid" : "Invalid"; 
		
		String cardThree = "0789456";
		String msg3 = validate(cardThree) ? "Valid" : "Invalid"; 
		
		String cardFour = "78659659999964408400";
		String msg4 = validate(cardFour) ? "Valid" : "Invalid"; 
		
		System.out.println(
				msg1 + "\n" +
				msg2 + "\n" +
				msg3 + "\n" +
				msg4 + "\n" );

	}
	
	public static boolean validate(String numAsString) {
		if(length(numAsString)) {
			return luhnTest(numAsString);
		}else {
			return false;
		}
	}
	
	
	//check if length is between 14-19
	public static boolean length(String num) {
		int length = num.length();
		if(20 > length && length > 13) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	public static boolean luhnTest(String value) {
		
		//Hold Last Digit
		char checkDigit = value.charAt(value.length() - 1);
		int held = Integer.parseInt(String.valueOf(checkDigit));
		String newNum = removeLastNum(value);
		
		
		//Reverse number
		StringBuilder sb = new StringBuilder();
		sb.append(newNum);
		sb.reverse();
		
		
		//Convert to int List
		List<Integer> digList = Arrays.stream(sb.toString().split("\\B")) 
		  .map(s->Integer.valueOf(s)) 
		  .collect(Collectors.toList());
		
		
		//Double every odd num
		for(int a = 0; a < digList.size() ; a ++) {
			int x =  digList.get(a);
			x = x*2;
			
			//If the number doubled is greater the 1 in length we combine the digits
			String v = String.valueOf(x);
			if(v.length() == 2) {
				char f1 = v.charAt(0);
				char f2 = v.charAt(1);
				int i1 = Integer.valueOf(String.valueOf(f1));
				int i2 = Integer.valueOf(String.valueOf(f2));

				x = i1 + i2;
			}
			
			digList.set(a, x);
			a++;
		}		
		
		
		//Adding all the list together
		int cumulative = 0;
		for(int z : digList) {
			cumulative += z;
		}	
		
		
		//Subtract last digit from 10, if it equals to the held num its valid
		String c = String.valueOf(cumulative);
		int lastDig = Integer.valueOf(String.valueOf(c.charAt(1)));
		
		if(10 - lastDig == held) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	public static String removeLastNum(String s) {
	    return s.substring(0, s.length()-1);
	}

}
