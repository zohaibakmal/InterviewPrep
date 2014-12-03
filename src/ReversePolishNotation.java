import java.util.Stack;


public class ReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack <Integer> stack = new Stack<Integer>();
		for (int i=0;i<tokens.length;i++){
			switch(tokens[i]){

			case "*":{
				int v1 = stack.pop();
				int v2 = stack.pop();
				int v3 = v2*v1;
				stack.push(v3);
				break;
			}
			case "-":{
				int v1 = stack.pop();
				int v2 = stack.pop();
				int v3 = v2-v1;
				stack.push(v3);
				break;
			}
			case "+":{
				int v1 = stack.pop();
				int v2 = stack.pop();
				int v3 = v2+v1;
				stack.push(v3);
				break;
			}
			case "/":{
				int v1 = stack.pop();
				int v2 = stack.pop();
				int v3 = v2/v1;
				stack.push(v3);
				break;
			}
			default:
				stack.push(Integer.parseInt(tokens[i]));
				break;
			}
		}

		return stack.pop();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
