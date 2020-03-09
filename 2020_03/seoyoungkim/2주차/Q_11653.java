import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// 첫째 줄에 정수 N (1 ≤ N ≤ 10,000,000)이 주어진다.
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// N의 소인수분해 결과를 한 줄에 하나씩 오름차순으로 출력한다.
		int i = 2;
		while (i <= 10000000) {
			if (N % i == 0) {
				System.out.println(i);
				N = N / i;
			}
			else {
				i++;
			}
		}
		
		sc.close();
	}
}
