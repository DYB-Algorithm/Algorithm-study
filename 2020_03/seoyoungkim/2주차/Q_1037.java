import java.util.Scanner;

public class Q_1037 {
	public static void main(String[] args) {
		
		// 첫째 줄에 N의 진짜 약수의 개수가 주어진다. 이 개수는 50보다 작거나 같은 자연수이다. 
		Scanner sc = new Scanner(System.in);
		int the_number_of_divisor = sc.nextInt();
		
		// 둘째 줄에는 N의 진짜 약수가 주어진다. 1,000,000보다 작거나 같고, 2보다 크거나 같은 자연수이고, 중복되지 않는다.		
		int divisor[] = new int[the_number_of_divisor];
			
		for (int i = 0; i < the_number_of_divisor; i++) {
			divisor[i] = sc.nextInt();
		}
		
		// divisor 정렬
		int empty = 0;

		for (int i = 0; i < divisor.length-1; i++) {
			for (int j = i+1; j < divisor.length; j++) {
				if (divisor[j] < divisor[i]) {
					empty = divisor[i];
					divisor[i] = divisor[j];
					divisor[j] = empty;
				}
			}
		}
		
		int result = divisor[0] * divisor[divisor.length-1];
		System.out.println(result);
		
		sc.close();
	}
}
