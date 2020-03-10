import java.util.Scanner;
import java.util.Stack;

public class Q_9012 {
	public static void main(String[] args) {
		
		// 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다. 
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		// 각 테스트 데이터의 첫째 줄에는 괄호 문자열(PS)이 한 줄에 주어진다. 하나의 괄호 문자열의 길이는 2 이상 50 이하이다. 
		String PS[] = new String[T];
		
		for (int i = 0; i < T; i++) {
			PS[i] = sc.next();
		}
		
		char c;
		String answer[] = new String[T]; // YES 혹은 NO를 받을 변수
		for (int i = 0; i < T; i++) {
			Stack<Character> stack = new Stack<>();
			for (int j = 0; j < PS[i].length(); j++ ) {
				c = PS[i].charAt(j);
				
				if (c == '(') {
					stack.push(c);
				} else if (c == ')') {
					if (!stack.isEmpty())
						stack.pop();
					else
						answer[i] = "NO";
				}
			}
			
			if (stack.size() == 0 && answer[i] != "NO")
				answer[i] = "YES";
			else
				answer[i] = "NO";
		}
		
		for (int i = 0; i < T; i++) {
			System.out.println(answer[i]);
		}
		
		sc.close();
	}
}
