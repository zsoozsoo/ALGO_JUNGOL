import java.util.*;
import java.io.*;

public class Q1037 {
	
	static int n;
	static int[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int idx = 0, change = 0;
		
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			int sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				sum += arr[i][j];
			}
			
			if(sum%2!=0) {
				idx = i;
				change++;
			}
		}
		
		
		if(change>1) {
			System.out.println("Corrupt");
			return;
		}else {
			int newIdx = 0;
			change = 0;
			for (int i = 0; i < n; i++) {
				
				int colSum = 0;
				for (int j = 0; j < n; j++) {
					colSum += arr[j][i];
				}
				
				if(colSum%2!=0) {
					change++;
					newIdx = i;
				}
			}
			
			if(change>1) {
				System.out.println("Corrupt");
				return;
			} else if (change==1) System.out.println("Change bit (" + (idx+1) + "," + (newIdx+1) + ")");
			else System.out.println("OK");
		}

		
	}



}
