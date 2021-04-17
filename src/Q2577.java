import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //초밥 벨트에 놓인 접시의 수
		int d = Integer.parseInt(st.nextToken()); //초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); //쿠폰 번호
		
		int[] dish = new int[N];
		for(int i=0; i<N; i++) dish[i] = Integer.parseInt(br.readLine());
		
		int[] sushi = new int[d+1];
		sushi[c]++;
		
		int cnt = 1;
		for(int i=0; i<k; i++) {
			if(sushi[dish[i]]++==0) cnt++;
		}
		int res = cnt;
		
		for (int i = k; i < N+k; i++) {
			if(--sushi[dish[i-k]]==0) cnt--;
			if(sushi[dish[i%N]]++==0) cnt++;
			if(cnt > res) res = cnt;
			
		}
		
		System.out.println(res);
	}
}
