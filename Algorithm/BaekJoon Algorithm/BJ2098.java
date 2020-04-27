import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2098 {
	static int n;
	static int[][] w;
	static int[][] dp;

	static int TSP(int curr, int visited) { // visited�� ��Ʈ����ũ��
		int min = dp[curr][visited];
		if (min != 0) // �̹� ���� ���� ����
			return min;

		if (visited == (1 << n) - 1) { // ��� ������ �湮 ���� �� 0�� ������ �ٽ� ���ư���.
			if (w[curr][0] != 0) { // 0������ �ٽ� �� �� ���� ��
				return w[curr][0];
			} else {
				return 10000000; // �Ұ���
			}
		}

		min = 10000000; // ū ���� Integer.MAX_VALUE�� �ϸ� �� �ȵǴ��� �𸣰���.
		int result = 0;
		for (int i = 0; i < n; i++) {
			if ((visited & 1 << i) != 0 || w[curr][i] == 0) // i�� ������ �湮�߰ų�, ������������ i�������� ���� ����� ���� ��
				continue;

			result = TSP(i, (visited | 1 << i)) + w[curr][i]; // visited | 1 << i �� i�� ������ �湮��Ŵ
			if (result < min)
				min = result;
		}
		dp[curr][visited] = min;
		return min;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine()); // ���� ��
		w = new int[n][n];
		dp = new int[n][1 << n];
		StringTokenizer tokenizer;
		for (int i = 0; i < w.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < w[i].length; j++) {
				w[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		System.out.println(TSP(0, 1));
	}
}
