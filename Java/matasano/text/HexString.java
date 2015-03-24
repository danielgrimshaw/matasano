package matasano.text;

import java.math.*;
import matasano.text.*;

public class HexString {
   private String hexText;
	
   public static void main(String [] args) {
	  //System.out.println((int)(Character.MAX_VALUE));
	  //char [] commonLetters = {'E','T','A','O','I','N','S','H','R','D','L','U','e','t','a','o','i','n','s','h','r','d','l','u'};
      CryptoString test = new HexString("1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736").asCryptoString();
      for (char letter = 0; letter < Character.MAX_VALUE; letter++) {
         char [] key = new char [test.toString().length()];
         for (int i = 0; i < key.length; i++)
            key[i] = letter;
      CryptoString ans = test.fixedXOR(new String(key));
      if (ans.mightBeEnglish())
         System.out.println("\'"+letter+"\': "+ans);
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
