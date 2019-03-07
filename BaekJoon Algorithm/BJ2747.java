import java.util.Scanner;

public class BJ2747 {

	public static int Fibonacci(int n) {
		int fibo = 0;

		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else {
			fibo = Fibonacci(n - 1) + Fibonacci(n - 2);
			return fibo;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		System.out.println(Fibonacci(n));
	}
}
