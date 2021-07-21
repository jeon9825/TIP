package algorithm.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1202 {

    static class Jewelries {
        int weight;
        int value;

        public Jewelries(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Jewelries{" +
                    "weight=" + weight +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        Jewelries[] jewelries = new Jewelries[n];
        int[] bag = new int[k];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            int m = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());

            jewelries[i] = new Jewelries(m, v);
        }

        for (int i = 0; i < k; i++) {
            int c = Integer.parseInt(reader.readLine());
            bag[i] = c;
        }

        Arrays.sort(jewelries, Comparator.comparingInt(Jewelries::getWeight));
        Arrays.sort(bag);

        PriorityQueue<Jewelries> possible = new PriorityQueue<>(Comparator.comparingInt(Jewelries::getValue).reversed());

        long sum = 0; // 합은 꼭 long으로 선언해줄 것...!!!
        int jIndex = 0;
        for (int i = 0; i < k; i++) {
            int bagSize = bag[i];

            while (jIndex < n && jewelries[jIndex].weight <= bagSize) {
                possible.add(jewelries[jIndex++]);
            }

            if (!possible.isEmpty()) {
                sum += possible.remove().value;
            }
        }
        System.out.println(sum);
    }
}
