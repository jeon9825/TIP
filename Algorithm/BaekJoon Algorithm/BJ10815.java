import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10815 {

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
			int m = Integer.parseInt(tokenizer.nextToken());
			if (Arrays.binarySearch(arr, m) >= 0) {
				System.out.print(1 + " ");
			} else {
				System.out.print(0 + " ");
			}
		}
	}

}
