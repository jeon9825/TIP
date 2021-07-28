package algorithm.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ5719 { // 거의 최단 경로 다익스트라

    // 1. 최단 경로들을 기록한다.
    // 2. 최단 경로들을 지운다.
    // 3. 다익스트라로 가능한 경로 중 가장 빠른 길을 찾는다.

    static int N, M;
    static int start, end;
    static List<Edge> list[];
    static int[] dist;

    // 거의 최단 경로 전용 변수
    static List<Integer> parent[];
    static boolean[][] isShortest;

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        while (true) {
            tokenizer = new StringTokenizer(reader.readLine());

            N = Integer.parseInt(tokenizer.nextToken()); // 정점 수
            M = Integer.parseInt(tokenizer.nextToken()); // 간선 수
            if (N == 0 && M == 0)
                return;

            tokenizer = new StringTokenizer(reader.readLine());
            start = Integer.parseInt(tokenizer.nextToken());
            end = Integer.parseInt(tokenizer.nextToken());

            list = new ArrayList[N];
            parent = new ArrayList[N];
            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<>();
                parent[i] = new ArrayList<>();
            }
            isShortest = new boolean[N][N];

            for (int i = 0; i < M; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int u = Integer.parseInt(tokenizer.nextToken());
                int v = Integer.parseInt(tokenizer.nextToken());
                int p = Integer.parseInt(tokenizer.nextToken());

                // 단방향 간선
                list[u].add(new Edge(v, p));
            }

            // 1. 출발지부터 다익스트라 진행하면서 최단 경로들 저장
            dijkstra();

            // 2. 백트랙킹하면서 최단 경로들 삭제 ->isShortest에 저장
            backTracking(start, end);

            // 3. 다익스트라 진행하면서 거의 최단 거리 확인
            dijkstra();

            if (dist[end] == INF)
                System.out.println(-1);
            else
                System.out.println(dist[end]);
        }
    }

    private static void backTracking(int start, int now) {
        if (start == now)
            return;
        for (Integer next : parent[now]) {
            if (!isShortest[next][now]) {
                isShortest[next][now] = true;
                backTracking(start, next);
            }
        }
    }

    private static void dijkstra() {
        // 다익스트라를 2번 돌리므로 함수 내에서 dist를 inf로 초기화
        dist = new int[N];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = INF;
        }

        // 1. 출발지 비용은 0으로 하고 출발지를 PQ에 넣음
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        dist[start] = 0;
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge now = queue.poll();
            int id = now.id;
            int cost = now.cost;

            // 예를 들어 특정 목적지에 도착하는 문제였다면 도착 후 break;

            // 2. 더 큰 가중치로 도착할 경우 pass
            if (cost > dist[id])
                continue;

            // 3. 현재 위치에 연결된 간선 탐색
            for (Edge edge : list[id]) {
                int next = edge.id;

                // 2번째 다익스트라에서 사용 -> 최단 경로면 continue
                if (isShortest[id][next])
                    continue;


                if (dist[next] > cost + edge.cost) { // cost가 더 작을 때만 갱신신
                   parent[next].clear();
                    parent[next].add(id);

                    dist[next] = cost + edge.cost;
                    queue.add(new Edge(next, dist[next]));
                } else if (dist[next] == cost + edge.cost) { // 최단 경로 모두를 넣어줘야 하므로, 다른 최단 경로일 경우 백트랙킹 대상에 추가
                    parent[next].add(id);
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int id;
        int cost;

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
