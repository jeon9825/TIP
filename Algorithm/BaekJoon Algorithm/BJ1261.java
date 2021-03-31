import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1261 {
    static class Node implements Comparable<Node> {
        int r, c, count;

        public Node(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return count - o.count;
        }
    }

    static int m;
    static int n;
    static char[][] a;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        m = Integer.parseInt(tokenizer.nextToken()); // 가로 크기
        n = Integer.parseInt(tokenizer.nextToken()); // 세로 크기
        a = new char[n][m];
        for (int i = 0; i < a.length; i++) {
            a[i] = reader.readLine().toCharArray();
        }
        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int r = node.r, c = node.c, count = node.count;
            if (r >= n || r < 0) continue;
            if (c >= m || c < 0) continue;
            if (r == n - 1 && c == m - 1) return node.count;

            if (visited[r][c]) continue;
            visited[r][c] = true;

            if (r > 0) queue.add(new Node(r - 1, c, count + (a[r - 1][c] - '0')));
            if (c > 0) queue.add(new Node(r, c - 1, count + (a[r][c - 1] - '0')));
            if (r < n - 1) queue.add(new Node(r + 1, c, count + (a[r + 1][c] - '0')));
            if (c < m - 1) queue.add(new Node(r, c + 1, count + (a[r][c + 1] - '0')));
        }
        return -1;
    }
}
