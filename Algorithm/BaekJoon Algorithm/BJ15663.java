import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15663 {

	static int[] c = new int[10001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());

		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(tokenizer.nextToken());
			c[num]++;
		}

		go(0, n, m, new String());
	}

	static void go(int index, int n, int m, String str) {
		if (index == m) {
			System.out.println(str);
			return;
		}

		for (int i = 0; i < c.length; i++) {
			if (c[i] > 0) {
				c[i]--;
				go(index + 1, n, m, str + i + " ");
				c[i]++;
			}
		}
	}
}
