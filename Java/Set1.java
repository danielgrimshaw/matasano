public class Set1 {
	public static void main(String [] args) {
		String text = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
		for (int i = 0; i < text.length(); i++)
			System.out.print(from_hex_to_decimal(text.charAt(i)));
	}
	
	public static int from_hex_to_decimal(char hex) {
		if ('0' <= hex && hex <= '9')
			return hex - '0';
		if (hex >= 'A' && hex <= 'Z')
			return hex - 'A' + 10;
		return hex - 'a' + 10;
	 }
}

