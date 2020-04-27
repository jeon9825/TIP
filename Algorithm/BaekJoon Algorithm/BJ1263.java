import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Time implements Comparable<Time> {
	int T;
	int S;

	public Time(int t, int s) {
		T = t;
		S = s;
	}

	@Override
	public int compareTo(Time o) {
		return this.S - o.S;
	}

}

public class BJ1263 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());

		Time[] time = new Time[n];

		StringTokenizer tokenizer;
		for (int i = 0; i < time.length; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			int t = Integer.parseInt(tokenizer.nextToken());
			int s = Integer.parseInt(tokenizer.nextToken());
			time[i] = new Time(t, s);
		}
		Arrays.sort(time);
		int wakeTime = time[time.length - 1].S - time[time.length - 1].T;
		for (int i = time.length - 2; i >= 0; i--) {
			if (time[i].S > wakeTime)
				time[i].S = wakeTime;
			wakeTime = time[i].S - time[i].T;
		}

		System.out.println(wakeTime < 0 ? -1 : wakeTime);
	}
}
