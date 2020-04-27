import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ10974 {
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static boolean next_permutation(int[] a) {
		int i = a.length - 1;
		for (; i > 0; i--) {
			if (a[i - 1] <= a[i])
				break;
		}
		if (i <= 0)
			return false;
		int j = a.length - 1;
		while (a[i - 1] > a[j]) {
			j--;
		}
		swap(a, i - 1, j); // a[i-1]에 더 큰 수를 넣고

		// a[i] ~ a[a.length-1] 까지 내림차순 정렬

		Arrays.sort(a, i, a.length);
		int j2 = i;
		do {
			swap(a, j2, a.length - j2 + i - 1);
			j2++;
		} while (j2 < a.length - 1 / 2);

		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] a = new int[N];
		for (int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		do {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		} while (next_permutation(a));
	}
}
