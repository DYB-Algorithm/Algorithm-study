import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N
        int K = sc.nextInt(); // K
        
        // 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
        int coins[] = new int[N+1];
        for (int i = 1; i <= N; i++) {
            coins[i] = sc.nextInt();
        }
        
        // K원을 만드는데 필요한 동전 개수의 최솟값을 계산한다.
        int sum = 0;
        for (int i = N; i > 0; i--) {
            sum = sum + (K / coins[i]);
            K = K % coins[i];
        }
        
        // 첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.
        System.out.println(sum);
        sc.close();
    }
}
