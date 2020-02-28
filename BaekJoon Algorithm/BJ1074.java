import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1074 {
	static int Z(int S, int N, int r, int c) {
//		System.out.println(S + " " + N + " " + r + " " + c);
		if (N == 1) {
			if (r == 0 && c == 0)
				return 0;
			else if (r == 0 && c == 1)
				return 1;
			else if (r == 1 && c == 0)
				return 2;
			else
				return 3;
		}
		if (r < S / 2 && c < S / 2) {
//			System.out.println(0);
			return Z(S / 2, N - 1,r,c);
		} else if (r < S / 2 && c >= S / 2) {
//			System.out.println(1);
			return (int) (Math.pow(2, 2 * (N - 1)) + Z(S / 2, N - 1, r , c - S / 2));
		} else if (r >= S / 2 && c < S / 2) {
//			System.out.println(2);
			return (int) (2 * Math.pow(2, 2 * (N - 1)) + Z(S / 2, N - 1, r - S / 2, c));
		} else {
//			System.out.println(3);
			return (int) (3 * Math.pow(2, 2 * (N - 1)) + Z(S / 2, N - 1, r - S / 2, c - S / 2));
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int r = Integer.parseInt(tokenizer.nextToken());
		int c = Integer.parseInt(tokenizer.nextToken());
		int S = (int) Math.pow(2, N);
		System.out.println(Z(S, N, r, c));
	}
}
