import java.util.Scanner;

public class BJ2750 {

	public static void merge(int[] arr, int start, int middle, int end) {
		int index1 = start;
		int index2 = middle + 1;

		int[] temp = new int[end - start + 1];
		int i = 0;
		while (index1 <= middle && index2 <= end) {
			if (arr[index1] < arr[index2])
				temp[i++] = arr[index1++];
			else
				temp[i++] = arr[index2++];
		}

		while (index1 <= middle)
			temp[i++] = arr[index1++];

		while (index2 <= end)
			temp[i++] = arr[index2++];

		for (int j = 0; j < temp.length; j++) {
			arr[start + j] = temp[j];
		}
	}

	public static void sort(int[] arr, int start, int end) {
		if (start == end)
			return;
		int middle = (start + end) / 2;
		sort(arr, start, middle);
		sort(arr, middle + 1, end);
		merge(arr, start, middle, end);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}

		sort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
