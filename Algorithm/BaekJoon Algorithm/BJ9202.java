package algorithm.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ9202 {

    static TrieNode root;

    static String[] words;
    static char[][] map;
    static boolean[][] visited;

    static int[] mx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] my = {0, 0, 1, -1, 1, -1, 1, -1};

    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(reader.readLine());

        root = new TrieNode();
        words = new String[w];

        for (int i = 0; i < w; i++) {
            String word = reader.readLine();
            words[i] = word;
            insert(word);
        }
        reader.readLine();
        int b = Integer.parseInt(reader.readLine());
        for (int i = 0; i < b; i++) {
            set = new HashSet<>();
            map = new char[4][4];
            for (int j = 0; j < 4; j++) {
                map[j] = reader.readLine().toCharArray();
            }
            reader.readLine();

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (root.hasChild(map[j][k])) {
                        visited = new boolean[4][4];
                        TrieNode current = root;
                        StringBuilder builder = new StringBuilder();
                        DFS(j, k, current.getChildren(map[j][k]), builder);
                    }
                }
            }

            int count = set.size();
            String longWord = "";
            int maxResult = 0;
            for (String word : set) {
                if (longWord.length() < word.length()) {
                    longWord = word;
                } else if (longWord.length() == word.length()) {
                    if (word.compareTo(longWord) < 0) {
                        longWord = word;
                    }
                }

                maxResult += result(word);
            }
            System.out.println(maxResult + " " + longWord + " " + count);
            root.clearHit();
        }
    }

    private static int result(String word) {
        switch (word.length()) {
            case 0:
            case 1:
            case 2:
                return 0;
            case 3:
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
            case 7:
                return 5;
            case 8:
                return 11;
        }
        return 0;
    }

    private static void DFS(int r, int c, TrieNode current, StringBuilder builder) {
        visited[r][c] = true;
        builder.append(map[r][c]);

        if (current.isEnd && !current.isHit) {
            String word = builder.toString();
            if (containsNode(word)) {
                current.isHit = true;
                set.add(word);
            }
        }

        for (int i = 0; i < 8; i++) {
            int dx = r + mx[i];
            int dy = c + my[i];

            if (dx < 0 || dx >= 4)
                continue;
            if (dy < 0 || dy >= 4)
                continue;
            if (visited[dx][dy])
                continue;

            char p = map[dx][dy]; // 이동할 수 있는 값
            if (current.hasChild(p)) { // 값이 Trie에 있는지 확인
                DFS(dx, dy, current.getChildren(p), builder);
            }
        }

        visited[r][c] = false;
        int length = builder.length();
        builder.deleteCharAt(length - 1);

    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
        boolean isHit;

        void clearHit() {
            isHit = false;
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null) {
                    children[i].clearHit();
                }
            }
        }

        boolean hasChild(char c) {
            return children[c - 'A'] != null;
        }

        TrieNode getChildren(char c) {
            return children[c - 'A'];
        }

    }

    static void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int wordIndex = word.charAt(i) - 'A';
            if (current.children[wordIndex] == null) {
                current.children[wordIndex] = new TrieNode();
            }
            current = current.children[wordIndex];
        }
        current.isEnd = true;
    }

    static boolean containsNode(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            int wordIndex = word.charAt(i) - 'A';
            if (current.children[wordIndex] == null) {
                return false;
            }
            current = current.children[wordIndex];
        }
        return true;
    }
}
