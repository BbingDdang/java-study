package prob5;

public class MyStack {
	private String[] stack;
	private int idx;
	public MyStack(int i) throws MyStackException {
		stack = new String[i];
		idx = -1;
		
		
	}
	
	public void resize() {
		String[] temp = new String[stack.length * 2];
		for (int i = 0; i < stack.length; i++) {
			temp[i] = stack[i];
		}
		stack = temp;
	}
	
	public void push(String string) {
		if (idx == stack.length  - 1) {
			resize();
		}
		stack[++idx] = string;
	}

	public boolean isEmpty() {
		if (idx < 0) {
			return true;
		}
		return false;
	}

	public String pop() throws MyStackException {	
		if (isEmpty() == true) {
			throw new MyStackException();
		}
		else {
			String result;
			result = stack[idx];
			stack[idx--] = null;
		
			
			return result;
		}
		
	}
}