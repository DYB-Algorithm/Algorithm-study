import java.util.Scanner;

public class Q_1149 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int RGB[][] = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				RGB[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i < N; i++) {
			RGB[i][0] = Math.min(RGB[i-1][1], RGB[i-1][2]) + RGB[i][0];
			RGB[i][1] = Math.min(RGB[i-1][0], RGB[i-1][2]) + RGB[i][1];
			RGB[i][2] = Math.min(RGB[i-1][0], RGB[i-1][1]) + RGB[i][2];
		}
		
		System.out.println(Math.min(Math.min(RGB[N-1][0], RGB[N-1][1]), RGB[N-1][2]));
		
		sc.close();
	}
}
