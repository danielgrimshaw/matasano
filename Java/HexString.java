import java.math.*;

package matasano.text;

public class HexString extends String {
   private String hexText;
   private final static char [] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','+','/'};
	
   public static void main(String [] args) {
      Set1 test = new Set1("1c0111001f010100061a024b53535009181c");
      Set1 key = new Set1("686974207468652062756c6c277320657965");
      //System.out.println(test.fromHexToString());
      System.out.println(toHex(test.fixedXOR(key.asString())));
   }
	
   public Set1() {
      this("49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d");
   }
	
   public Set1(String hexText) {
      this.hexText = hexText;
   }
	
   public String asString() {
      String ret = new String();
      for (int i = 0; i < this.hexText.length(); i += 2)
         ret += (char)(Integer.parseInt(this.hexText.substring(i, i+2), 16));
      return ret;
   }
	
   public String toBase64() {
      String ascii = this.fromHexToString();
      String ret = new String();
      byte [] strBytes = ascii.getBytes();
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
      return ret;
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

   public String fixedXOR(String keyString) {
      char [] string = this.fromHexToString().toCharArray();
      char [] key = keyString.toCharArray();
      for(int i = 0; i < string.length; i++)
         string[i] = (char)(string[i]^key[i]);
      return new String(string);
   }
}
