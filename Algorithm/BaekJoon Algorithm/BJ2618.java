package algorithm.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2618 { // 경찰차

    // 한명은 (1,1)에서 출발, 한명은 (N, N)에서 출발
    // 해결해야하는 문제(도둑) => 좌표가 주어짐

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, W;
    static Point[] event; // 문제(사건)
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        W = Integer.parseInt(reader.readLine());
        event = new Point[W + 1];
        StringTokenizer tokenizer;
        for (int i = 1; i <= W; i++) { // 첫번째 사건, ...
            tokenizer = new StringTokenizer(reader.readLine());
            int c = Integer.parseInt(tokenizer.nextToken());
            int r = Integer.parseInt(tokenizer.nextToken());
            event[i] = new Point(r, c);
        }

        dp = new int[W + 1][W + 1];
        System.out.println(toEvent(0, 0));
        getPath(0, 0);
    }

    static int toEvent(int index1, int index2) {
        if (index1 >= W || index2 >= W) // 종료조건
            return 0;

        if (dp[index1][index2] > 0)
            return dp[index1][index2];

        int next = Math.max(index1, index2) + 1; // 다음 사건 번호

        int dist1, dist2; // 경찰차 위치부터 사건 발생 지점까지 거리
        if (index1 == 0) { // 경찰차가 처음 갈 때
            dist1 = distance(1, 1, event[next].r, event[next].c);
        } else {
            dist1 = distance(event[index1].r, event[index1].c, event[next].r, event[next].c);
        }

        if (index2 == 0) { // 경찰차가 처음 갈 때
            dist2 = distance(N, N, event[next].r, event[next].c);
        } else {
            dist2 = distance(event[index2].r, event[index2].c, event[next].r, event[next].c);
        }

        // 다음 사건 next에 대하여
        // 1. 경찰차 1이 감
        int result1 = dist1 + toEvent(next, index2);
        // 2. 경찰차 2가 감
        int result2 = dist2 + toEvent(index1, next);
        // 작은 값을 리턴
        return dp[index1][index2] = Math.min(result1, result2);
    }

    static void getPath(int index1, int index2) {
        if (index1 >= W || index2 >= W) // 종료조건
            return;

        int next = Math.max(index1, index2) + 1; // 다음 사건 번호
        int dist1, dist2; // 경찰차 위치부터 사건 발생 지점까지 거리
        if (index1 == 0) { // 경찰차가 처음 갈 때
            dist1 = distance(1, 1, event[next].r, event[next].c);
        } else {
            dist1 = distance(event[index1].r, event[index1].c, event[next].r, event[next].c);
        }

        if (index2 == 0) { // 경찰차가 처음 갈 때
            dist2 = distance(N, N, event[next].r, event[next].c);
        } else {
            dist2 = distance(event[index2].r, event[index2].c, event[next].r, event[next].c);
        }

        if (dist1 + dp[next][index2] < dist2 + dp[index1][next]) {
            System.out.println(1);
            getPath(next, index2);
        } else {
            System.out.println(2);
            getPath(index1, next);
        }
    }

    static int distance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
