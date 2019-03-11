import java.util.Scanner;

public class BJ1110 {

	static int cycle(int n) {
		int count = 1;
		int decimal = n / 10; // 십의 자리 숫자
		int units = n % 10; // 일의 자리 숫자
		int duSum = (decimal + units) % 10;

		while (true) {
			int num = units * 10 + duSum;
			if (num == n)
				return count;
			decimal = num / 10;
			units = num % 10;
			duSum = (decimal + units) % 10;
			count++;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		System.out.println(cycle(n));
	}
}
