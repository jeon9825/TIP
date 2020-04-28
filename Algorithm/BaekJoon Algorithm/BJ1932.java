import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		int[] tri = new int[(n * (n + 1)) / 2];
		int index = 0;
		for (int i = 0; i < n; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j <= i; j++) {
				tri[index++] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		index = tri.length - n - 1;
		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				tri[index] += Math.max(tri[index + i], tri[index + i + 1]);
				index--;
			}
		}

		System.out.println(tri[0]);
	}
}
