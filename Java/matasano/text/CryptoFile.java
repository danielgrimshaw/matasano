package matasano.text;

import java.io.*;
import java.util.*;
import java.math.*;
import matasano.text.*;

public class CryptoFile {
   private final File data;
   private final Scanner dataReader;
   
   public CryptoFile(String filename) throws FileNotFoundException {
      this(new File(filename));
   }
   
   public CryptoFile(File file) throws FileNotFoundException {
      this.data = file;
      try {
         this.dataReader = new Scanner(file);
      } catch (FileNotFoundException fnfe) {
         System.err.print(fnfe);
         throw fnfe;
      }
   }
   
   public CryptoString [] read() {
      List<CryptoString> info = new ArrayList<>();
      while (dataReader.hasNextLine())
         info.add(new CryptoString(dataReader.nextLine()));
      
      CryptoString [] result = new CryptoString[info.size()];
      info.toArray(result);
      return result;
   }
}
