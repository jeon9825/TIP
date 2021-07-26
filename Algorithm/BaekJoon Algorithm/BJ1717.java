package algorithm.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1717 {

    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        parent = new int[n + 1];
        init();

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int div = Integer.parseInt(tokenizer.nextToken());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());

            if (div == 0) { // 합집합 union
                union(a, b);
            } else { // find
                int pa = find(a);
                int pb = find(b);
                if (pa == pb)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        parent[pa] = pb;
    }

    private static int find(int num) {
        if (parent[num] == num)
            return num;
        return parent[num] = find(parent[num]);
    }

    private static void init() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }
}
