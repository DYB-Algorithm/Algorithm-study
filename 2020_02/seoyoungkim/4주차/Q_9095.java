import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int n[] = new int[T];
		for (int i=0; i < T; i++) {
			n[i] = sc.nextInt();
		}
		
		for (int i=0; i < T; i++) {
			System.out.println(one_two_three_plus(n[i]));
		}
	}
	
	static int one_two_three_plus(int i) {
		
		if (i < 0) {
			return 0;
		} else if (i <= 1) {
			return 1;
		} else {
			return one_two_three_plus(i-1) + one_two_three_plus(i-2) + one_two_three_plus(i-3);
		}
	}
}
