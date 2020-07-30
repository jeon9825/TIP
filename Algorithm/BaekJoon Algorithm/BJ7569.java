import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 3차원 배열 BFS
public class BJ7569 {
	static int dx[] = { -1, 0, 1, 0, 0, 0 };
	static int dy[] = { 0, 1, 0, -1, 0, 0 };
	static int dz[] = { 0, 0, 0, 0, 1, -1 };

	static int[][][] box;

	static Queue<Tomato> q = new LinkedList<>();

	static boolean flag = true;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int m = Integer.parseInt(tokenizer.nextToken());
		int n = Integer.parseInt(tokenizer.nextToken());
		int h = Integer.parseInt(tokenizer.nextToken());

		box = new int[h][n][m];

		boolean b = false;
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[i].length; j++) {
				tokenizer = new StringTokenizer(reader.readLine());
				for (int j2 = 0; j2 < box[i][j].length; j2++) {
					box[i][j][j2] = Integer.parseInt(tokenizer.nextToken());
					if (box[i][j][j2] == 1) {
						q.add(new Tomato(j2, j, i));
					}
					if (box[i][j][j2] == 0) {
						b = true;
					}
				}
			}
		}

		int day = 0;
		if (b == false) { // 0이 없으면 모두 익은 토마토 BFS를 안해도 된다.
			System.out.println(0);
		} else {
			while (true) {
				BFS();
				if (!flag)
					break;
				day++;
			}
			if (check()) {
				System.out.println(day);
			} else {
				System.out.println(-1);
			}
		}

	}

	static void BFS() {
		int size = q.size();
		for (int i = 0; i < size; i++) {
			Tomato t = q.poll();
			for (int j = 0; j < 6; j++) {
				int dm = t.m + dx[j];
				int dn = t.n + dy[j];
				int dh = t.h + dz[j];

				if (dm < 0 || dn < 0 || dh < 0 || dh >= box.length || dn >= box[0].length || dm >= box[0][0].length) {
					continue;
				}

				if (box[dh][dn][dm] == 0) {
					box[dh][dn][dm] = 1;
					q.add(new Tomato(dm, dn, dh));
				}
			}
		}
		if (q.size() == 0) {
			flag = false;
			return;
		}
	}

	static boolean check() {
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[i].length; j++) {
				for (int j2 = 0; j2 < box[i][j].length; j2++) {
					if (box[i][j][j2] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

class Tomato {
	int m;
	int n;
	int h;

	public Tomato(int m, int n, int h) {
		this.m = m;
		this.n = n;
		this.h = h;
	}

}
