package _00_Intro_To_String_Methods;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
    	if(s1.length()>s2.length()) {
    		return s1;
    	}
    	else {
    		return s2;
    	}
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	String replacedStr = "";
        int index = s.indexOf("underscores");
         
        if(index != -1 ) {
        	 replacedStr = s.replace(' ', '_');
        }
        else {
        	 replacedStr = s;
        }
         
        return replacedStr;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
       String s1Trim = s1.trim();
       String s2Trim = s2.trim();
       String s3Trim = s3.trim();
        
       String s1Last = s1Trim.split(" ")[1];
       String s2Last = s2Trim.split(" ")[1];
       String s3Last = s3Trim.split(" ")[1];
       
       if(s1Last.compareTo(s2Last)<0) {
    	   if(s1Last.compareTo(s3Last)<0) {
    		   return s1Trim;
    	   }
    	   else {
    		   return s3Trim;
    	   }
       }
       else {
    	   if(s2Last.compareTo(s3Last)<0) {
    		   return s2Trim;
    	   }
    	   else {
    		   return s3Trim;
    	   }
       }

    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	char[] strChars = s.toCharArray();
    	int sum = 0;
    	
    	for(int i = 0; i<strChars.length; i++) {
    		if(Character.isDigit(strChars[i])) {
    			sum += Character.getNumericValue(strChars[i]);
    			
    		}
    	}

    	return sum;

    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
        int numOccurances = 0;
        int index = s.indexOf(substring);
        while( index != -1 ) {
            numOccurances++;
            index = s.indexOf(substring, index + substring.length());
        }
        
        
        return numOccurances;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
    	String encrypted = Utilities.encrypt(s.getBytes(), (byte)key);
		return encrypted;
  
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
    	String decrypted = Utilities.decrypt(s, (byte)key);
        return decrypted;
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
    	String[] list = s.split(" ");
    	int numOfWords = 0;
    	int strLength = 0;
    	int subLength = substring.length();

    	
    	for(int i = 0; i<list.length; i++) {
    		strLength = list[i].length();
    		if(strLength >= subLength) {
    			if(list[i].substring(strLength - subLength).equals(substring)) {
        			numOfWords += 1; 
        		}
    		}
    	}
        return numOfWords;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
        int firstIndex = s.indexOf(substring);
        int index = s.indexOf(substring);
        int lastIndex = 0;
        
        while( index != -1 ) {
        	lastIndex = index;
        	index = s.indexOf(substring, index + substring.length());
        	
        }
        
        int distance = lastIndex - firstIndex - substring.length();
        
        
        return distance;
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
    	String str = s.trim();
    	str = str.replaceAll("[?., -]", "");

    	
    	char[] strChars = str.toCharArray();
    	int iteration = strChars.length;
    	System.out.println(str);
    	

    	

        return true;
   }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
