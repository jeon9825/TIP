package algorithm.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ11400 { // 단절선

    static int v, e; // 정점, 간선
    static List<Integer> list[];
    static int[] orders; // 본인의 순서
    static int order; // order를 전역변수로
    static List<Edge> answer = new ArrayList<>();

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
        order = 1;

        for (int i = 1; i < orders.length; i++) {
            if (orders[i] == 0) {
                dfs(i, 0);
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for (int i = 0; i < answer.size(); i++) {
            Edge now = answer.get(i);
            System.out.println(now.start + " " + now.target);
        }
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int target;

        public Edge(int start, int target) {
            this.start = Math.min(start, target);
            this.target = Math.max(start, target);
        }

        @Override
        public int compareTo(Edge o) { // 사전순 출력
            int r = this.start - o.start;
            if (r != 0) return r;
            return this.target - o.target;
        }
    }

    private static int dfs(int id, int parent) {
        orders[id] = order++;

        int result = orders[id];
        for (int next : list[id]) { // 인접한 노드들
            if (next == parent) // parent로 돌아갈 수 없음
                continue;

            if (orders[next] == 0) { // 방문한 적이 없다면
                int low = dfs(next, id);

                // 이 정점(id) 없이
                // 돌았을 때 (dfs) => 다시 만나면 low 값이 무조건 작아져!!있으면 우회선이 있다는 것
                // => 단절선이 아님
                // low 값과 같으면 다른 연결 선(우회 선)이 존재한다는 것.
                // (low == orders[id]이면 단절선이 될 수 없음.)
                if (low > orders[id]) {
                    answer.add(new Edge(id, next));
                }
                result = Math.min(result, low);
            } else {
                result = Math.min(result, orders[next]);
            }
        }
        return result;
    }
}
