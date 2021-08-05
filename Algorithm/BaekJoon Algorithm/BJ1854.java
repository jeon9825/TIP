package algorithm.me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1854 { // K번째 최단 경로 찾기

    static int n, m, k;
    static List<Edge> list[];
    static PriorityQueue<Integer> dist[];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        list = new ArrayList[n + 1];
        dist = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            dist[i] = new PriorityQueue<>(k);
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            list[a].add(new Edge(b, c));
        }

        dijkstra(1);

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dist[i].size() == k)
                builder.append((dist[i].peek() * -1) + "\n");
            else
                builder.append("-1\n");
        }
        System.out.println(builder.toString());
    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(start, 0));
        dist[start].add(0); // 1번 정점이 출발지

        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            for (Edge edge : list[now.id]) {
                if (dist[edge.id].size() < k) {
                    dist[edge.id].add((now.cost + edge.cost) * -1);
                    queue.add(new Edge(edge.id, now.cost + edge.cost));
                } else if (dist[edge.id].peek() * -1 > (now.cost) + edge.cost) {
                    dist[edge.id].poll();
                    dist[edge.id].add((now.cost + edge.cost) * -1);
                    queue.add(new Edge(edge.id, now.cost + edge.cost));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int id, cost;

        public Edge(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
