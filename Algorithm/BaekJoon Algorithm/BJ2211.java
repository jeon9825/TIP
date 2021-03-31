import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2211 {
    static class Edge {
        int vertex1, vertex2, weight;

        public Edge(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        Edge edge;
        int distance;

        public Node(Edge edge, int distance) {
            this.edge = edge;
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
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            int c = Integer.parseInt(tokenizer.nextToken());
            edges[a].add(new Edge(a, b, c));
            edges[b].add(new Edge(b, a, c));
        }

        List<Edge> selectedEdges = dijkstra();
        System.out.println(selectedEdges.size());
        for (Edge edge : selectedEdges) {
            System.out.println((edge.vertex1 + 1) + " " + (edge.vertex2 + 1));
        }
    }

    private static List<Edge> dijkstra() {
        List<Edge> selectedEdges = new ArrayList<>();
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(new Edge(-1, 0, 0), 0));
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            int v = node.edge.vertex2, distance = node.distance;
            if (visited[v]) continue;
            visited[v] = true;
            if (node.edge.vertex1 != -1)
                selectedEdges.add(node.edge);
            for (Edge edge : edges[v]) {
                if (!visited[edge.vertex2])
                    queue.add(new Node(edge, distance + edge.weight));
            }
        }
        return selectedEdges;
    }
}
