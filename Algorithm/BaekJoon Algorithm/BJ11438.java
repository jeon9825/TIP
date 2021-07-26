package algorithm.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ11438 { // LCA 2

    static List<Integer> list[];
    static int n, m, k;

    static int[] depth;

    // parent[K][V] 정점 V의 2^K번째 조상 정점 번호
    // parent[K][V] = parent[K-1][parent[K-1][V]]
    static int[][] parent;

    // 1. 모든 정점(i)의 depth를 depth[i]에 기록한다
    // 2. parent[K][V]를 모두 채운다 fillParent
    // 3. LCA를 진행한다.
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine()); // 노드의 개수

        // 2^k > n인 k 찾기
        k = 0;
        for (int i = 1; i <= n; i *= 2) {
            k++;
        }
        depth = new int[n + 1];
        parent = new int[k][n + 1];

        list = new ArrayList[n + 1];
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer tokenizer;
        for (int i = 0; i < n - 1; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        // depth 계산
        dfs(1, 1);
        // parent
        fillParent();

        // lca 계산
        m = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            builder.append(lca(a, b) + "\n");
        }
        System.out.println(builder.toString());
    }

    // parent[k][v] = parent[k-1][parent[k-1][v]];
    private static void fillParent() {
        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }
    }

    private static int lca(int a, int b) {
        // 1. depth[a] >= depth[b] 로 조정 => a가 더 깊은 정점
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        // 모든 수는 2^n의 합으로 표현가능함.
        // 2. 더 깊은 a를 2^K씩 점프하여 depth 맞추기
        for (int i = k - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b])
                a = parent[i][a];
        }

        if (a == b) // 3. depth를 맞췄는데 둘이 같다면 종료
            return a;

        // 4. 같은 depth이지만 둘이 다르다면 2^K씩 점프하여 공통 부모 바로 아래까지 올림
        for (int i = k - 1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        } // stop when parent[i][a] == parent[i][b]인 a,b

        return parent[0][a]; // 한칸 더 올려주기
    }

    private static void dfs(int id, int count) {
        depth[id] = count;
        for (int next : list[id]) {
            if (depth[next] == 0) {
                dfs(next, count + 1);
                parent[0][next] = id;
            }
        }
    }
}
