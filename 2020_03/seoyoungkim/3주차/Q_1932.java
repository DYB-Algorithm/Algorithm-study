import java.util.Scanner;

public class Q_1932 {
	public static void main(String[] args) {
		
		// 첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고,
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.
		int tri[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i+1; j++) {
				tri[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i < n; i++) {
			
			tri[i][0] = tri[i-1][0] + tri[i][0];

			for (int j = 1; j < i+1; j++) {
				tri[i][j] = Math.max(tri[i-1][j], tri[i-1][j-1]) + tri[i][j];
			}
		}
		
		// 첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.
		int max = 0;
		
		for (int i = 0; i < n; i++) {
			max = Math.max(max, tri[n-1][i]);
		}
		System.out.println(max);
		
		sc.close();
	}
}
