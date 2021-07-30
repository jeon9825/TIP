package algorithm.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2098 { // 외판원 순회
    static int n;
    static int[][] w;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        w = new int[n][n];
        for (int i = 0; i < w.length; i++) { // w[i][j]는 도시 i에서 j로 가기위한 비용
            w[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dp = new int[n][1 << n];
        // 어느 한 도시에서 출발해 "N개의 도시를 모두 거쳐"
        // 다시 원래의 도시로 돌아오는 순회 여행
        // 한번 갔던 도시는 갈 수 없음 => 비트마스킹
        // 가장 적은 비용
        System.out.println(TSP(0, 1));
    }

    // 외판원 순회 Traveling Salesman Problem
    static int TSP(int index, int visited) {// index에서 출발, visited는  도착한 적이 있는지 없는지 체크하는
        if (dp[index][visited] > 0)
            return dp[index][visited];

        if (visited == (1 << n) - 1) { // 모든 마을을 방문 했을 때
            if (w[index][0] != 0) { // 0번으로 다시 돌아갈 수 있음
                return w[index][0];
            } else { // 없으면 못가는거지
                return 10000000;
            }
        }

        int result = 0;
        int min = 10000000;  // TODO
        for (int i = 0; i < n; i++) { // 지금부터 어떤 마을을 방문해볼까?
            if ((visited & 1 << i) != 0)
                continue;
            if (w[index][i] == 0)
                continue;
            result = w[index][i] + TSP(i, (visited | 1 << i));
            if (result < min)
                min = result;
        }
        return dp[index][visited] = min;
    }
}

