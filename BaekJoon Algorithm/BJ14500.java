import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14500 {
	static int sum(int[][] p) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].length; j++) {
				int ans = 0;
				// 1. 1��
				if (i < p.length - 3) {
					ans = p[i][j] + p[i + 1][j] + p[i + 2][j] + p[i + 3][j];
					max = Math.max(ans, max);
				}
				// 2. ���� 4*1
				if (j < p[i].length - 3) {
					ans = p[i][j] + p[i][j + 1] + p[i][j + 2] + p[i][j + 3];
					max = Math.max(ans, max);
				}
				// 3. ���簢�� 2*2
				if (i < p.length - 1 && j < p[i].length - 1) {
					ans = p[i][j] + p[i + 1][j] + p[i][j + 1] + p[i + 1][j + 1];
					max = Math.max(ans, max);
				}
				// 4. ���� 3*2
				if (i < p.length - 2 && j < p[i].length - 1) {
					ans = p[i][j] + p[i][j + 1] + p[i + 1][j + 1] + p[i + 2][j + 1];
					max = Math.max(ans, max);
				}
				// 5. ���� �ݴ�
				if (i < p.length - 2 && j < p[i].length - 1) {
					ans = p[i][j] + p[i][j + 1] + p[i + 1][j] + p[i + 2][j];
					max = Math.max(ans, max);
				}
				// 4-1. ����
				if (i < p.length - 1 && j < p[i].length - 2) {
					ans = p[i][j] + p[i][j + 1] + p[i][j + 2] + p[i + 1][j + 2];
					max = Math.max(ans, max);
				}
				// 5-1. ���� �ݴ�
				if (i < p.length - 1 && j < p[i].length - 2) {
					ans = p[i][j] + p[i][j + 1] + p[i][j + 2] + p[i + 1][j];
					max = Math.max(ans, max);
				}
				// 6. ����
				if (i < p.length - 2 && j < p[i].length - 1) {
					ans = p[i][j] + p[i + 1][j] + p[i + 2][j] + p[i + 2][j + 1];
					max = Math.max(ans, max);
				}
				// 6-1. ��
				if (i < p.length - 1 && j < p[i].length - 2) {
					ans = p[i][j] + p[i + 1][j] + p[i + 1][j + 1] + p[i + 1][j + 2];
					max = Math.max(ans, max);
				}
				// 7. ���� �ݴ�
				if (i < p.length - 2 && j < p[i].length - 1) {
					ans = p[i][j + 1] + p[i + 1][j + 1] + p[i + 2][j + 1] + p[i + 2][j];
					max = Math.max(ans, max);
				}
				// 7-1. ���� �ݴ�
				if (i < p.length - 1 && j < p[i].length - 2) {
					ans = p[i + 1][j] + p[i + 1][j + 1] + p[i + 1][j + 2] + p[i][j + 2];
					max = Math.max(ans, max);
				}
				// 12. ���� 2*3
				if (i < p.length - 1 && j < p[i].length - 2) {
					ans = p[i + 1][j] + p[i + 1][j + 1] + p[i + 1][j + 2] + p[i][j + 1];
					max = Math.max(ans, max);
				}
				// 13. ���� 2*3
				if (i < p.length - 1 && j < p[i].length - 2) {
					ans = p[i][j] + p[i][j + 1] + p[i][j + 2] + p[i + 1][j + 1];
					max = Math.max(ans, max);
				}
				// 14. ���� 3*2
				if (i < p.length - 2 && j < p[i].length - 1) {
					ans = p[i][j] + p[i + 1][j] + p[i + 2][j] + p[i + 1][j + 1];
					max = Math.max(ans, max);
				}
				// 15. ���� 3*2
				if (i < p.length - 2 && j < p[i].length - 1) {
					ans = p[i][j + 1] + p[i + 1][j + 1] + p[i + 2][j + 1] + p[i + 1][j];
					max = Math.max(ans, max);
				}
				// 16. z�� 2*3
				if (i < p.length - 1 && j < p[i].length - 2) {
					ans = p[i][j] + p[i][j + 1] + p[i + 1][j + 1] + p[i + 1][j + 2];
					max = Math.max(ans, max);
				}
				// 17. z�� �ݴ� 2*3
				if (i < p.length - 1 && j < p[i].length - 2) {
					ans = p[i + 1][j] + p[i + 1][j + 1] + p[i][j + 1] + p[i][j + 2];
					max = Math.max(ans, max);
				}
				// 18. 5�� 3*2
				if (i < p.length - 2 && j < p[i].length - 1) {
					ans = p[i][j] + p[i + 1][j] + p[i + 1][j + 1] + p[i + 2][j + 1];
					max = Math.max(ans, max);
				}
				// 19. 5�� �ݴ� 3*2
				if (i < p.length - 2 && j < p[i].length - 1) {
					ans = p[i][j + 1] + p[i + 1][j + 1] + p[i + 1][j] + p[i + 2][j];
					max = Math.max(ans, max);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int N = Integer.parseInt(tokenizer.nextToken()); // ���� ũŰ
		int M = Integer.parseInt(tokenizer.nextToken()); // ���� ũ��
		int[][] p = new int[N][M];
		for (int i = 0; i < p.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < p[i].length; j++) {
				p[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		int max = sum(p);
		System.out.println(max);
	}
}
