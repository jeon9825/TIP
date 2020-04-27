import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BJ2751 {
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static int partition(int[] a, int start, int end) {
		int middle = a[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (middle > a[j])
				swap(a, ++i, j);
		}
		swap(a, end, ++i);
		return i;
	}

	static void quickSort(int[] a, int start, int end) {
		if (start >= end)
			return;

		int middle = partition(a, start, end);
		quickSort(a, start, middle - 1);
		quickSort(a, middle + 1, end);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
//		int[] num = new int[N];
//		for (int i = 0; i < num.length; i++) {
//			num[i] = Integer.parseInt(reader.readLine());
//		}
////		Arrays.sort(num);
////		quickSort(num, 0, num.length - 1);
//
//		for (int i = 0; i < num.length; i++) {
//			System.out.println(num[i]);
//		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(reader.readLine()));
		}
		Collections.sort(list);
		for (Integer i : list) {
			System.out.println(i);
		}
	}
}
