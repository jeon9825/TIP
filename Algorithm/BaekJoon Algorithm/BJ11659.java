import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11659 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		int M = Integer.parseInt(tokenizer.nextToken());

		int[] pSum = new int[N];

		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < pSum.length; i++) {
			int n = Integer.parseInt(tokenizer.nextToken());
			if (i == 0)
				pSum[i] = n;
			else
				pSum[i] = pSum[i - 1] + n;
		}
		for (int i = 0; i < M; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(tokenizer.nextToken()) - 2;
			int b = Integer.parseInt(tokenizer.nextToken()) - 1;
			if (a >= 0)
				System.out.println(pSum[b] - pSum[a]);
			else
				System.out.println(pSum[b]);
		}
	}
}
