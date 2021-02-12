import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BJ2573 {

	static class Location {
		int r, c;

		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static int R, C;
	static int[][] map;
	static int[][] 상하좌우 = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static int countZero(int r, int c) {
		int count = 0;
		for (int[] is : 상하좌우) {
			if (isZero(r + is[0], c + is[1]))
				++count;
		}
		return count;
	}

	static void melt() {
		int[][] newMap = new int[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				newMap[r][c] = Math.max(0, map[r][c] - countZero(r, c));
			}
		}
		map = newMap;
	}

	static boolean isValid(int r, int c) {
		if (r < 0 || r >= R)
			return false;
		if (c < 0 || c >= C)
			return false;
		return true;
	}

	static boolean isZero(int r, int c) {
		return isValid(r, c) && map[r][c] == 0;
	}

	static void DFS(int r, int c, boolean[][] visited) {
		if (visited[r][c])
			return;
		if (isZero(r, c))
			return;
		visited[r][c] = true;
		for (int[] is : 상하좌우) {
			DFS(r + is[0], c + is[1], visited);
		}
	}

	static int countIceburg() {
		int count = 0;
		boolean[][] visited = new boolean[R][C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (!visited[r][c] && !isZero(r, c)) {
					++count;
					DFS(r, c, visited);
				}
			}
		}
		return count;
	}

	static int solution() {
		int year = 0;
		while (true) {
			int count = countIceburg();
			if (count >= 2)
				return year;
			if (count == 0)
				return 0;
			melt();
			++year;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		R = Integer.parseInt(tokenizer.nextToken());
		C = Integer.parseInt(tokenizer.nextToken());

		map = new int[R][C];
		for (int r = 0; r < R; r++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(tokenizer.nextToken());
			}
		}

		System.out.println(solution());
	}
}
