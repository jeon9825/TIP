import java.util.Arrays;

public class MeetingRooms {
	public static void main(String[] args) {
		Interval in1 = new Interval(15, 20);
		Interval in2 = new Interval(5, 10);
		Interval in3 = new Interval(0, 30);

		Interval[] ins = { in1, in2, in3 };
		System.out.println(solve(ins));
	}

	public static boolean solve(Interval[] intervals) {
		if (intervals == null)
			return false;

		// 1. 소팅
		Arrays.sort(intervals);

		// 2. 과거.end > 현재.end => 실패
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i - 1].end > intervals[i].end)
				return false;
		}

		return true;
	}

	public static void print(Interval[] intervals) {
		for (int i = 0; i < intervals.length; i++) {
			Interval in = intervals[i];
			System.out.println(in.start + " " + in.end);
		}
	}
}

class Interval implements Comparable<Interval> {
	int start;
	int end;

	public Interval() {
		this.start = 0;
		this.end = 0;
	}

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Interval o) {
		return this.start - o.start;
	}

}
