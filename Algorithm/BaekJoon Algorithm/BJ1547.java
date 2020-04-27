import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1547 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int[] p = { 0, 1, 2, 3 };

		StringTokenizer tokenizer;
		for (int i = 0; i < N; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());
			int pos = p[x];
			p[x] = p[y];
			p[y] = pos;
//			System.out.println(Arrays.toString(p));
		}
		for (int i = 0; i < p.length; i++) {
			if (p[i] == 1) {
				System.out.println(i);
				break;
			}
		}
	}
}
