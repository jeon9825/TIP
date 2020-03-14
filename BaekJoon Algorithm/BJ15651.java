import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15651 {
	static int[] a = new int[10];

	static StringBuilder go(int index, int n, int m) {
		if (index == m) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				sb.append(a[i] + " ");
			}
			sb.append("\n");
			return sb;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			a[index] = i;
			sb.append(go(index + 1, n, m));
		}
		return sb;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());

		System.out.println(go(0, N, M));
	}
}
