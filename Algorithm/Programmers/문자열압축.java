class Solution {
	int compress(String s, int n) {
		int result = 0;
//		StringBuilder sb = new StringBuilder();//
		String pre = s.substring(0, n);
		int count = 1;
		for (int i = n; i <= s.length() - n; i += n) {
			if (s.subSequence(i, i + n).equals(pre))
				++count;
			else {
				if (count > 1)
//					sb.append(count);
					result += String.valueOf(count).length();
//				sb.append(pre);
				result += n;
				pre = s.substring(i, i + n);
				count = 1;
			}
		}
		if (count > 1)
//			sb.append(count);
			result += String.valueOf(count).length();
//		sb.append(pre);
		result += n;

		int tail = s.length() % n;
		if (tail > 0)
//			sb.append(s.substring(s.length() - tail));
			result += tail;
//		return sb.toString();
		return result;
	}

	public int solution(String s) {
		int min = s.length();
		for (int i = 1; i <= s.length() / 2; i++) {
			int val = compress(s, i);
			if (val < min)
				min = val;
		}
		return min;
	}
}