package algorithm.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ2143 { // 두 배열의 합

    static int T;
    static int N, M;
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(reader.readLine());

        N = Integer.parseInt(reader.readLine());
        A = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(tokenizer.nextToken());
        }

        M = Integer.parseInt(reader.readLine());
        B = new int[M];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(tokenizer.nextToken());
        }

        long[] subA = new long[N * (N + 1) / 2];
        Long[] subB = new Long[M * (M + 1) / 2];

        int index = 0;
        for (int i = 0; i < N; i++) {
            long sum = 0;
            for (int j = i; j < N; j++) {
                sum += A[j];
                subA[index++] = sum;
            }
        }

        index = 0;
        for (int i = 0; i < M; i++) {
            long sum = 0;
            for (int j = i; j < M; j++) {
                sum += B[j];
                subB[index++] = sum;
            }
        }

        Arrays.sort(subA);
        Arrays.sort(subB, Comparator.reverseOrder());

        // 투포인터
        int pointerA = 0;
        int pointerB = 0;

        long sum = 0;
        long count = 0;

        while (pointerA < subA.length && pointerB < subB.length) {
            sum = subA[pointerA] + subB[pointerB];
            if (sum > T) {
                pointerB++;
            } else if (sum < T) {
                pointerA++;
            } else {
                long numA = subA[pointerA];
                long numB = subB[pointerB];

                long sizeA = 0;
                long sizeB = 0;
                while (pointerA < subA.length && numA == subA[pointerA]) {
                    sizeA++;
                    pointerA++;
                }

                while (pointerB < subB.length && numB == subB[pointerB]) {
                    sizeB++;
                    pointerB++;
                }

                count += (sizeA * sizeB);
            }
        }

        System.out.println(count);
    }
}
