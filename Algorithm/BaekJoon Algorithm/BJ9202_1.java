package algorithm.day4;

public class BJ9202_1 {

//    static TrieNode root = new TrieNode();
//
//    public static void main(String[] args) {
//
//        for (int i = 0; i < W; i++) {
//
//            insert(reader.readLine());
//
//        }
//    }
//
//    static class TrieNode {
//        BJ9202.TrieNode[] children = new BJ9202.TrieNode[26];
//        boolean isEnd;
//        boolean isHit;
//
//        void clearHit() {
//            isHit = false;
//            for (int i = 0; i < children.length; i++) {
//                if (children[i] != null) {
//                    children[i].clearHit();
//                }
//            }
//        }
//
//        boolean hasChild(char c) {
//            return children[c - 'A'] != null;
//        }
//
//        BJ9202.TrieNode getChildren(char c) {
//            return children[c - 'A'];
//        }
//    }
//
//    private static void insert(String word) {
//        TrieNode current = root;
//        for (int i = 0; i < word.length(); i++) {
//            int wordIndex = word.charAt(i) - 'A';
//            if (current.children[wordIndex] == null) {
//                current.children[wordIndex] = new BJ9202.TrieNode();
//            }
//            current = current.children[wordIndex];
//        }
//        current.isEnd = true;
//    }
//
//    private static boolean containsNode(String word) {
//        TrieNode current = root;
//        for (int i = 0; i < word.length(); i++) {
//            int wordIndex = word.charAt(i) - 'A';
//            if (current.children[wordIndex] == null) {
//                return false;
//            }
//            current = current.children[wordIndex];
//        }
//        return true;
//    }

    static char[][] map;
    static boolean[][] visited;
    static int[] mx = {1, -1, 0, 0, 1, 1, -1, -1};
    static int[] my = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] score = {0, 0, 0};
    static StringBuilder sb;
    static long sum;
    static int count;
    static String answer;

    static void search(int y, int x, int length, BJ9202.TrieNode node) { // 내가 지금 방문할 곳의 정보를 파라미터로 전달!!
        // 1. 체크인
        visited[y][x] = true;
        sb.append(map[y][x]);

        // 2. 목적지에 도착했는가
        if (node.isEnd && !node.isHit) {
            node.isHit = true;
            sum += score[length];
            count++;
            String foundWord = sb.toString();
            if (compare(answer, foundWord) > 0) {
                answer = foundWord;
            }
        }

        // 3. 연결된 곳을 순회
        for (int i = 0; i < 8; i++) {
            int ty = y + my[i];
            int tx = x + mx[i];

            // 4. 가능한가? - map 경계, 방문하지 않았는지, node가 해당 자식을 가지고 있는지
            if (0 <= ty && ty < 4 && 0 <= tx && tx < 4) {
                if (!visited[ty][tx] && node.hasChild(map[ty][tx])) {
                    search(ty, tx, length + 1, node.getChildren(map[ty][tx]));
                }
            }
            // 5. 간다
        }

        // 6. 체크아웃
        visited[y][x] = false;
        sb.deleteCharAt(length - 1);
    }

    static int compare(String arg0, String arg1) {
        int result = Integer.compare(arg1.length(), arg0.length());
        if (result != 0)
            return result;
        return arg0.compareTo(arg1);
    }
}
