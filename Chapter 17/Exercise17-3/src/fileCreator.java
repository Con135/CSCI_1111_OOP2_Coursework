import java.io.*;

public class fileCreator {
	public static void main(String[] args) {
		int a = 0;
		int total = 0;
		try (
			DataOutputStream output = 
				new DataOutputStream(new FileOutputStream("Exercise17_03.dat"));	
		) {
		for (int i = 1; i <= 100; i++) {
			a = (int)(Math.random() * 100);
			output.writeInt(a);
			System.out.print(a + " ");
		}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
		try (
			DataInputStream input = 
				new DataInputStream(new FileInputStream("Exercise17_03.dat"));	
		) {
			while (true)
				total += input.readInt();
		}
		catch (EOFException ex) {
			System.out.println("\n" + total);
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}