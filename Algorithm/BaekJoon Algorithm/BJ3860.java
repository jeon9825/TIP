package algorithm.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ3860 { // 할로윈 묘지

    static int W, H; // W - 묘지의 너비, H- 높이
    static int G; // 묘비의 개수
    static int E; // 귀신 구멍의 수
    static int[][] map; // 0- 잔디 1- 묘비 2- 귀신구멍
    static long[][] dist;
    static List<Edge> edges;
    static boolean infFlag; // INF인지~
    static final int INF = Integer.MAX_VALUE; // 변경해야 할 수도~

    static class Edge {
        Point start;
        Point target;
        int cost;

        public Edge(Point start, Point target, int cost) {
            this.start = start;
            this.target = target;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "start=" + start +
                    ", target=" + target +
                    ", cost=" + cost +
                    '}';
        }
    }

    static class Point {
        int x, y;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{" + y +
                    ", " + x + '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        while (true) {
            tokenizer = new StringTokenizer(reader.readLine());
            W = Integer.parseInt(tokenizer.nextToken());
            H = Integer.parseInt(tokenizer.nextToken());

            if (W == 0 && H == 0) {
                break;
            }

            map = new int[H][W];

            G = Integer.parseInt(reader.readLine());
            int x, y;
            for (int i = 0; i < G; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                x = Integer.parseInt(tokenizer.nextToken());
                y = Integer.parseInt(tokenizer.nextToken());

                map[y][x] = 1;
            }

            E = Integer.parseInt(reader.readLine());
            edges = new ArrayList<>();
            int x1, y1, x2, y2, t;
            for (int i = 0; i < E; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                x1 = Integer.parseInt(tokenizer.nextToken());
                y1 = Integer.parseInt(tokenizer.nextToken());
                x2 = Integer.parseInt(tokenizer.nextToken());
                y2 = Integer.parseInt(tokenizer.nextToken());
                t = Integer.parseInt(tokenizer.nextToken());

                map[y1][x1] = 2;
                edges.add(new Edge(new Point(y1, x1), new Point(y2, x2), t));
            }

            // 일단 가보자고
            makeDist();

            // 근데 귀신구멍으로 가면 더 빠를수도 느릴수도 ..! 블랙홀일수도..!!=> infFlag = true
            BellmanFord();

            if (infFlag) {
                System.out.println("Never");
            } else {
                if (dist[H - 1][W - 1] == INF) {
                    System.out.println("Impossible");
                } else {
                    System.out.println(dist[H - 1][W - 1]);
                }
            }
        }

    }

    private static void BellmanFord() {
        // dist INF 초기화
        dist = new long[H][W];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], INF);
        }
        // 출발점은 0으로
        dist[0][0] = 0;
        infFlag = false;

        // 1. N-1번동안 간선 M을 모두 확인하기
        for (int i = 0; i < W * H; i++) { // 정점 - 1번 반복문
            for (Edge edge : edges) {
                Point start = edge.start;
                Point target = edge.target;

                // 1-1. 출발지가 무한대면 더할 수 없음 -> continue
                if (dist[start.y][start.x] == INF)
                    continue;

                // 1-2. 최솟값으로 값 갱신
                if (dist[target.y][target.x] > dist[start.y][start.x] + edge.cost) {
                    dist[target.y][target.x] = dist[start.y][start.x] + edge.cost;
                }
            }
        }

        // 2. 마지막으로 간선 M을 모두 확인해서 갱신이 발생하면 무한루프
        for (Edge edge : edges) {
            Point start = edge.start;
            Point target = edge.target;

            // 2-1. 출발지가 무한대이면 -> continue
            if (dist[start.y][start.x] == INF)
                continue;
            // 갱신이 발생한다면 무한루프에 빠질 수 있음.
            if (dist[target.y][target.x] > dist[start.y][start.x] + edge.cost) { // 음수 사이클 존재
                infFlag = true;
                break;
            }
        }
    }

    static int[] mx = {0, 0, 1, -1};
    static int[] my = {1, -1, 0, 0};

    private static void makeDist() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != 0)
                    continue;

                if (i == H - 1 && j == W - 1)
                    continue;

                for (int k = 0; k < 4; k++) {
                    int ny = i + my[k];
                    int nx = j + mx[k];

                    if (ny < 0 || nx < 0 || ny >= H || nx >= W)
                        continue;

                    if (map[ny][nx] != 1) { // 무덤만 아니면 갈 수 있다.
                        edges.add(new Edge(new Point(i, j), new Point(ny, nx), 1));
                    }
                }
            }
        }
    }
}
