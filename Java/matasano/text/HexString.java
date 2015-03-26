package matasano.text;

import java.io.*;
import java.util.*;
import java.math.*;
import matasano.text.*;

public class HexString {
   private String hexText;
	
   public static void main(String [] args) throws FileNotFoundException {
      CryptoFile file = new CryptoFile("4.txt");
      int count = 0;
	  for (CryptoString encoded : file.read()) {
         for (char letter = 0; letter < Character.MAX_VALUE; letter++) {
            char [] key = new char [encoded.toString().length()];
            for (int i = 0; i < key.length; i++)
               key[i] = letter;
            CryptoString ans = encoded.fixedXOR(new String(key));
            if (ans.mightBeEnglish())
               System.out.println(count+": \'"+letter+"\': "+ans);
         }
         count++;
      }
   }
	
   public HexString() {
      this("49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d");
   }
	
   public HexString(String hexText) {
      this.hexText = hexText;
   }
	
   public String asString() { //returns ascii
      String ret = new String();
      for (int i = 0; i < this.hexText.length(); i += 2)
         ret += (char)(Integer.parseInt(this.hexText.substring(i, i+2), 16));
      return ret;
   }
   
   public CryptoString asCryptoString() {
      return new CryptoString(this.asString());
   }
   
   public String toString() {
      return this.hexText;
   }
}
