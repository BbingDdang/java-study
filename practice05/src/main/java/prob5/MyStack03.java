package prob5;

import java.lang.reflect.Array;

public class MyStack03<T> {
	private int top;
	private T[] buffer;
	
	@SuppressWarnings("unchecked")
	public MyStack03(int capacity) {
		top = -1;
		buffer = (T[])new Object[capacity];
		buffer = (T[])Array.newInstance(getClass(), capacity);
	}
// 일케 변형도 가능	
//	public MyStack03(Class<?> klass, int capacity) {
//		top = -1;
//		buffer = (T[])new Object[capacity];
//		buffer = (T[])Array.newInstance(klass, capacity);
//	}
	public void push(T s) {
		if (top == buffer.length - 1) {
			resize();
		}
	
		buffer[++top] = s;
	}
	public T pop() throws MyStackException {
		return null;
		
	}
	
}
