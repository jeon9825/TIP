package algorithm.day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3830 { // 교수님은 기다리지 않는다.

    static int[] parent;
    static int[] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        while (true) {
            tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());

            if (n == 0 && m == 0)
                break;

            parent = new int[n + 1];
            init();

            weight = new int[n + 1]; // parent에서 각 노드까지 걸리는 cost

            for (int i = 0; i < m; i++) {
                String line = reader.readLine();
                String[] command = line.substring(2).split(" ");
                if (line.startsWith("!")) { // b가 a보다 w그램 무겁다는 뜻이다. (a ≠ b)
                    int a = Integer.parseInt(command[0]);
                    int b = Integer.parseInt(command[1]);
                    int w = Integer.parseInt(command[2]);
                    union(a, b, w);
                } else { // b가 a보다 얼마나 무거운지를 출력
                    int a = Integer.parseInt(command[0]);
                    int b = Integer.parseInt(command[1]);

                    int pa = find(a);
                    int pb = find(b);
                    if (pa != pb)
                        System.out.println("UNKNOWN");
                    else
                        System.out.println(weight[b] - weight[a]);
                }
//                System.out.println(Arrays.toString(parent));
//                System.out.println(Arrays.toString(weight));
            }
        }
    }

    private static void union(int a, int b, int w) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return;

        // dist[pa] = dist[pb] + dist[b] - dist[a] - w
        // dist[pb] = 0임
        weight[pa] = weight[b] - weight[a] - w;
        parent[pa] = pb;
    }


    private static int find(int num) {
        if (parent[num] == num)
            return num;
        int pnum = find(parent[num]);
        weight[num] += weight[parent[num]];
        return parent[num] = pnum;
    }

    private static void init() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }
}
