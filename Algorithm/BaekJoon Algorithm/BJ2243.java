package algorithm.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2243 {

    static int[] tree;
    static int S;

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
                System.out.println(query(1, S, 1, b));
            } else { // a == 2
                int b = Integer.parseInt(tokenizer.nextToken());
                int c = Integer.parseInt(tokenizer.nextToken());
                updateBU(b, c);
            }
        }
    }

    private static int query(int left, int right, int node, int many) {
        if (left == right) { // Leaf 노드일 때
            updateBU(left, -1);
            return left;
        }

        int mid = (left + right) / 2;
        if (many <= tree[node * 2]) { //왼쪽 노드
            return query(left, mid, node * 2, many);
        } else {//오른쪽 노드
            return query(mid + 1, right, node * 2 + 1, many - tree[node * 2]);
        }
    }

    private static void updateBU(int target, int num) {
        int node = S + target - 1;
        tree[node] += num;

        node /= 2;
        while (node > 0) {
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
            node /= 2;
        }
    }
}
