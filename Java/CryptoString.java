import java.math.*;

package matasano.text;

public class CryptoString extends String {
   public HexString toHex() {
      return new HexString(String.format("%x", new BigInteger(1, arg.getBytes())));
   }
}