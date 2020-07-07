import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11004 {
	static int n;
	static int k;

	static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static int partition(int[] array, int left, int right) {
		int mid = (left + right) / 2;
		swap(array, left, mid); // 중앙 값을 첫 번째 요소로 이동

		int pivot = array[left];
		int i = left, j = right;

		while (i < j) {
			while (pivot < array[j]) { // j는 오른쪽에서 왼쪽으로 피봇보다 작거나 같은 값을 찾는다.
				j--;
			}

			while (i < j && pivot >= array[i]) { // i는 왼쪽에서 오른쪽으로 피봇보다 큰 값을 찾는다.
				i++;
			}
			swap(array, i, j); // 찾은 i와 j를 교환
		}
		// 반복문을 벗어난 경우는 i와 j가 만난경우
		// 피봇과 교환
		array[left] = array[i];
		array[i] = pivot;
		return i;
	}

	static void select(int[] a, int start, int end) {
		if (start >= end)
			return; // 종료조건

		int middle = partition(a, start, end); // �迭 ������

		if (k == middle + 1)
			return; // 종료조건

		// 재귀호출 반복
		if (k < middle + 1)
			select(a, start, middle - 1); // �� �κп��� ã�´�.
		else
			select(a, middle + 1, end); // �� �κп��� ã�´�.
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(tokenizer.nextToken());
		k = Integer.parseInt(tokenizer.nextToken());
		int[] a = new int[n];
		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(tokenizer.nextToken());
		}
		select(a, 0, a.length - 1);

		System.out.println(a[k - 1]);
	}
}
