import java.util.Scanner;

public class BJ2839 {
	static int sum(int n) {
		int x = 0;
		int y = n / 5;
		while (y >= 0) {
			if ((n - 5 * y) % 3 == 0) {
				x = (n - 5 * y) / 3;
				return x + y;
			}
			y--;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		System.out.println(sum(n));

	}
}
