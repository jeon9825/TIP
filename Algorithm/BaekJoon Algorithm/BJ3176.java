package algorithm.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ3176 { //도로네트워크

    static class Edge {
        int id, cost;

        public Edge(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }
    }

    static int n, k, m;
    static List<Edge> tree[];
    static int[][] minDist;
    static int[][] maxDist;
    static int[][] parent;
    static int[] depth;
    static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        tree = new ArrayList[n + 1];
        k = 0;
        for (int i = 1; i <= n; i *= 2) {
            k++;
        }

        parent = new int[k][n + 1];
        depth = new int[n + 1];
        maxDist = new int[k][n + 1];
        minDist = new int[k][n + 1];

        for (int i = 1; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer tokenizer;
        for (int i = 0; i < n - 1; i++) { // A와 B사이에 길이가 C인 도로가 있다는 뜻이다.
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            tree[a].add(new Edge(b, c));
            tree[b].add(new Edge(a, c));
        }

        // depth를 구한다.
        dfs(1, 1);

        // parent를 채운다
        fillParent();

        // lca를 구하면서 min, max값 구한다.
        m = Integer.parseInt(reader.readLine());
        builder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int d = Integer.parseInt(tokenizer.nextToken());
            int e = Integer.parseInt(tokenizer.nextToken());

            lca(d, e);
//            System.out.println(Arrays.deepToString(parent));
//            System.out.println(Arrays.deepToString(maxDist));
//            System.out.println(Arrays.deepToString(minDist));
        }
        System.out.println(builder.toString());
    }

    private static void lca(int a, int b) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        for (int i = k - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                max = Math.max(max, maxDist[i][a]);
                min = Math.min(min, minDist[i][a]);
                a = parent[i][a];
            }
        }

        if (a == b) {
            builder.append(min + " " + max + "\n");
            return;
        }

        for (int i = k - 1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                max = Math.max(max, Math.max(maxDist[i][a], maxDist[i][b]));
                min = Math.min(min, Math.min(minDist[i][a], minDist[i][b]));
                a = parent[i][a];
                b = parent[i][b];
            }
        }

        max = Math.max(max, Math.max(maxDist[0][a], maxDist[0][b]));
        min = Math.min(min, Math.min(minDist[0][a], minDist[0][b]));
        builder.append(min + " " + max + "\n");
    }

    private static void fillParent() {
        for (int i = 1; i < parent.length; i++) {
            for (int j = 1; j < parent[i].length; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
                maxDist[i][j] = Math.max(maxDist[i - 1][j], maxDist[i - 1][parent[i - 1][j]]);
                minDist[i][j] = Math.min(minDist[i - 1][j], minDist[i - 1][parent[i - 1][j]]);
            }
        }
    }

    private static void dfs(int node, int d) {
        depth[node] = d;
        for (Edge next : tree[node]) {
            if (depth[next.id] == 0) {
                dfs(next.id, d + 1);
                parent[0][next.id] = node;
                maxDist[0][next.id] = next.cost;
                minDist[0][next.id] = next.cost;
            }
        }
    }
}
