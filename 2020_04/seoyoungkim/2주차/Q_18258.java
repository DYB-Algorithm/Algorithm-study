import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_18258 {
	
	static Queue<Integer> queue = new LinkedList<Integer>();
	static ArrayList<Integer> result = new ArrayList<Integer>();
	
	static int rear; // back을 위한 변수
	
	public static void main(String[] args) {
		try {
			
			// 시간초과 때문에 버퍼 사용
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

			int N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				command(br.readLine());
			}
			
			br.close();
			
			// 출력
			for (int i = 0; i < result.size(); i++) {
				bw.write(result.get(i)+"\n");
			}
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	public static void command(String cmd) {
		// split 시간초과 때문에 StringTokenizer 사용
		StringTokenizer st = new StringTokenizer(cmd); 
		
		switch (st.nextToken()) {
			case "push":
				String st_number = st.nextToken();
				queue.add(Integer.parseInt(st_number));
				rear = Integer.parseInt(st_number);
				break;
			case "pop":
				if (!queue.isEmpty())
					result.add(queue.poll());
				else
					result.add(-1);
				break;
			case "size":
				result.add(queue.size());
				break;
			case "empty":
				if (!queue.isEmpty())
					result.add(0);
				else
					result.add(1);
				break;
			case "front":
				if (!queue.isEmpty())
					result.add(queue.peek());
				else
					result.add(-1);
				break;
			case "back":
				if (!queue.isEmpty())
					result.add(rear);
				else
					result.add(-1);
				break;
		}	
	}
}
