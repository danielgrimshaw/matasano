package matasano.text;

import java.math.*;

public class XOR extends CryptoString {
   public XOR() {
      super();
   }
   
   public XOR(String data) {
      super(data);
   }
   
   public String encode() {
      return "XOR is not yet implemented!";
   }
   
   public String decode() {
      return this.encode();
   }
   
   public String encode(String key) {
      return this.encode();
   }
   
   public String decode(String key) {
      return this.encode();
   }
   
   public boolean mightBeEnglish() {
      if (this.toString().indexOf(" ") < 0)
         return false;
      
      for (char character : this.toString().toCharArray())
         if (character < 32 || character > 126)
			return false;
      
      for (char letter : letters)
         if (this.toString().indexOf(letter) >= 0)
            return true;
      return false;
   }
}
