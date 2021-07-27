package algorithm.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11404 { // 플로이드

    static int n; // 도시 수
    static int m; // 버스 수
    static int[][] dist;

    static final int MAX = 20000000;
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine()); // 정점
        m = Integer.parseInt(reader.readLine()); // 간선

        dist = new int[n + 1][n + 1];
        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist[i].length; j++) {
                dist[i][j] = MAX; //최대로 설정
            }
        }

        StringTokenizer tokenizer;
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            dist[a][b] = Math.min(c, dist[a][b]);
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || dist[i][j] == MAX)
                    dist[i][j] = 0;
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
