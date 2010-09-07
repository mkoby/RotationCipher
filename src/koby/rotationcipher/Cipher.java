package koby.rotationcipher;


public class Cipher {

	private int _rotationAmount = 13;
	private char[] _lowercase = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
								  'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 
								  's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	
	private char[] _uppercase = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
			  					  'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 
			  					  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	
	public Cipher(int rotationAmount) {
		_rotationAmount = rotationAmount;
	}
	
	public String Encrypt(String text) {
		StringBuilder sb = new StringBuilder();
		
		for(int c = 0; c < text.length(); c++) {
			char letter = text.charAt(c);
			
			if( letter >= 'a' && letter <= _lowercase[_rotationAmount - 1] ) {
				letter += _rotationAmount;
			}
			else if( letter >= _lowercase[_rotationAmount] && letter <= 'z' ) {
				letter -= _rotationAmount;
			}
			else if( letter >= 'A' && letter <= _uppercase[_rotationAmount - 1] ) {
				letter += _rotationAmount;
			}
			else if( letter >= _uppercase[_rotationAmount] && letter <= 'Z' ) {
				letter -= _rotationAmount;
			}

			sb.append(letter);
		}
		
		return sb.toString();
	}
	
	public String Decrypt(String text) {
		StringBuilder sb = new StringBuilder();
		
		for(int c = 0; c < text.length(); c++) {
			char letter = text.charAt(c);
			
			if( letter >= 'a' && letter <= _lowercase[_rotationAmount - 1] ) {
				letter += _rotationAmount;
			}
			else if( letter >= _lowercase[_rotationAmount] && letter <= 'z' ) {
				letter -= _rotationAmount;
			}
			else if( letter >= 'A' && letter <= _uppercase[_rotationAmount - 1] ) {
				letter += _rotationAmount;
			}
			else if( letter >= _uppercase[_rotationAmount] && letter <= 'Z' ) {
				letter -= _rotationAmount;
			}
			
			sb.append(letter);
		}
		
		return sb.toString();
	}

}
