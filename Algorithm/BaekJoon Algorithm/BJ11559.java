import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11559 {
	static final int R = 12, C = 6;
	static char[][] map;

	static int countDFS(int r, int c, char color, boolean[][] visited) {
		if (r < 0 || r >= R)
			return 0;
		if (c < 0 || c >= C)
			return 0;
		if (map[r][c] != color)
			return 0;
		if (visited[r][c])
			return 0;
		visited[r][c] = true;
		int sum = 0;
		sum += countDFS(r - 1, c, color, visited);
		sum += countDFS(r + 1, c, color, visited);
		sum += countDFS(r, c - 1, color, visited);
		sum += countDFS(r, c + 1, color, visited);
		return sum + 1;
	}

	static void removeDFS(int r, int c, char color) {
		if (r < 0 || r >= R)
			return;
		if (c < 0 || c >= C)
			return;
		if (map[r][c] != color)
			return;
		map[r][c] = '.';
		removeDFS(r - 1, c, color);
		removeDFS(r + 1, c, color);
		removeDFS(r, c - 1, color);
		removeDFS(r, c + 1, color);
	}

	static boolean bang() {
		boolean result = false;
		for (int r = 0; r < R; ++r)
			for (int c = 0; c < C; ++c)
				if (map[r][c] != '.')
					if (countDFS(r, c, map[r][c], new boolean[R][C]) >= 4) {
						removeDFS(r, c, map[r][c]);
						result = true;
					}
		return result;
	}

	static void compact() {
		for (int c = 0; c < C; ++c) {
			int r1 = R - 1, r2 = R - 1;
			while (r1 >= 0) {
				while (r2 >= 0 && map[r2][c] == '.')
					--r2;
				map[r1--][c] = (r2 >= 0) ? map[r2--][c] : '.';
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		map = new char[R][];
		for (int r = 0; r < R; ++r)
			map[r] = reader.readLine().toCharArray();
		int count = 0;
		while (bang()) {
			++count;
			compact();

		}
		System.out.println(count);
	}
}