package matasano.text;

import java.util.*;
import java.math.*;

//All of the matasano.* was programmed by me
import matasano.text.*;
import matasano.files.*;

public class HexString {
   private String hexText;
   
   public HexString() {
      this("49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d");
   }
	
   public HexString(String hexText) {
      this.hexText = hexText;
   }
	
   public String asString() { //returns ascii
      String ret = new String();
      for (int i = 0; i < this.hexText.length(); i += 2)
         ret += (char)(Integer.parseInt(this.hexText.substring(i, i+2), 16));
      return ret;
   }
   
   public String toString() {
      return this.hexText;
   }
}
