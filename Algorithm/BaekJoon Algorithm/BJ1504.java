import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1504 {
    static class Edge {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static class Vertex implements Comparable<Vertex> {
        int vertex;
        int distance;

        public Vertex(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex o) {
            return distance - o.distance;
        }
    }

    static int n;
    static List<Edge>[] list;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(tokenizer.nextToken()); // 정점의 개수
        int e = Integer.parseInt(tokenizer.nextToken()); // 간선의 개수

        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            int c = Integer.parseInt(tokenizer.nextToken());
            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }
        tokenizer = new StringTokenizer(reader.readLine());
        int 경유1 = Integer.parseInt(tokenizer.nextToken()) - 1;
        int 경유2 = Integer.parseInt(tokenizer.nextToken()) - 1;

        int 거리1 = Integer.MAX_VALUE, 거리2 = Integer.MAX_VALUE;
        try {
            거리1 = dijkstra(0, 경유1) + dijkstra(경유1, 경유2) + dijkstra(경유2, n - 1);
        } catch (Exception ex) {
        }

        try {
            거리2 = dijkstra(0, 경유2) + dijkstra(경유2, 경유1) + dijkstra(경유1, n - 1);
        } catch (Exception ex) {
        }
        if (거리1 == Integer.MAX_VALUE && 거리2 == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(거리1, 거리2));
        }
    }

    private static int dijkstra(int p1, int p2) throws Exception {
        boolean[] visited = new boolean[n];
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(new Vertex(p1, 0));
        while (!queue.isEmpty()) {
            Vertex v = queue.remove();
            if (v.vertex == p2) return v.distance;
            if (visited[v.vertex]) continue;
            visited[v.vertex] = true;
            for (Edge edge : list[v.vertex]) {
                if (!visited[edge.vertex])
                    queue.add(new Vertex(edge.vertex, v.distance + edge.weight));
            }
        }
        throw new Exception();
    }
}
