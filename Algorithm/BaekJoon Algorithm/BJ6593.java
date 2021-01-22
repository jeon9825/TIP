import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ6593 {

	static class Node {
		int z, y, x, distance;

		public Node(int z, int y, int x, int distance) {
			this.z = z;
			this.y = y;
			this.x = x;
			this.distance = distance;
		}

	}

	static int Z, Y, X;
	static char[][][] map;
	static final int[] dx = { 1, -1, 0, 0, 0, 0 };
	static final int[] dy = { 0, 0, 1, -1, 0, 0 };
	static final int[] dz = { 0, 0, 0, 0, 1, -1 };

	static int BFS(Node start, Node end) {
		Queue<Node> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[Z][Y][X];
		q.add(start);
		while (!q.isEmpty()) {
			Node c = q.remove();
			int z = c.z, y = c.y, x = c.x, distance = c.distance;
			if (end.z == z && end.y == y && end.x == x)
				return distance;
			if (visited[z][y][x])
				continue;
			visited[z][y][x] = true;
			for (int i = 0; i < 6; i++) {
				int z1 = z + dz[i];
				int y1 = y + dy[i];
				int x1 = x + dx[i];
				if (z1 < 0 || z1 >= Z)
					continue;
				if (y1 < 0 || y1 >= Y)
					continue;
				if (x1 < 0 || x1 >= X)
					continue;
				if (map[z1][y1][x1] == '#')
					continue;
				if (visited[z1][y1][x1])
					continue;
				q.add(new Node(z1, y1, x1, distance + 1));
			}
		}
		return -1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		while (true) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			Z = Integer.parseInt(tokenizer.nextToken());
			Y = Integer.parseInt(tokenizer.nextToken());
			X = Integer.parseInt(tokenizer.nextToken());
			if (Z == 0)
				break;
			map = new char[Z][Y][];
			Node start = null, end = null;
			for (int z = 0; z < Z; z++) {
				for (int y = 0; y < Y; y++) {
					map[z][y] = reader.readLine().toCharArray();
					for (int x = 0; x < X; x++) {
						if (map[z][y][x] == 'S')
							start = new Node(z, y, x, 0);
						else if (map[z][y][x] == 'E')
							end = new Node(z, y, x, 0);
					}
				}
				reader.readLine();
			}
			int distance = BFS(start, end);
			if (distance == -1)
				builder.append("Trapped!\n");
			else
				builder.append("Escaped in ").append(distance).append(" minute(s).\n");
		}
		System.out.println(builder.toString());
	}
}
