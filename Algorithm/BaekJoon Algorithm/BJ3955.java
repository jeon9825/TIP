package algorithm.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3955 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;

        // X : 인당 나눠줄 사탕의 수
        // Y : 사탕 봉지의 수
        // A * X + 1 = B * Y => Ax + By = C 의 형태로 변환
        // -Ax + By = 1
        // A(-x) + By = 1
        // 0 < X , 0 < Y <= 10^9
        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            long A = Integer.parseInt(tokenizer.nextToken());
            long B = Integer.parseInt(tokenizer.nextToken());

            ExtendedGcd result = extendedGcd(A, B);
            // D = gcd(A,B)
            // Ax + By = C 일 때 C % D == 0 이어야 해를 가질 수 있음 : 베주 항정식
            if (result.r != 1)
                System.out.println("IMPOSSIBLE");
            else {
                // x0 = s * C / D
                // y0 = t * C / D
                long x0 = result.s;
                long y0 = result.t;

                // x = x0 + B/D * k
                // y = y0 - A/D * k

                // x < 0
                // x0 + B * k < 0
                // 1. k < -x0 / B

                // 0 < y <= 1e9
                // 0 < y0 - A * k <= 1e9
                // 2. (y0 - 1e9) / A < k <= y0 / A
                // 주의 : 나눠줄 땐 double로 찾아주고 정수 <= k <= 정수로
                // long minK = (long) Math.ceil((double) y0 /A)) -1;
                long minK = (long) (y0 - 1e9) / A;
                long maxK = (long) Math.ceil((double) -x0 / B) - 1;
                long maxY = (long) Math.ceil((double) y0 / A) - 1;
                if (maxY < maxK)
                    maxK = maxY;

                if (maxK < minK)
                    System.out.println("IMPOSSIBLE");
                else {
                    long x = x0 + B * maxK;
                    // 정확히는 x = (x0 + b * maxK) * -1;
                    long y = y0 - A * maxK;

                    System.out.println(y);
                }
            }
        }
    }

    static ExtendedGcd extendedGcd(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long tmp;
        while (r1 != 0) {
            long q = r0 / r1;
            tmp = r0 - r1 * q;
            r0 = r1;
            r1 = tmp;

            tmp = s0 - s1 * q;
            s0 = s1;
            s1 = tmp;

            tmp = t0 - t1 * q;
            t0 = t1;
            t1 = tmp;
        }

        return new ExtendedGcd(s0, t0, r0);
    }

    static class ExtendedGcd {
        long s;
        long t;
        long r; // gcd

        public ExtendedGcd(long s, long t, long r) {
            this.s = s;
            this.t = t;
            this.r = r;
        }
    }
}
