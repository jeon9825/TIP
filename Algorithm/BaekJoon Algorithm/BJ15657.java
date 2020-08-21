import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15657 {

	static int[] result = new int[10];
	static boolean[] c = new boolean[10];
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());

		tokenizer = new StringTokenizer(reader.readLine());
		arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
		}
		Arrays.sort(arr);
		go(0, arr[0], n, m);
	}

	static void go(int index, int start, int n, int m) {
		if (index == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		if (index == n) {
			return;
		}

		for (int i = 0; i < n; i++) {
			if (start <= arr[i]) {
				result[index] = arr[i];
				go(index + 1, arr[i], n, m);
			}
		}
	}
}
