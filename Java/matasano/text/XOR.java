package matasano.text;

import java.math.*;

public class XOR extends CryptoString {
   public XOR() {
      super()
   }
   
   public XOR(String data) {
      super(data);
   }
   
   public String encrypt() {
      return "XOR is not yet implemented!";
   }
   
   public String decrypt() {
      return this.encrypt();
   }
   
   public String encrypt(String key) {
      return this.encrypt();
   }
   
   public String decrypt(String key) {
      return this.encrypt();
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
