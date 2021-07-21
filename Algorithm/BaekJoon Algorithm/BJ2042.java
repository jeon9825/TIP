package algorithm.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2042 {

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
                long num = tree[S + b - 1];
                long diff = c - num;
                if (diff != 0)
                    update(1, S, 1, b, diff);
            }
            if (a == 2) {
                int b = Integer.parseInt(tokenizer.nextToken());
                int c = Integer.parseInt(tokenizer.nextToken());
                long sum = query(1, S, 1, b, c);
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

    // top down
    static long query(int left, int right, int node, int queryLeft, int queryRight) {
        if (node >= tree.length) // 없어도 됨....
            return 0;

        // 판단 가능 -> 현재 노드 값 return
        if (queryLeft <= left && left <= right && right <= queryRight) {
            return tree[node];
        }
        // 연관이 없음 -> 결과에 영향이 없는 값 return => 구간합에서는 영향이 없는 값은 0.
        else if (right < queryLeft || queryRight < left) {
            return 0;
        }
        // 판단 불가 -> 자식에게 위임, 자식에서 올라온 합을 리턴
        else {
            int mid = (left + right) / 2;
            return query(left, mid, node * 2, queryLeft, queryRight) + query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);
        }

    }

    // update 실행 전에 diff를 구하는 로직이 있어야 함.
    // tree[S + node -1] + diff = 원하는 값
    static void update(int left, int right, int node, int target, long diff) { // target을 diff로 변경
        if (node >= tree.length)
            return;

        // 노드가 target 포함
        if (left <= target && target <= right) {
            // 현재 노드에 diff 반영
            tree[node] += diff;
            int mid = (left + right) / 2;
            // 자식이 있을 경우 왼쪽 업데이트
            update(left, mid, node * 2, target, diff);
            // 오른쪽 업데이트
            update(mid + 1, right, node * 2 + 1, target, diff);
        }
//        else { // 미포함
//            return;
//        }
    }

    static long queryBU(int queryLeft, int queryRight) {
        return 0;
    }

    static void initTD() {

    }
}
