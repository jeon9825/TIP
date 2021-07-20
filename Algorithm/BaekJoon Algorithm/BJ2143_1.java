package algorithm.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2143_1 {
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

        List<Long> subA = new ArrayList<>();
        List<Long> subB = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            long sum = A[i];
            subA.add(sum);
            for (int j = i + 1; j < N; j++) {
                sum += A[j];
                subA.add(sum);
            }
        }


        for (int i = 0; i < M; i++) {
            long sum = 0;
            for (int j = i; j < M; j++) {
                sum += A[j];
                subB.add(sum);
            }
        }

        Collections.sort(subA);
        Collections.sort(subB, Comparator.reverseOrder());


        long result = 0;
        int ptA = 0;
        int ptB = 0;
        while (ptA < subA.size() && ptB < subB.size()) {
            long currentA = subA.get(ptA);
            long target = T - currentA;

            if (subB.get(ptB) > target) {
                ptB++;
            } else if (subB.get(ptB) == target) {
                long countA = 0;
                long countB = 0;

                while (ptA < subA.size() && subA.get(ptA) == currentA) {
                    ptA++;
                    countA++;
                }

                while (ptB < subB.size() && subB.get(ptB) == target) {
                    ptB++;
                    countB++;
                }

                result += countA * countB;
            } else {
                ptA++;
            }
        }
    }
}
