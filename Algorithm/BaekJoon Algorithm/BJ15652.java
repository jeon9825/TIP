import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15652 {
	static int[] a = new int[10];
	static boolean[] c = new boolean[10];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());

		go(0, 1, n, m);
	}

	static void go(int index, int start, int n, int m) {
		if (index == m) {
			// 수열 출력
			for (int i = 0; i < m; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= n; i++) {
			a[index] = i;
			go(index + 1, i, n, m);
		}
	}
}
