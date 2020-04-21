
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1912 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] A = new int[N];
		for (int i = 0; i < N; ++i)
			A[i] = Integer.parseInt(tokenizer.nextToken());
		reader.close();

		int[] sum = new int[N];
		int max = A[0];
		sum[0] = A[0];
		for (int i = 1; i < sum.length; i++) {
			if (A[i] > max)
				max = A[i];
			sum[i] = Math.max(A[i - 1] + A[i], sum[i - 1] + A[i]);
			if (sum[i] > max)
				max = sum[i];
		}
		System.out.println(max);
	}
}
