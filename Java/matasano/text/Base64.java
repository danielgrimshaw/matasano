package matasano.text;

import java.math.*;

public class Base64 extends CryptoString {
   public Base64() {
      super();
   }
   
   public Base64(String data) {
      super(data);
   }
   
   public String encode() {
      String ret = new String();
      byte [] strBytes = this.getData().getBytes();
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
      return new String(ret);
   }
   
   public String decode() {
      return "Base64:decode(void) NOT IMPLEMENTED YET!!!"
   }
   
   public String encode(String key) {
      return "Base64 requires no keys";
   }
   
   public String decode(String key) {
      return this.encode(key);
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
   
}
