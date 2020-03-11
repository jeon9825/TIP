import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ6064 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer;
		for (int i = 0; i < T; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int M = Integer.parseInt(tokenizer.nextToken());
			int N = Integer.parseInt(tokenizer.nextToken());
			int x = Integer.parseInt(tokenizer.nextToken());
			int y = Integer.parseInt(tokenizer.nextToken());

			x--;
			y--;
			int year = -1;
			for (int j = x; j <= M * N; j += M) { // ���� ���̱� j = � �� * M + x �� �̿��ؼ� �ʱⰪ�� x�� �ΰ� �ݺ��Ҷ����� M�� �����ش�.
				if (j % N == y) {
					year = j + 1;
					break;
				}
			}
			System.out.println(year);
		}

	}
}
