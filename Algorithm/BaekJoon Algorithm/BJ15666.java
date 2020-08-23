
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15666 {

	static boolean[] c = new boolean[10001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());

		tokenizer = new StringTokenizer(reader.readLine());
		int start = 10;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(tokenizer.nextToken());
			if (!c[num])
				c[num] = true;
			if (start > num)
				start = num;
		}

		go(0, n, m, start, "");
	}

	static void go(int index, int n, int m, int start, String str) {
		if (index == m) {
			System.out.println(str);
			return;
		}

		for (int i = 0; i < c.length; i++) {
			if (c[i] && start <= i) {
				start = i;
				go(index + 1, n, m, start, str + i + " ");
			}
		}
	}
}