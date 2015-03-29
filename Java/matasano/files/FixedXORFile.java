package matasano.files;

import java.io.*;
import java.util.*;
import java.math.*;
import matasano.text.*;

public class FixedXORFile extends CryptoTextFile {
   public FixedXORFile(String filename) throws FileNotFoundException {
      super(filename);
   }
   
   public FixedXORFile(File file) throws FileNotFoundException {
      super(file);
   }
   
   public String [] encode() {
      throw new IllegalArgumentException("FixedXORFile needs a key to encode!");
   }
   
   public String [] decode() {
      throw new IllegalArgumentException("FixedXORFile needs a key to decode!");
   }
   
   public String [] encode(String key) {
      String [] data = this.read();
      String [] result = new String [data.length];
      for (int i = 0; i < data.length; i++) {
         FixedXOR dec = new FixedXOR(data[i]);
         result[i] = this.isXORed(data[i]) ? dec.encode(key) : "\n";
      }
      return result;
   }
   
   public String [] decode(String key) {
      return this.encode(key);
   }
   
   private boolean isXORed(String line) {
	   return true;
	   //TODO: IMPLEMENT THIS!!!!!
	}
}
