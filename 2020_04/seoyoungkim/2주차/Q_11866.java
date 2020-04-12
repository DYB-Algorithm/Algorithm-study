import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Q_11866 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while (!queue.isEmpty()) {
			for (int i = 1; i < K; i++) {
				queue.add(queue.poll());
			}
			queue2.add(queue.poll());
		}
		
		// 출력
		System.out.print("<");
		while (queue2.size() != 1) {
			System.out.print(queue2.poll());
			System.out.print(", ");
		}
		
		System.out.print(queue2.poll() + ">");
		
		sc.close();
	}
}
