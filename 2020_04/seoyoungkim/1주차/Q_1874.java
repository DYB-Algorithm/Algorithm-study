import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Q_1874 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int n[] = new int[N];
		
		for (int i = 0; i < N; i++) {
			n[i] = sc.nextInt();
 		}
		
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<String> push_pop = new ArrayList<String>(); // push는 +, pop은 -
		boolean no = true;
		
		int j;
		for (j = 1; j <= n[0]; j++) {
			stack.push(j);
			push_pop.add("+");
		}
		
		stack.pop();
		push_pop.add("-");
		
		for (int i = 1; i < N; i++) {
			if (n[i-1] < n[i] ) { // push
				while (n[i] >= j) {
					stack.push(j); 
					j++;
					push_pop.add("+");
				}
				stack.pop();
				push_pop.add("-");
			}
			else { // pop
				if (stack.pop() != n[i]) {
					no = false;
					break;
				}
				else {
					push_pop.add("-");
				}
			}
		}
		
		// 출력
		if (no == false) {
			System.out.println("NO");
		}
		else {
			for (int i = 0; i < push_pop.size(); i++) {
				System.out.println(push_pop.get(i));
			}	
		}
		
		sc.close();
	}
}
