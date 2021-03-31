import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BJ4485 {

    static class Node implements Comparable<Node> {
        int r, c, distance;

        public Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return distance - o.distance;
        }
    }

    static int[][] cave;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int test = 1;
        while (true) {
            int n = Integer.parseInt(reader.readLine()); //동굴의 크기
            if (n == 0)
                break;
            cave = new int[n][n];
            for (int i = 0; i < n; i++) {
                cave[i] = Arrays.stream(
                        reader.readLine().split(" "))
                        .mapToInt(j -> Integer.parseInt(j))
                        .toArray();
            }

            System.out.println("Problem " + test + ": " + dijkstra(n));
            test++;
        }
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static int dijkstra(int n) {
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, cave[0][0]));
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int r = node.r;
            int c = node.c;
            int distance = node.distance;

            if (isWithoutRange(r, n)) continue;
            if (isWithoutRange(c, n)) continue;
            if (r == n - 1 && c == n - 1) return distance;

            if (visited[r][c]) continue;
            visited[r][c] = true;
            for (int i = 0; i < 4; i++) {
                int dr = r + dx[i], dc = c + dy[i];
                if (isWithoutRange(dr, n) || isWithoutRange(dc, n)) continue;
                int weight = cave[r + dx[i]][c + dy[i]];
                queue.add(new Node(dr, dc, distance + weight));
            }
        }
        return -1;
    }

    private static boolean isWithoutRange(int r, int n) {
        return r < 0 || r >= n;
    }
}
