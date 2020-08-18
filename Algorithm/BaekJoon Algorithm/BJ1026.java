import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ1026 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		Integer[] a = new Integer[n];
		int[] b = new int[n];
		int[] visited = new int[n];

		// 초기화
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(tokenizer.nextToken());
		}
		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < b.length; i++) {
			b[i] = Integer.parseInt(tokenizer.nextToken());
		}

		for (int i = 0; i < visited.length; i++) {
			visited[i] = -1;
		}

		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			int index = 0;
			for (int j = 0; j < b.length; j++) {
				if (visited[j] == -1 && b[j] < min) {
					min = b[j];
					index = j;
				}
			}
			visited[index] = i;
		}
		Arrays.sort(a, Collections.reverseOrder());

		int[] result = new int[n];
		int index = 0;
		while (index < n) {
			for (int i = 0; i < visited.length; i++) {
				if (visited[i] == index) {
					result[i] = a[index++];
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < result.length; i++) {
			sum += result[i] * b[i];
		}
		System.out.println(sum);
	}
}
