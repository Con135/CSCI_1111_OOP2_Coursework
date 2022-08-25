import java.util.Scanner;

public class Assignment {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String value = input.next();
		int count = value.length();
		reverseDisplay(value, count);
	}
	
	public static void reverseDisplay(String value, int count) {

		if (count == 0) {
			return;
		}
		else {
			count -= 1;
			System.out.print(value.charAt(count));
			reverseDisplay(value, count);
		}
	}
}