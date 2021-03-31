import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1916 {
    static class Edge {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return distance - o.distance;
        }
    }

    static int n;
    static List<Edge>[] edges;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine()); // 도시 개수
        int m = Integer.parseInt(reader.readLine()); // 버스 개수

        edges = new ArrayList[n];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            int w = Integer.parseInt(tokenizer.nextToken());
            edges[a].add(new Edge(b, w));
        }

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int start = Integer.parseInt(tokenizer.nextToken()) - 1;
        int end = Integer.parseInt(tokenizer.nextToken()) - 1;
        System.out.println(dijkstra(start, end));
    }

    private static int dijkstra(int start, int end) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.vertex == end) return node.distance;
            if (visited[node.vertex]) continue;
            visited[node.vertex] = true;
            for (Edge edge : edges[node.vertex]) {
                if (!visited[edge.vertex])
                    queue.add(new Node(edge.vertex, node.distance + edge.weight));
            }
        }
        return -1;
    }
}
