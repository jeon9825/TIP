import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1654 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int m = Integer.parseInt(tokenizer.nextToken());

		int[] tree = new int[n];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < tree.length; i++) {
			tree[i] = Integer.parseInt(reader.readLine());
			max = Math.max(max, tree[i]);
		}
		Arrays.sort(tree);
		System.out.println(binarySearch(tree, 0, max, m));
	}

	public static long binarySearch(int[] array, long s, long e, int target) {
		while (s <= e) {
			long mid = (s + e) / 2;

			if (mid == 0)
				mid++;
			if (slice(array, mid, target)) {
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}
		return e;
	}

	public static boolean slice(int[] array, long h, int target) {
		long count = 0;
		for (int v : array) {
			count += v / h;
		}

		if (count >= target) {
			return true;
		}
		return false;
	}
}
