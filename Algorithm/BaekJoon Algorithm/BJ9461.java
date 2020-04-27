import java.util.Scanner;

public class BJ9461 {

	public static long padoban(int N) {
		long[] A = new long[Math.max(N, 5)];
		A[0] = 1;
		A[1] = 1;
		A[2] = 1;
		A[3] = 2;
		A[4] = 2;
		
		for (int i = 5; i < N; ++i)
			A[i] = A[i - 1] + A[i - 5];
		return A[N - 1];
	}

	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scan.nextInt();
			System.out.println(padoban(n));
		}
	}

}
