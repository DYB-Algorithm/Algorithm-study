import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Q_10866 {
	static Deque<Integer> deque = new LinkedList<Integer>();
	static ArrayList<Integer>result = new ArrayList<Integer>(); // 결과 출력을 위한 변수
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int N = Integer.parseInt(br.readLine()); // 테스트케이스
			
			String[] cmd = new String[N];
			for (int i = 0; i < N; i++) {
				cmd[i] = br.readLine();
				command(cmd[i]);
			}
			br.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	static void command(String cmd) {
		String[] str = cmd.split(" ");
		switch (str[0]) {
			case "push_front":
				deque.addFirst(Integer.parseInt(str[1]));
				break;
			case "push_back":
				deque.addLast(Integer.parseInt(str[1]));
				break;
			case "pop_front":
				if (deque.isEmpty())
					result.add(-1);
				else
					result.add(deque.pollFirst());
				break;
			case "pop_back":
				if (deque.isEmpty())
					result.add(-1);
				else
					result.add(deque.pollLast());
				break;
			case "size":
				result.add(deque.size());
				break;
			case "empty":
				if (deque.isEmpty())
					result.add(1);
				else
					result.add(0);
				break;
			case "front":
				if (deque.isEmpty())
					result.add(-1);
				else
					result.add(deque.peekFirst());
				break;
			case "back":
				if (deque.isEmpty())
					result.add(-1);
				else
					result.add(deque.peekLast());
				break;
		}
	}
}
