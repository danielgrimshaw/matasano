package matasano.text;

import java.math.*;

public class CryptoString {
   private final static char [] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','+','/'};

   private String data;
   
   public CryptoString() {
      this("NO DATA GIVEN!");
   }
   
   public CryptoString(String data) {
      this.data = data;
   }
   
   public HexString toHex() {
      return new HexString(String.format("%x", new BigInteger(1, this.data.getBytes())));
   }
   
   public CryptoString asBase64() {
      String ret = new String();
      byte [] strBytes = data.getBytes();
      boolean [] bits = getBits(strBytes);
      int [] encoded = new int [bits.length/6];
      for (int i = 0; i < bits.length; i += 6) {
         int toAdd = 0;
         for (int j = 0; j < 6; j++)
            if (bits[i+j])
               toAdd += Math.pow(2, 5-j);
         encoded[i/6] = toAdd;
      }
   	
      for (int i = 0; i < encoded.length; i++)
         ret += intToBase64(encoded[i]);
      return new CryptoString(ret);
   }
   
   private boolean [] getBits(byte [] from) {
      boolean [] bits = new boolean [from.length*8];
      for (int i = 0; i < from.length; i++) {
         byte item = from[i];
         for (int j = 0; j < 8; j++) {
            if (Math.pow(2, 7-j) <= item) {
               bits[8*i + j] = true;
               item -= Math.pow(2, 7-j);
            } 
            else
               bits[8*i + j] = false;
         }
      }
      return bits;
   }
   
   	
   private char intToBase64(int i) {
      return letters[i];
   }
   
   
   public CryptoString fixedXOR(String keyString) {
      char [] string = this.data.toCharArray();
      char [] key = keyString.toCharArray();
      for(int i = 0; i < string.length; i++)
         string[i] = (char)(string[i]^key[i]);
      return new CryptoString(new String(string));
   }
   
   public String toString() {
      return this.data;
   }
   
   public boolean mightBeEnglish() {
      for (char letter : letters)
         if (this.toString().indexOf(letter) > 0)
            return true;
      return false;
   }
}
