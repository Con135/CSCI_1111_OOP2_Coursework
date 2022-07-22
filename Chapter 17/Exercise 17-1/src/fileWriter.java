import java.io.*;

public class fileWriter {
	public static void main(String[] args) {
		int a = 0;
		String s; 
		try (
			PrintWriter output = new PrintWriter("Exercise17_01.txt");	
		) {
		for (int i = 1; i <= 100; i++) {
			a = (int)(Math.random() * 10);
			s = a + "";
			output.write(a + " ");
			System.out.print(a + " ");
		}
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
		try (
			FileInputStream input = new FileInputStream("Exercise17_01.txt");
		) {
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
