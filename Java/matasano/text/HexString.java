package matasano.text;

import java.math.*;
import matasano.text.*;

public class HexString {
   private String hexText;
	
   public static void main(String [] args) {
      CryptoString test = new HexString("1c0111001f010100061a024b53535009181c").asCryptoString();
      HexString key = new HexString("686974207468652062756c6c277320657965");
      //System.out.println(test.fromHexToString());
      System.out.println(test.asBase64()+"\n"+test.fixedXOR(key.asString()).toHex());
   }
	
   public HexString() {
      this("49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d");
   }
	
   public HexString(String hexText) {
      this.hexText = hexText;
   }
	
   public String asString() {
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
