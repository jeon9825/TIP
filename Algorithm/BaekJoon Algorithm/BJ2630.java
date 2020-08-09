import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2630 {
	static int[][] paper;
	static boolean[][] visited;
	static int white = 0;
	static int blue = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		paper = new int[n][n];
		visited = new boolean[n][n];
		
		StringTokenizer tokenizer;
		for (int i = 0; i < paper.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int j = 0; j < paper[i].length; j++) {
				paper[i][j] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		for (int i = n; i > 0; i /= 2) {
			for (int j = 0; j < n; j += i) {
				for (int j2 = 0; j2 < n; j2 += i) {
					count(j, j2, i);
				}
			}
		}
		System.out.println(white);
		System.out.println(blue);
	}

	static void count(int j, int j2, int i) {
		int color = paper[j][j2];
		for (int k = j; k < j + i; k++) {
			for (int k2 = j2; k2 < j2 + i; k2++) {
				if (color != paper[k][k2]) {
					return;
				}
				if (visited[k][k2])
					return;
			}
		}

		for (int k = j; k < j + i; k++) {
			for (int k2 = j2; k2 < j2 + i; k2++) {
				visited[k][k2] = true;
			}
		}

		if (color == 1) {
			blue++;
		} else if (color == 0) {
			white++;
		}
	}
}
