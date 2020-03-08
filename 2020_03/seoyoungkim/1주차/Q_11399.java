import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// 첫째 줄에 사람의 수 N(1 ≤ N ≤ 1,000)이 주어진다. 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 둘째 줄에는 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어진다. (1 ≤ Pi ≤ 1,000)
		int P[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			P[i] = sc.nextInt();
		}
		
		// 오름차순으로 정렬
		int empty = 0;
		
		for (int m = 0; m < P.length-1; m++) {
			for (int n = m+1; n < P.length; n++) {
				if (P[n] < P[m]) {
					empty = P[n];
					P[n] = P[m];
					P[m] = empty;
				}
			}
		}
		
		// 첫째 줄에 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 출력한다.
		int SUM[] = new int[N+1]; // 초기값 0
		
		for (int i = 0; i < N; i++) {
			SUM[i+1] = SUM[i] + P[i];
		}
		
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum = sum + SUM[i+1];
		}
		System.out.println(sum);
		
		sc.close();
	}
}
