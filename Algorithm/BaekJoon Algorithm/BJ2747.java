import java.util.Scanner;

public class BJ2747 {
	static int[] f = new int[46];

	public static int Fibonacci(int n) {
		if (f[n] != 0)
			return f[n];
		if (n == 0)
			return f[0] = 0;
		else if (n == 1)
			return f[1] = 1;
		else
			return f[n] = Fibonacci(n - 1) + Fibonacci(n - 2);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(Fibonacci(n));
	}
}