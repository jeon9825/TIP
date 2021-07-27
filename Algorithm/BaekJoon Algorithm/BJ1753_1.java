package algorithm.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1753 { // 최단 경로 다익스트라

    static int v, e;
    static int k; // 시작 정점
    static List<Edge> list[];
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        v = Integer.parseInt(tokenizer.nextToken());
        e = Integer.parseInt(tokenizer.nextToken());

        k = Integer.parseInt(reader.readLine());

        list = new ArrayList[v + 1];
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        dist = new int[v + 1];
        for (int i = 1; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());

            list[u].add(new Edge(v, w));
        }
        dijkstra(k);
        for (int i = 1; i < dist.length; i++) {
            System.out.println(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF");
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        dist[start] = 0;
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge current = queue.remove();
            if (current.weight > dist[current.id])
                continue;

            for (Edge next : list[current.id]) {
                if (dist[next.id] > current.weight + next.weight) {
                    dist[next.id] = current.weight + next.weight;
                    queue.add(new Edge(next.id, dist[next.id]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int id;
        int weight; // 가중치

        public Edge(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
