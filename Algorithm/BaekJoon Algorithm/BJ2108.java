import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BJ2108 {
	static int frequency(int[] num) {
		int[] fre = new int[8001];
		for (int i = 0; i < num.length; i++) {
			fre[num[i] + 4000]++;
		}
		int max = 1;
		ArrayList<Integer> maxValue = new ArrayList<>();
		for (int i = 0; i < fre.length; i++) {
			if (fre[i] > max) {
				maxValue.clear();
				maxValue.add(i - 4000);
				max = fre[i];
			} else if (fre[i] == max) {
				maxValue.add(i - 4000);
			}
		}
		Collections.sort(maxValue);
		return maxValue.size() == 1 ? maxValue.get(0) : maxValue.get(1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] num = new int[n];
		int sum = 0;
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(reader.readLine());
			sum += num[i];
		}
		// »ê¼úÆò±Õ
		System.out.println((int) Math.round(sum * 1.0 / n));

		// Áß¾Ó°ª
		Arrays.sort(num);
		System.out.println(num[n / 2]);

		// ÃÖºó°ª
//		int[] fre = new int[n]; // ºóµµ
//		int value = 0;
//		for (int i = 0; i < num.length; i++) {
//			if (num[value] == num[i]) {
//				fre[value]++;
//			} else {
//				value = i;
//				fre[value]++;
//			}
//		}
//		int[] index = { -1, -1 };
//		int maxF = -1;
//		for (int i = 0; i < fre.length; i++) {
//			if (fre[i] == 0)
//				continue;
//			if (maxF < fre[i]) {
//				maxF = fre[i];
//				index[0] = i;
//				index[1] = -1;
//			} else if (maxF == fre[i]) {
//				if (index[1] == -1) {
//					index[1] = i;
//				} else {
//					break;
//				}
//			}
//		}
//		if (index[1] == -1) {
//			System.out.println(num[index[0]]);
//		} else {
//			System.out.println(num[index[1]]);
//		}
		System.out.println(frequency(num));

		// ¹üÀ§
		System.out.println(num[num.length - 1] - num[0]);
	}

}
