package algorithm.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1922 { // 네트워크 연결 크루스칼 알고리즘

    static class Edge implements Comparable<Edge> { // -> 크루스칼에서 cost 기준으로 정렬
        int start, target, cost;

        public Edge(int start, int target, int cost) {
            this.start = start;
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) { // cost 오름차순
            return this.cost - o.cost;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        parent = new int[n + 1];
        init();
        StringTokenizer tokenizer;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) { // a컴퓨터와 b컴퓨터를 연결하는데 비용이 c (1 ≤ c ≤ 10,000) 만큼 든다
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            pq.add(new Edge(a, b, c));
        }

        int count = 0; // 연결된 간선의 수
        int sum = 0; // cost의 합
        while (!pq.isEmpty()) {
            Edge current = pq.remove();
            if (count == n - 1)
                break;

            if (current.start == current.target)
                continue;

            if (find(current.start) != find(current.target)) {
                union(current.start, current.target);
                count++;
                sum += current.cost;
            }
        }
        System.out.println(sum);
    }

    private static void init() { //union find 용 부모배열 초기화
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        parent[pa] = pb;
    }

    private static int find(int num) {
        int pa = parent[num];
        if (num == parent[num])
            return num;

        return parent[num] = find(pa);
    }
}
