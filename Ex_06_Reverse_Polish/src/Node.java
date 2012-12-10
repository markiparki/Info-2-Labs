
public class Node<T> {
	public Node<T> next;
	private T o;
	
	public T getValue() {
		return o;
	}
	
	public void setValue(T o) {
		this.o = o;
	}
}