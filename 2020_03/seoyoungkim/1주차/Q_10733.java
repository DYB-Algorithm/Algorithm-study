import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		
		// 첫 번째 줄에 정수 K가 주어진다. (1 ≤ K ≤ 100,000)
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		
		// 이후 K개의 줄에 정수가 1개씩 주어진다. 
		int number[] = new int[K];
		
		for (int i = 0; i < K; i++) {
			number[i] = sc.nextInt();
		}
		
		// 정수는 0에서 1,000,000 사이의 값을 가지며, 
		// 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < K; i++) {
			if (number[i] == 0)
				stack.pop();
			else
				stack.push(number[i]);
		}
		
		// 최종적으로 적어 낸 수의 합을 출력한다. 최종적으로 적어낸 수의 합은 2^31-1보다 작거나 같은 정수이다.
		int size = stack.size();
		int sum = 0;
		
		// TODO 이해가 가지 않는다. 위에 stack.size()로 받으면 맞는데 
		// for문 안에서 stack.size()하면 다른 값이 리턴되는지,,
		
		for (int i = 0; i < size; i++) {
			sum = sum + stack.pop();
			System.out.println(stack.size());
		}
		
		System.out.println(sum);
		
		sc.close();
	}
}
