import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		// 첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int maximum_commitment_number = 1; // 최대공약수
		int least_common_multiple = 1; // 최소공배수

		
		// 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를,둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
		int i = 2; // 나누는 수
		while (i <= 10000) {
			if ((A % i == 0) && (B % i == 0)) {
				maximum_commitment_number = maximum_commitment_number * i;
				A = A / i;
				B = B / i;
			} else {
				i++;
			}
		}
		
		least_common_multiple = maximum_commitment_number * A * B;
		
		System.out.println(maximum_commitment_number + "\n" + least_common_multiple);
		
		sc.close();
	}
}
