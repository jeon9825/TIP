import java.util.Scanner;

public class BJ2292 {
	public static int count(int n) {
		return (3 * n * n - 3 * n + 2);
	}

	public static int countRoom(int num) {
		int n = 0;
		if (num == 1) {
			return 1;
		}

		while (true) {
			n++;
			if (count(n) <= num && num < count(n + 1)) {
				n += 1;
				break;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();

		System.out.println(countRoom(num));
	}
}