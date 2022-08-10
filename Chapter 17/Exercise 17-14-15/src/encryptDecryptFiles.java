import java.io.*;
import java.util.Scanner;

public class encryptDecryptFiles {
	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an input file: ");
		File inFile = new File(input.nextLine());
		System.out.print("Enter a output file: ");
		File outFile = new File(input.nextLine());
		int choice = 0;
		System.out.print("Would you like to encrypt(1) or decrypt(2)?: ");
		choice = input.nextInt();
		try(
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(inFile));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outFile));
		){
			if(choice == 1) {
				encrypt(in, out);
			}
			else if(choice == 2) {
				decrypt(in, out);
			}
			else {
				System.out.println("Please enter 1 or 2.");
			}
		}
	}
	
	public static void encrypt(BufferedInputStream in, BufferedOutputStream out) {
		try {
			int b = 0;
			while((b = in.read()) != -1) {
				out.write(b + 5);
			}
		}
		catch(IOException ex) {
			System.out.print("File could not be found.");
		}
	}
	
	public static void decrypt(BufferedInputStream in, BufferedOutputStream out) {
		try {
			int b = 0;
			while((b = in.read()) != -1) {
				out.write(b - 5);
			}
		}
		catch(IOException ex) {
			System.out.print("File could not be found.");
		}
	}	
}