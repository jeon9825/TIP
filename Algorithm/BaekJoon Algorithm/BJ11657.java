package algorithm.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11657 { // 타임머신

    static class Edge {
        int start, target, cost;

        public Edge(int start, int target, int cost) {
            this.start = start;
            this.target = target;
            this.cost = cost;
        }
    }

    static int N, M; // N - 도시 수, M - 버스(간선) 수
    static long[] dist; // int형이 넘음
    static Edge[] edges;
    static boolean infFlag;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer;
        tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        edges = new Edge[M + 1];
        dist = new long[N + 1];

        int a, b, c;
        for (int i = 1; i <= M; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            a = Integer.parseInt(tokenizer.nextToken());
            b = Integer.parseInt(tokenizer.nextToken());
            c = Integer.parseInt(tokenizer.nextToken());

            // 간선리스트로 받기
            edges[i] = new Edge(a, b, c);
        }

        // 2. 밸만 포드
        // ** dist는 출발지 1 제외하고 모두 무한대로
        dist[1] = 0;
        for (int i = 2; i < dist.length; i++) {
            dist[i] = INF;
        }

        BellmanFord();

        // 3. 출력
        if (infFlag)
            System.out.println(-1);
        else {
            for (int i = 2; i < dist.length; i++) {
                if (dist[i] == INF)
                    dist[i] = -1;
                System.out.println(dist[i]);
            }
        }
    }

    private static void BellmanFord() {
        // 1. N-1번동안 간선 M을 모두 확인하기
        for (int i = 1; i < N; i++) { // N-1만큼
            for (int j = 1; j < edges.length; j++) {
                int start = edges[j].start;
                int target = edges[j].target;
                int cost = edges[j].cost;
                // 1-1. 출발지가 무한대면 더할 수 없음 -> continue
                if (dist[start] == INF)
                    continue;

                // 1-2. 최솟값으로 값 갱신
                dist[target] = Math.min(dist[start] + cost, dist[target]);
            }
        }

        // 2. 마지막으로 간선 M을 모두 확인해서 갱신이 발생하면 무한루프 (음수 싸이클)
        for (int i = 1; i < edges.length; i++) {
            int start = edges[i].start;
            int target = edges[i].target;
            int cost = edges[i].cost;

            if (dist[start] == INF)
                continue;

            // 갱신이 발생한다면 무한루프에 빠질 수 있음
            if (dist[target] > dist[start] + cost) { // 음수 사이클 존재
                infFlag = true;
                break;
            }
        }
    }
}
