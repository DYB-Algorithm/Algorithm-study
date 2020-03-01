import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        // 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
        int number[] = new int[N];
        
        for (int i = 0; i < N; i++) {
            number[i] = sc.nextInt();
        }
        
        insertsort(number);
    
    }
    
    static void insertsort(int[] i) {
        int empty = 0;
        
        for (int m = 0; m < i.length-1; m++) {
            for (int n = m+1; n < i.length; n++) {
                if (i[n] < i[m]) {
                    empty = i[n];
                    i[n] = i[m];
                    i[m] = empty;
                }
            }
        }
        
        for (int n = 0; n < i.length; n++) {
            System.out.println(i[n]);
        }
    }
}
