import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] A = new int[N];
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(tokenizer.nextToken());
		}
		
		
		Arrays.sort(A);
		
		
		int M = Integer.parseInt(reader.readLine());
		tokenizer = new StringTokenizer(reader.readLine());

		for (int i = 0; i < M; i++) {
			int b = Integer.parseInt(tokenizer.nextToken());
			System.out.println(Arrays.binarySearch(A, b) >= 0 ? 1 : 0);
		}

	}

}
