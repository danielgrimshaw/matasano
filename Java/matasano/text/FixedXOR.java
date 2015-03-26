package matasano.text;

import java.math.*;

public class FixedXOR extends XOR {
   public XOR() {
      super()
   }
   
   public XOR(String data) {
      super(data);
   }
   
   public String encode() {
      return "FixedXOR encoding needs a key!";
   }
   
   public String decode() {
      return "FixedXOR decoding needs a key!";
   }
   
   public String encode(String keyString) {
      char [] string = this.getData().toCharArray();
      char [] key = keyString.toCharArray();
      for(int i = 0; i < string.length; i++)
         string[i] = (char)(string[i]^key[i]);
      return new String(string);
   }
   
   public String decode(String keyString) {
      return this.encode(keyString);
   }
}
