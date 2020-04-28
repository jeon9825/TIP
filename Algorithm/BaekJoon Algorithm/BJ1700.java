import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1700 {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(tokenizer.nextToken());
		int k = Integer.parseInt(tokenizer.nextToken());
		int[] tab = new int[n];
		int[] scheduled = new int[k];

		tokenizer = new StringTokenizer(reader.readLine());
		for (int i = 0; i < scheduled.length; i++) {
			scheduled[i] = Integer.parseInt(tokenizer.nextToken());
		}

		int result = 0;
		for (int i = 0; i < scheduled.length; i++) {

			boolean pluggedIn = false;
			for (int j = 0; j < tab.length; j++) { // 멀티탭에 있는지 확인
				if (scheduled[i] == tab[j]) { // 있으면
					pluggedIn = true;
					break;
				}
			}
			if (pluggedIn)
				continue;

			for (int j = 0; j < tab.length; j++) {
				if (tab[j] == 0) { // 비어있는 구멍이 있을 경우
					tab[j] = scheduled[i];
					pluggedIn = true;
					break;
				}
			}
			if (pluggedIn)
				continue;

			int index = 0; // tab중에서 어떤 index가 가장 효율적인지 저장해 놓음
			int cnt = 0; //
			for (int j = 0; j < tab.length; j++) { // 탭중에서 scheduled에 없거나 가장 나중에 쓰는
				int cntJ = 0; // tab에서 j를 뺐을 때의 횟수
				for (int l = i + 1; l < scheduled.length; l++) {
					if (tab[j] == scheduled[l]) { // 있다면
						break;
					}
					cntJ++; // 없으면 : cnt가 높을수록 손해임
				}
				if (cntJ > cnt) { // 제일 손해일 때
					index = j;
					cnt = cntJ;
				}
			}
			result++;
			tab[index] = scheduled[i];
		}
		System.out.println(result);
	}
}
