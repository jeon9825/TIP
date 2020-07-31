import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ3184 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int r;
	static int c;
	static char[][] arr;
	static boolean[][] visited;

	static int sheep = 0;
	static int wolf = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		r = Integer.parseInt(tokenizer.nextToken());
		c = Integer.parseInt(tokenizer.nextToken());

		arr = new char[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.readLine().toCharArray();
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (!visited[i][j] && (arr[i][j] == 'v' || arr[i][j] == 'o')) {
					visited[i][j] = true;
					BFS(i, j, arr[i][j]);
				}
			}
		}

		System.out.println(sheep + " " + wolf);
	}

	static void BFS(int i, int j, char who) {
		int v = 0;
		int o = 0;
		if (who == 'v')
			v++;
		else if (who == 'o')
			o++;

		Queue<Field> q = new LinkedList<>();
		q.add(new Field(i, j));
		while (!q.isEmpty()) {
			Field f = q.poll();

			for (int k = 0; k < 4; k++) {
				int kr = f.i + dx[k];
				int kc = f.j + dy[k];

				if (kr < 0 || kc < 0 || kr >= r || kc >= c)
					continue;

				if (arr[kr][kc] == '#')
					continue;

				if (!visited[kr][kc]) {
					visited[kr][kc] = true;
					q.add(new Field(kr, kc));
					if (arr[kr][kc] == 'o')
						o++;
					else if (arr[kr][kc] == 'v')
						v++;
				}
			}
		}

		if (v < o) { // 양이 더 많으면
			sheep += o;
		} else {
			wolf += v;
		}
	}
}

class Field {
	int i;
	int j;

	public Field(int i, int j) {
		this.i = i;
		this.j = j;
	}
}
