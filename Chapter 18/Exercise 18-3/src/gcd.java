import java.util.Scanner;

public class gcd {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int m = input.nextInt();
		System.out.print("Enter another integer: ");
		int n = input.nextInt();
		
		System.out.println("The GCD of " + m + " and " + n + " is " + factor(m, n));
	}
	
	public static int factor(int m, int n) {
		
		if (m%n == 0) {
			return n;
		}
		else {
			return factor(n, m%n);
		}
	}
}