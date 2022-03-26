/*
 * Class: CMSC203 
 * Instructor: Monshi
 * Description: The program will use two encryption methods to enrypt a message.
 * There is also a decryption method that will revert ecnryption back to plain text
 * Due: 3/25/2022
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Azariyas Tafesse
*/



public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	
	
	
	
	/*
	 * bool outCome = false
	 * 
	 * for loop {
	 * if chech if any char is in bound return true
	 * iff check a char out of bound return false and terminate loop
	 */
	public static boolean stringInBounds (String plainText) {
		
		boolean outCome = false;
		for(int i=0; i < plainText.length();i++) 
		{
			// checks if in bounds
			if(plainText.charAt(i) <= UPPER_BOUND || plainText.charAt(i) >= LOWER_BOUND) 
			{
				outCome = true;
			}
			// checks if the are out of bounds
			if (plainText.charAt(i) > UPPER_BOUND || plainText.charAt(i) < LOWER_BOUND)
			{
				outCome= false;
				// stops the loop from iterating
				i =  plainText.length()-1;
			}
		}
		return outCome;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	/*
	 * when key is out of range keep subtracting RANGE
	 * 
	 * for loop{
	 * get each char and add key
	 * while the new char is out of range subtract RANGE
	 * concantat to a string var
	 */
	public static String encryptCaesar(String plainText, int key) {
		// wrapps the key to be inbounds
		while(key > UPPER_BOUND)
		{
			key-=RANGE;
		}
		
		char message;
		String encryptedMessage = "";
		for(int i=0; i < plainText.length();i++) 
		{
			message = plainText.charAt(i);
			message+= key;
			// wrapps the char in bounds 
			while(message > UPPER_BOUND)
			{
				message-=RANGE;
				
			}
			encryptedMessage += message;
			
		}
		return encryptedMessage;
		
		
		
		
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	
	 /*
	  * make the bellasoStr greater or equall to text
	  * for loop{
	  * add each char at same index to each other
	  *  checks if new char is in bounds otherwise subtract RANGE
	  *  concant to a String
	  * 
	  */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		// extends the bellasoStr to be = or < the plain text
		while(bellasoStr.length() < plainText.length())
		{
			bellasoStr += bellasoStr;
			
		}
		
		
		String encryptedMessage = "";
		char message;
		
		for(int i=0; i<plainText.length();i++)
		{
			message = (char) (plainText.charAt(i) + bellasoStr.charAt(i));
			// wrapps char inbounds
			while (message > UPPER_BOUND)
			{
				message -= RANGE;
			}
			
			encryptedMessage += message;
		}	
		
		
		
		return encryptedMessage;
		
		
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	
	/*
	 * when key is out of range keep subtracting RANGE
	 * 
	 * for loop{
	 * get each char and subtract key
	 * while the new char is out of range add RANGE
	 * concantat to a string var
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		// wrapps key in biounds
		while(key > UPPER_BOUND)
		{
			key-=RANGE;
		}
		
		char message;
		String decryptedMessage = "";
		for(int i=0; i < encryptedText.length();i++) 
		{
			message = encryptedText.charAt(i);
			message-= key;
			// wrapps char in bounds
			while(message < LOWER_BOUND)
			{
				message+=RANGE;
				
			}
			decryptedMessage += message;
			
		}
		return decryptedMessage;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	
	
	 /*
	  * make the bellasoStr greater or equall to text
	  * for loop{
	  * sub each char at same index to each other
	  * check wheter in bounds otherwise add RANGE
	  * Concant with str 
	  * 
	  */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		
		// extends bellaso to be = or < than encrypted string
		while (bellasoStr.length() < encryptedText.length() )
		{
			bellasoStr+=bellasoStr;
		}
		String decryptedMessage = "";
		char message=' ';
		
		// maps each char and subtracts the ASCLL value
		// if the new char is lower than the lower bound adds RANGE
		// adds the checked char to message
		for(int i=0; i <encryptedText.length();i++ )
		{
			message = (char) (encryptedText.charAt(i) - bellasoStr.charAt(i));
			
			while(message < LOWER_BOUND)
			{
				message +=RANGE;
			}
			decryptedMessage+=message;
		}
		
		
	
		return decryptedMessage;
	}
}