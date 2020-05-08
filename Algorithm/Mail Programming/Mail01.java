/*
 * 정수 배열(int array)가 주어지면 가장 큰 이어지는 원소들의 합을 구하시오. 단, 시간복잡도는 O(n).
 * Given an integer array, find the largest consecutive sum of elements.
 * 예제}
 * Input: [-1, 3, -1, 5]
 * Output: 7 // 3 + (-1) + 5
 * 
 * Input: [-5, -3, -1]
 * Output: -1 // -1
 * 
 * Input: [2, 4, -2, -3, 8]
 * Output: 9 // 2 + 4 + (-2) + (-3) + 8
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mail01 {
	static int solution(int[] arr) {
		int max = arr[0];
		int current = arr[0];
		for (int i = 1; i < arr.length; i++) {
			current = Math.max(current + arr[i], arr[i]);
			if (current > max)
				max = current;
		}
		return max;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
		}
		System.out.println(solution(arr));
	}
}
