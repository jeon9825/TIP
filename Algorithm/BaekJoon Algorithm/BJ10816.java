import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10816 {
	static int leftIndex(int[] arr, int from, int to, int value) {
		int index = (from + to) / 2;

		if (from >= to) {
			return index;
		}

		if (arr[index] >= value)
			return leftIndex(arr, from, index, value);
		else
			return leftIndex(arr, index + 1, to, value);
	}

	static int rightIndex(int[] arr, int from, int to, int value) {
		int index = (from + to) / 2;

		if (from >= to) {
			return index;
		}

		if (arr[index] <= value)
			return rightIndex(arr, index + 1, to, value);
		else
			return rightIndex(arr, from, index, value);
	}

	static int count(int[] arr, int value) {
		return rightIndex(arr, 0, arr.length, value) - leftIndex(arr, 0, arr.length, value);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
		}
		Arrays.sort(arr);

		int M = Integer.parseInt(reader.readLine());
		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(tokenizer.nextToken());
			System.out.print(count(arr, n) + " ");
		}
	}
}
