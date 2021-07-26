package algorithm.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2252 { // 줄 세우기 위상정렬

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        int[] indegree = new int[n + 1];
        List<Integer> list[] = new ArrayList[n + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            indegree[b]++;
            list[a].add(b);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int num = queue.remove();
            System.out.print(num + " ");

            for (int other : list[num]) {
                indegree[other]--;
                if (indegree[other] == 0)
                    queue.add(other);
            }
        }
    }
}
