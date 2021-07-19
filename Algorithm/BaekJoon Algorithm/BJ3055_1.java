package algorithm;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ3055 {
    static class Point {
        int y;
        int x;
        char type; // 물이냐 고슴도치냐

        public Point(int y, int x, char type) {
            this.y = y;
            this.x = x;
            this.type = type;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    ", type=" + type +
                    '}';
        }
    }

    private static int[] mx = {1, -1, 0, 0};
    private static int[] my = {0, 0, 1, -1};
    private static int r, c; // map의 크기
    private static char[][] map;
    private static int[][] dp;
    private static Queue<Point> queue;

    static boolean foundAnswer;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        r = Integer.parseInt(tokenizer.nextToken());
        c = Integer.parseInt(tokenizer.nextToken());

        map = new char[r][c];
        dp = new int[r][c];
        queue = new LinkedList<>();

        Point st = null;
        for (int i = 0; i < r; i++) {
            String line = reader.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    st = new Point(i, j, 'S');
                }
                if (map[i][j] == '*') {
                    queue.add(new Point(i, j, '*'));
                }
            }
        }

        // 시작점 설정
        // Queue 물을 먼저 넣음...
        // queue에는 물만 들어있음.
        queue.add(st); // 물먼저 넣고 고슴도치를 넣어주었음

        while (!queue.isEmpty()) {

            // 1. 큐에서 꺼내옴
            Point p = queue.poll();

            // 2. 목적지인가? if(p==D)
            if (p.type == 'D') {
                System.out.println(dp[p.y][p.x]); // dp에 기록
                foundAnswer = true;
                break;
            }

            //3. 갈 수 있는 곳을 순회 for(좌, 우, 위, 아래) => 4군데
            for (int i = 0; i < 4; i++) {
                int ty = p.y + my[i];
                int tx = p.x + mx[i];

                // 4. 갈 수 있는 가? if(맵을 벗어나지 않고
                if (0 <= ty && ty < r && 0 <= tx && tx < c) {
                    if (p.type == '*') { // 물
                        if (map[ty][tx] == '.' || map[ty][tx] == 'S') {
                            // 5. 체크인
                            map[ty][tx] = '*';

                            // 6. 큐에 넣음
                            queue.add(new Point(ty, tx, '*'));
                        }
                    } else { // 고슴도치
                        // [.]이거나 [D]이거나
                        if (map[ty][tx] == '.' || map[ty][tx] == 'D') {
                            if (dp[ty][tx] == 0) { // 방문한 적이 없다.
                                // 5. 체크인
                                dp[ty][tx] = dp[p.y][p.x] + 1;

                                // 6. 큐에 넣음
                                queue.add(new Point(ty, tx, map[ty][tx]));
                            }
                        }
                    }
                }
            }
        }

        if (foundAnswer == false) {
            System.out.println("KAKTUS");
        }
    }
}
