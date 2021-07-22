package algorithm.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1275 {

    static int N, Q;
    static int S;
    static int[] nums;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        Q = Integer.parseInt(tokenizer.nextToken());

        nums = new int[N];
        nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        S = 1;
        while (S < N) {
            S *= 2;
        }
        tree = new long[S * 2];
        init();

        for (int i = 0; i < Q; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            long sum = query(1, S, 1, x, y);
            System.out.println(sum);
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            long diff = b - tree[S + a - 1];
            update(1, S, 1, a, diff);
        }
    }

    private static void init() {
        for (int i = 0; i < N; i++) {
            tree[i + S] = nums[i];
        }

        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    private static long query(int left, int right, int node, int queryLeft, int queryRight) {
        if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        } else if (right < queryLeft || queryRight < left) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            long leftSum = query(left, mid, node * 2, queryLeft, queryRight);
            long rightSum = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
            return leftSum + rightSum;
        }
    }

    static void update(int left, int right, int node, int target, long diff) {
        if (left <= target && target <= right) {
            tree[node] += diff;

            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node * 2, target, diff);
                update(mid + 1, right, node * 2 + 1, target, diff);
            }
        }
    }
}
