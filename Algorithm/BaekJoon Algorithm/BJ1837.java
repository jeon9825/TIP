package algorithm.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1837 {

    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        String P = tokenizer.nextToken();
        int K = Integer.parseInt(tokenizer.nextToken());

        prime = new boolean[K];
        Arrays.fill(prime, true); // 소수라고 설정
        primeNumber();

        for (int i = 0; i < prime.length; i++) {
            if (prime[i] && divide(P, i)) {
                System.out.println("BAD " + i);
                return;
            }
        }
        System.out.println("GOOD");
    }

    private static boolean divide(String p, int i) { // p % i == 0 이면 true 리턴
        int num = 0;
        for (int j = 0; j < p.length(); j++) {
            num += p.charAt(j) - '0';
            num = (num % i) * 10;
        }
        if (num == 0)
            return true;
        else
            return false;
    }

    static void primeNumber() {
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i < prime.length / 2; i++) {
            if (prime[i]) { // i가 소수이면
                for (int j = 2; i * j < prime.length; j++) {
                    prime[i * j] = false;
                }
            }
        }
    }

}
