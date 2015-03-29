package matasano.files;

import java.io.*;
import java.util.*;
import java.math.*;
import matasano.text.*;

public abstract class CryptoTextFile {
   private final File data;
   private final Scanner dataReader;
   
   public CryptoTextFile(String filename) throws FileNotFoundException {
      this(new File(filename));
   }
   
   public CryptoTextFile(File file) throws FileNotFoundException {
      this.data = file;
      try {
         this.dataReader = new Scanner(file);
      } catch (FileNotFoundException fnfe) {
         System.err.print(fnfe);
         throw fnfe;
      }
   }
   
   public String [] read() {
      List<String> info = new ArrayList<>();
      while (dataReader.hasNextLine())
         info.add(new String(dataReader.nextLine()));
      
      String [] result = new String[info.size()];
      info.toArray(result);
      return result;
   }
   
   protected File getFile() {
      return this.data;
   }
   
   protected Scanner getFileReader() {
      return this.dataReader;
   }
   
   public abstract String [] encode();
   public abstract String [] decode();
   public abstract String [] encode(String key);
   public abstract String [] decode(String key);
}
