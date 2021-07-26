package algorithm.me;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ15686 { // 치킨 배달

    static int N, M;
    static int[][] map;
    static List<Pos> chicken;
    static int[] mi = {1, -1, 0, 0};
    static int[] mj = {0, 0, 1, -1};
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        map = new int[N][N];

        chicken = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Integer.parseInt(tokenizer.nextToken());

                if (map[i][j] == 2) {
                    chicken.add(new Pos(i, j));
                    map[i][j] = 0;
                }
            }
        }

        // 치킨집 chicken 중에서 M개를 선택, BFS
        combination(0, M);
        System.out.println(min);
    }

    private static void combination(int i, int m) {
        if (m == 0) {
            min = Math.min(min, BFS(map));
            return;
        }
        if (i >= chicken.size())
            return;

        Pos pos = chicken.get(i);
        map[pos.i][pos.j] = 2;
        combination(i + 1, m - 1);
        map[pos.i][pos.j] = 0;
        combination(i + 1, m);
    }

    private static int BFS(int[][] map) {
        int sum = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    Queue<Pos> queue = new LinkedList<>();
                    queue.add(new Pos(i, j));
                    boolean[][] visited = new boolean[N][N];
                    visited[i][j] = true;
                    sum += BFS0(map, visited, queue);
                    if (sum > min)
                        return sum;
                }
            }
        }
        return sum;
    }

    private static int BFS0(int[][] map, boolean[][] visited, Queue<Pos> queue) {
        while (!queue.isEmpty()) {
            Pos current = queue.poll();
            int i = current.i;
            int j = current.j;

            if (map[i][j] == 2) { // 목적지인가
                return current.count;
            }

            for (int k = 0; k < 4; k++) {
                int pi = i + mi[k];
                int pj = j + mj[k];

                if (pi < 0 || pi >= N || pj < 0 || pj >= N)
                    continue;

                if (visited[pi][pj])
                    continue;

                visited[pi][pj] = true;
                queue.add(new Pos(pi, pj, current.count + 1));
            }
        }
        return 0;
    }

    static class Pos {
        int i;
        int j;
        int count;

        public Pos(int i, int j, int count) {
            this.i = i;
            this.j = j;
            this.count = count;
        }

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
            this.count = 0;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "i=" + i +
                    ", j=" + j +
                    ", count=" + count +
                    '}';
        }
    }
}
