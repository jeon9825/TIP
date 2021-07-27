package algorithm.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ11266 { // 단절점

    static int v, e; // 정점, 간선
    static List<Integer> list[];
    static int[] orders; // 본인의 순서
    static boolean[] isTerm; // 단절점 여부
    static int order; // order를 전역변수로

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        v = Integer.parseInt(tokenizer.nextToken());
        e = Integer.parseInt(tokenizer.nextToken());

        list = new ArrayList[v + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        orders = new int[v + 1];
        isTerm = new boolean[v + 1];
        order = 1;
        for (int i = 1; i < orders.length; i++) {
            if (orders[i] == 0)
                dfs(i, true, 0); // i가 단절점인가?
        }
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for (int i = 1; i < isTerm.length; i++) {
            if (isTerm[i]) {
                count++;
                builder.append(i + " ");
            }
        }
        System.out.println(count);
        System.out.println(builder.toString());
    }

    static int dfs(int id, boolean isRoot, int parent) {
        orders[id] = order++;

        int child = 0; // 자식 수
        int result = orders[id]; // dfs를 돌면서 가장 작은 값
        for (int next : list[id]) {
            // parent 부분 끊어주기 (돌아가면 안됨)
            if (next == parent)
                continue;

            // 최초 방문 => dfs 재귀
            if (orders[next] == 0) {
                child++;
                int low = dfs(next, false, id); // dfs를 돌면서 가장 작은 값

                // 이 정점(id) 없이
                // 돌았을 때 (dfs) => 다시 만나면 low 값이 무조건 작거나 같으면 우회선이 있다는 것
                // 왜냐면 단절점이 아니라서 그리고 parent도 못가게 막아놓음
                if (!isRoot && low >= orders[id])
                    isTerm[id] = true;
                result = Math.min(result, low);
            } else { // 이미 방문했으면
                result = Math.min(result, orders[next]);
            }
        }

        if (isRoot && child >= 2) { // 루트이고 자식이 2개 이상이면 단절점!
            isTerm[id] = true;
        }
        return result;
    }
}
