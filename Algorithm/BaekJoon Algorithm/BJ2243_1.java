package algorithm.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2243_1 {

    static int N, M;
    static int A, B, C;
    static int MAX = 1000000;
    static int S;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        S = 1;
        while (S < 1000000) {
            S *= 2;
        }
        tree = new int[S * 2];

        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            int a = Integer.parseInt(tokenizer.nextToken());

            if (a == 1) {
                int b = Integer.parseInt(tokenizer.nextToken());
                int index = query(1, S, 1, b);
                update(1, S, 1, index, -1);

                System.out.println(index);
            } else { // a == 2
                int b = Integer.parseInt(tokenizer.nextToken());
                int c = Integer.parseInt(tokenizer.nextToken());
                // TODO
                update(1, S, 1, b, c);
            }
        }
    }

    private static int query(int left, int right, int node, int count) {
        if (left == right) {
            return left;
        }

        int mid = (left + right) / 2;
        if (count <= tree[node * 2]) {//왼쪽
            return query(left, mid, node * 2, count);
        } else {//오른쪽
            int rest = count - tree[node * 2];
            return query(mid + 1, right, node * 2 + 1, rest);
        }
    }

    private static void update(int left, int right, int node, int index, long diff) {
        if (left <= index && index <= right) {
            tree[node] += diff;

            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, index, diff);
                update(mid + 1, right, node * 2 + 1, index, diff);
            }
        }
    }
}
