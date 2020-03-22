import java.util.Scanner;

public class Q_1003 {
	public static void main(String[] args) {
		
		// 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 개수
		
		int N[] = new int[T]; // 테스트 케이스

		for (int i = 0; i < T; i++) { 
			N[i] = sc.nextInt();
		}
		
		int fib[] = new int[41]; // 피보나치 수 저장 
		int count0[] = new int[41];
		int count1[] = new int[41];
		
		fib[0] = 0; count0[0] = 1; count1[0] = 0;
		fib[1] = 1; count0[1] = 0; count1[1] = 1;
		
		for (int i = 2; i <= 40 ; i++) {
			fib[i] = fib[i-1] + fib[i-2];
			count0[i] = count0[i-1] + count0[i-2];
			count1[i] = count1[i-1] + count1[i-2];
		}
		
		for (int i = 0; i < T; i++) {
			System.out.println(count0[N[i]] + " " + count1[N[i]]);
		}
		
		sc.close();
	}
}
