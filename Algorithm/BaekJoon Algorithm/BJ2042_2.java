package algorithm.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2042_2 {

    static int N, M, K;
    static long[] nums;
    static long[] tree;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        nums = new long[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(reader.readLine());
        }
        S = 1;
        while (S < N) {
            S *= 2;
        }
        tree = new long[S * 2]; // 트리의 크기를 최소한으로 만들어준다.

        initBU();

        for (int i = 0; i < M + K; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            if (a == 1) {
                int b = Integer.parseInt(tokenizer.nextToken());
                long c = Long.parseLong(tokenizer.nextToken());
                updateBU(b, c);
            }
            if (a == 2) {
                int b = Integer.parseInt(tokenizer.nextToken());
                int c = Integer.parseInt(tokenizer.nextToken());
                long sum = queryBU(b, c);
                System.out.println(sum);
            }
        }
    }

    static void initBU() {
        // Leaf에 값 반영
        for (int i = 0; i < nums.length; i++) {
            tree[i + S] = nums[i];
        }

        // 내부노드 채움
        for (int i = S - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
    }

    static long queryBU(int queryLeft, int queryRight) {
        // Leaf에서 left, right 설정 (node)
        int left = S + queryLeft - 1;
        int right = S + queryRight - 1;

        long sum = 0;
        while (left <= right) {
            if (left % 2 == 1) {// 좌측 노드가 홀수이면 현재 노드 값을 사용하고 한칸 옆으로
                sum += tree[left++];
            }

            if (right % 2 == 0) { // 우측 노드가 짝수이면 현재 노드 값 사용하고 한칸 옆으로
                sum += tree[right--];
            }

            // 좌측, 우측 모두 부모로 이동
            left /= 2;
            right /= 2;
        }
        return sum;
    }

    static void updateBU(int target, long value) {
        // Leaf에서 target을 찾음
        int node = S + target - 1;

        // value 반영
        tree[node] = value;

        // root에 도달할 때까지 부모에 값 반영
        node /= 2;
        while (node > 0) {
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
            node /= 2;
        }
    }

    static void initTD() {

    }
}
