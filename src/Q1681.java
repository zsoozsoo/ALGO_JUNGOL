import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1681 {
	
	static int[][] distance;
	static boolean[] visited;
	static int N, min=Integer.MAX_VALUE, idx;
	
	private static void btk(int i, int sum, int depth) {
		
		if(sum >= min) {//최소값보다 크면 하는 의미 없으니까~
			return;
		}
		
		if(depth==N) {
			if(distance[i][1] != 0) { //돌아오는 길 없을 때
				min = Math.min(min, sum+distance[i][1]);
				return;
			}
		}
		
		for (int j = 1; j <=N; j++) {
			if(!visited[j] && distance[i][j]!=0) {//방문안한곳 //가는길이 있고
				visited[j] = true;
				btk(j,sum+distance[i][j],depth+1);
				visited[j] = false;
			}
		}
		

		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		distance = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <=N; j++) {
				distance[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited[1]= true;
		btk(1,0,1);
		
		System.out.println(min);
	}
}
