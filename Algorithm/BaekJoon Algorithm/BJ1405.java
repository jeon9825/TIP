import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1405 {
	static final int MAX = 14;
	static int 최대이동횟수;
	static final int 동 = 0, 서 = 1, 남 = 2, 북 = 3;
	static double[] 확률 = new double[4];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static double 이동확률계산(int[] 방향) {
		double result = 1;
		for (int d : 방향)
			result *= 확률[d];
		return result;
	}

	static double DFS(int x, int y, double 이동확률, int index, boolean[][] visited) {
		if (visited[x][y])
			return 0;
		if (index == 최대이동횟수)
			return 이동확률;
		visited[x][y] = true;
		double 확률합계 = 0;
		for (int d = 0; d < 4; d++) {
			확률합계 += DFS(x + dx[d], y + dy[d], 이동확률 * 확률[d], index + 1, visited);
		}
		visited[x][y] = false;
		return 확률합계;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		
		최대이동횟수 = Integer.parseInt(tokenizer.nextToken());
		확률[동] = Integer.parseInt(tokenizer.nextToken()) / 100.0;
		확률[서] = Integer.parseInt(tokenizer.nextToken()) / 100.0;
		확률[남] = Integer.parseInt(tokenizer.nextToken()) / 100.0;
		확률[북] = Integer.parseInt(tokenizer.nextToken()) / 100.0;
		System.out.println(DFS(14, 14, 1, 0, new boolean[MAX * 2 + 1][MAX * 2 + 1]));
	}
}
