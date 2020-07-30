import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ3055 {
	static int r;
	static int c;

	static char[][] arr;
	static Queue<Map> water = new LinkedList<>();
	static Queue<Map> hed = new LinkedList<>();

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		r = Integer.parseInt(tokenizer.nextToken());
		c = Integer.parseInt(tokenizer.nextToken());

		arr = new char[r][c];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = reader.readLine().toCharArray();
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == '*') {
					water.add(new Map(i, j));
				}
				if (arr[i][j] == 'S') {
					hed.add(new Map(i, j));
				}
			}
		}
		solve();
	}

	static void extendWater() {
		int size = water.size();

		for (int j = 0; j < size; j++) {
			Map wat = water.poll();

			for (int i = 0; i < 4; i++) {
				int rr = wat.mr + dx[i];
				int rc = wat.mc + dy[i];

				if (rr < 0 || rc < 0 || rr >= r || rc >= c)
					continue;

				if (arr[rr][rc] == 'X' || arr[rr][rc] == 'D')
					continue;

				if (arr[rr][rc] == '.') {
					arr[rr][rc] = '*';
					water.add(new Map(rr, rc));
				}
			}
		}
	}

	static boolean extendHed() {
		int size = hed.size();

		for (int j = 0; j < size; j++) {
			Map h = hed.poll();

			for (int i = 0; i < 4; i++) {
				int rr = h.mr + dx[i];
				int rc = h.mc + dy[i];

				if (rr < 0 || rc < 0 || rr >= r || rc >= c)
					continue;

				if (arr[rr][rc] == 'X' || arr[rr][rc] == '*')
					continue;

				if (arr[rr][rc] == 'D') {
					hed.add(new Map(rr, rc));
					return true;
				}

				if (arr[rr][rc] == '.') {
					arr[rr][rc] = 'S';
					hed.add(new Map(rr, rc));
				}
			}
		}
		return false;
	}

	static void solve() {
		int ans = 0;
		while (true) {
			++ans;
			if (hed.size() == 0) {
				System.out.println("KAKTUS");
				return;
			}
			extendWater();
			if (extendHed()) {
				System.out.println(ans);
				return;
			}
		}
	}
}

class Map {
	int mr;
	int mc;

	public Map(int mr, int mc) {
		this.mc = mc;
		this.mr = mr;
	}
}