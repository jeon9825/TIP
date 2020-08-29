import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());

		int[] tree = new int[n];
		tokenizer = new StringTokenizer(reader.readLine());
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < tree.length; i++) {
			tree[i] = Integer.parseInt(tokenizer.nextToken());
			max = Math.max(max, tree[i]);
		}
		Arrays.sort(tree);
		System.out.println(binarySearch(tree, 0, max, m));
	}

	public static int binarySearch(int[] array, int s, int e, int target) {
		while (s <= e) {
			int mid = (s + e) / 2;

			if (slice(array, mid, target)) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return e;
	}

	public static boolean slice(int[] array, int h, int target) {
		long sum = 0;

		for (int v : array) {
			sum += v - h > 0 ? v - h : 0;
		}

		if (sum >= target) {
			return true;
		}
		return false;
	}
}
