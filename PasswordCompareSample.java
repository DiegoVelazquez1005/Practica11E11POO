import java.io.*;
import java.util.Arrays;

public class PasswordCompareSample {
	public static void main (String[] args) throws NumberFormatException , IOException {
		Console console = System.console();
		if(console == null){
			throw new RuntimeException("Console not available");
		}else{
			char[] password=console.readPassword("\nEnter your password:");
			console.format("\nEnter your password again: ");
			console.flush() ;
			char[] verify = console.readPassword();
			boolean match = Arrays.equals(password , verify) ;
			//Immediately clear passwords from memory
			for(int i=0; i<password.length; i++){
				password [i] = 'X';
			}
			for(int i=0; i<verify.length; i++){
				verify [i] = 'Y';
			}
			//System.out.println(password);
			//System.out.println(verify);
			console.format("\nYour password was " + (match ? "correct\n": "incorrect\n"));

		}
	}
}