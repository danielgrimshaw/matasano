/**
 * Main.java
 *
 * All of the code to run whichever challenge I am on in the matasano crypto challenges.
 * 
 * @author Daniel Grimshaw
 * @version 0.1.4
 * 
 * Note: version = releases.set.problem
 *
 */

import java.io.*;

//All of the matasano.* package was programmed by me
import matasano.text.*;
import matasano.files.*;

public class Main {
   public static void main(String [] args) throws FileNotFoundException {
      CryptoTextFile file = new FixedXORFile("4.txt");
      int size = file.read()[0].length();
      System.out.println(size);
      for (char letter = 0; letter < Character.MAX_VALUE; letter++) {
         char [] key = new char [size];
         for (int i = 0; i < key.length; i++)
            key[i] = letter;
         String [] dec = file.decode(new String(key));
         
         for (String s : dec)
			//if (new FixedXOR(s).mightBeEnglish())
				System.out.println(s);
      }
   }
}
