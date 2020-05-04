import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10026 {
	static boolean visited[][];
	static char arr[][];
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int size;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		size = n;
		arr = new char[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < arr.length; i++) {
			String s = reader.readLine();
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		int result1 = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (!visited[i][j]) {
					result1++;
					char tmp = arr[i][j];
					DFS(i, j, tmp);
				}
			}
		}
		int result2 = 0;
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				visited[i][j] = false;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 'G') {
					arr[i][j] = 'R';
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (!visited[i][j]) {
					result2++;
					char tmp = arr[i][j];
					DFS(i, j, tmp);
				}
			}
		}
		System.out.println(result1 + " " + result2);
	}

	static void DFS(int x, int y, char c) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int rx = x + dx[i];
			int ry = y + dy[i];
			if (rx < 0 || ry < 0 || ry >= size || rx >= size) {
				continue;
			}
			if (visited[rx][ry] == true) {
				continue;
			}
			if (arr[rx][ry] != c) {
				continue;
			}
			if (arr[rx][ry] == c && visited[rx][ry] == false) {
				visited[rx][ry] = true;
				DFS(rx, ry, c);
			}

		}
	}
}
