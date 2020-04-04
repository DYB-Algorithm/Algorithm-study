import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Q_4949 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str, str_split[];
		String result;
		Stack<Character> stack;
		
		ArrayList<String> result_list = new ArrayList<String>();
		
		while(true) {
			str = sc.nextLine();
			
			if (str.equals("."))
				break;
			
			str_split = str.split("");
			
			stack = new Stack<Character>();
	
			result = "yes";
			for (int i = 0; i < str_split.length; i++) {
				if (str_split[i].equals("(")) {
					stack.add('(');
				}
				else if (str_split[i].equals(")")) {
					if (!stack.isEmpty() && stack.pop().equals('('))
						result = "yes";
					else {
						result = "no";
						break;
					}
				}
				else if (str_split[i].equals("[")) {
					stack.add('[');
				}
				else if (str_split[i].equals("]")) {
					if (!stack.isEmpty() && stack.pop().equals('['))
						result = "yes";
					else {
						result = "no";
						break;
					}
				}
			}
			
			if (result != "no" && stack.isEmpty())
				result = "yes";
			else
				result = "no";
			
			result_list.add(result);
			
		}
		
		for (int i = 0; i < result_list.size(); i++) {
			System.out.println(result_list.get(i));
		}
		
		sc.close();
	}
}
