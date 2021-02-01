import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11054 {
	static final int MAX_VALUE = 1000;
	static int[] A;
	static int N;
	static int[][] DP1;
	static int[][] DP2;

	static int 왼쪽_최대길이(int index, int previous) {
		if (index < 0)
			return 0;
		if (DP1[index][previous] > -1)
			return DP1[index][previous];
		int r1 = 0, r2 = 0;
		if (A[index] < previous)
			r1 = 1 + 왼쪽_최대길이(index - 1, A[index]);
		r2 = 왼쪽_최대길이(index - 1, previous);
		return DP1[index][previous] = Math.max(r1, r2);
	}

	static int 오른쪽_최대길이(int index, int previous) {
		if (index >= N)
			return 0;
		if (DP2[index][previous] > -1)
			return DP2[index][previous];
		int r1 = 0, r2 = 0;
		if (A[index] < previous)
			r1 = 1 + 오른쪽_최대길이(index + 1, A[index]);
		r2 = 오른쪽_최대길이(index + 1, previous);
		return DP2[index][previous] = Math.max(r1, r2);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		A = new int[N];
		DP1 = new int[N][MAX_VALUE + 1];
		DP2 = new int[N][MAX_VALUE + 1];
		for (int i = 0; i < N; ++i) {
			Arrays.fill(DP1[i], -1);
			Arrays.fill(DP2[i], -1);
		}
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; ++i)
			A[i] = Integer.parseInt(tokenizer.nextToken());
		int max = 0;
		for (int i = 0; i < N; ++i)
			max = Math.max(max, 1 + 왼쪽_최대길이(i - 1, A[i]) + 오른쪽_최대길이(i + 1, A[i]));
		System.out.println(max);
	}
}