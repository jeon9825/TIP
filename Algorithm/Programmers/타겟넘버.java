import java.io.IOException;
import java.util.*;

public class 타겟넘버{
	public static int solution(int[] numbers, int target) {
		int answer = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(numbers[0]);
		q.add(numbers[0] * -1);
		int i = 1;
		int s = 0;
		while (!q.isEmpty()) {
			int n = q.poll();
			if (i == numbers.length && n == target)
				answer++;
			if (i < numbers.length) {
				q.add(n + numbers[i]);
				q.add(n - numbers[i]);
				s++;
				if (s == Math.pow(2, i)) {
					s = 0;
					i++;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(solution(new int[] { 1, 1, 1, 1, 1 }, 3));
	}
}

//class Solution {
//    public int solution(int[] numbers, int target) {
//        int answer = 0;
//        answer = dfs(numbers, 0, 0, target);
//        return answer;
//    }
//    int dfs(int[] numbers, int n, int sum, int target) {
//        if(n == numbers.length) {
//            if(sum == target) {
//                return 1;
//            }
//            return 0;
//        }
//        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
//    }
//}