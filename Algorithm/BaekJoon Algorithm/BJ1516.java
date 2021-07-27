package algorithm.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1516 { // 게임 개발
    static class Building {
        int start;
        int time;
        int ans;
        List<Integer> adjList = new ArrayList<>();

        public Building(int start) {
            this.start = start;
        }

        public Building(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Building{" +
                    "start=" + start +
                    ", time=" + time +
                    ", adjList=" + adjList +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Building[] buildings = new Building[n + 1];
        StringTokenizer tokenizer;
        int[] indegree = new int[n + 1];

        for (int i = 0; i < buildings.length; i++) {
            buildings[i] = new Building(i);
        }

        for (int i = 1; i < buildings.length; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            buildings[i].time = Integer.parseInt(tokenizer.nextToken());

            int count = 0;
            while (true) {
                int adj = Integer.parseInt(tokenizer.nextToken());
                if (adj == -1)
                    break;
                buildings[adj].adjList.add(i);
                count++;
            }

            indegree[i] = count;
        }

//        System.out.println(Arrays.toString(buildings));
//        System.out.println(Arrays.toString(indegree));

        Queue<Building> queue = new ArrayDeque<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(buildings[i]);
        }

        while (!queue.isEmpty()) {
            Building now = queue.poll();
            int num = now.start;
            now.ans += now.time;
            for (Integer next : now.adjList) {
                indegree[next]--;
                buildings[next].ans = Math.max(buildings[next].ans, buildings[num].ans);
                if (indegree[next] == 0) {
                    queue.add(buildings[next]);
                }
            }
        }
        for (int i = 1; i < buildings.length; i++) {
            System.out.println(buildings[i].ans);
        }
    }
}
