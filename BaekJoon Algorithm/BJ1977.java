import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1977 {
	static double sumOfPerfectSquare(int m, int n) {
		double sum = 0.0;
		int num = 1;

		while (Math.pow(num, 2) <= n) {
			if (Math.pow(num, 2) >= m) {
				sum += Math.pow(num, 2);
			}
			num++;
		}
		return sum;
	}

	static double minOfPerfectSquare(int m, int n) {
		int num = 1;
		while (Math.pow(num, 2) <= n) {
			if (Math.pow(num, 2) >= m) {
				return Math.pow(num, 2);
			}
			num++;
		}
		return -1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(reader.readLine()); // 연산의 개수
		int N = Integer.parseInt(reader.readLine()); // 연산의 개수
		
		if ((int) minOfPerfectSquare(M, N) == -1) {
			System.out.println(-1);
		} else {
			System.out.println((int) sumOfPerfectSquare(M, N));
			System.out.println((int) minOfPerfectSquare(M, N));
		}
	}
}
