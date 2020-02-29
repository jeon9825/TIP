import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2476 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
			int[] dice=new int [3];
			for (int j = 0; j < dice.length; j++) {
				dice[j]=Integer.parseInt(tokenizer.nextToken());
			}
			Arrays.sort(dice);
			int price;
			if(dice[0]==dice[1]&&dice[1]==dice[2]) {
				price = 10000+dice[0]*1000;
			}else if(dice[0]==dice[1]||dice[1]==dice[2]) {
				price = 1000+dice[1]*100;
			}else {
				price = dice[2]*100;
			}
			max=Math.max(max, price);
		}
		System.out.println(max);
	}
}
