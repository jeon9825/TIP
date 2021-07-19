package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1062 {

    private static int N, K;
    private static String[] word;
    private static boolean[] visited = new boolean[26];
    private static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
        word = new String[N];

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        } else {
            for (int i = 0; i < N; i++) {
                String line = reader.readLine();
                word[i] = line.substring(4, line.length() - 4);
            }

            visited['a' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['c' - 'a'] = true;

            combination(K - 5, 0);
            System.out.println(max);
        }

    }

    private static void combination(int index, int start) {
        if (index == 0) { // 남은 개수가 없을 때
            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean know = true;
                for (int j = 0; j < word[i].length(); j++) {
                    if (!visited[word[i].charAt(j) - 'a']) {
                        know = false;
                        break;
                    }
                }
                if (know)
                    count++;
            }
            max = Math.max(max, count);
            return;
        }
        for (int i = start; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(index - 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
