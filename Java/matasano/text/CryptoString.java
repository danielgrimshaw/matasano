package matasano.text;

import java.math.*;

public abstract class CryptoString {
   protected final static char [] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','+','/'};

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
   
   protected String getData() {
      return this.data;
   }
   
   public String toString() {
      return this.data;
   }
   
   public abstract String encode();
   public abstract String decode();
   public abstract String encode(String key);
   public abstract String decode(String key);
}
