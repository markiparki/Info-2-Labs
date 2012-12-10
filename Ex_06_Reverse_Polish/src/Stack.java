
/**
 * Ex06
 * @author jw & ma
 * @since 19.11.2012
 */
public class Stack<T> {
	private Node<T> top;
	
	public Stack() {
	}
	
	/**
	 * Fügt ein neues Element dem Stack hinzu.
	 */
	public void push(T o) {
		//Wenn noch nichts im Stack, gebe leerem Stackelement einen Inhalt
		if(top == null) {
			top = new Node<T>();
			top.setValue(o);
		}else {
			//Erstelle neues Stackelement
			Node<T> newNode = new Node<T>();
			//Binde neues Stackelement ein
			newNode.next = top;
			top = newNode;
			//Füge Inhalt in Stackelement
			top.setValue(o);
		}
	}
	
	/**
	 * Gibt Inhalt des obersten Elements im Stack und entfernt es.
	 */
	public Object pop() throws Exception {
		//Wenn Stack leer
		if(top == null) {
			throw new Exception("UnderflowException");
		}
		//Speichere oberstes Stackelement
		Node<T> removedNode = top;
		//Entferne das Element
		top = top.next;
		//Gib den Inhalt des gespeicherten obersten Elements zurück
		return removedNode.getValue();
	}
	
	/**
	 * Gibt oberstes Element im Stack zurück ohne es zu entfernen.
	 */
	public T top() throws Exception {
		//Wenn Stack leer
		if(top == null) {
			throw new Exception("UnderflowException");
		}
		//Gebe Inhalt des obersten Elements zurück
		return top.getValue();
	}
	
	/**
	 * Gibt zurück ob der Stack leer ist.
	 */
	public boolean empty() {
		return (top == null);
	}
	
	/**
	 * Gibt den Inhalt des Stacks zurück.
	 */
	public String toString() {
		Node<T> current = top;
		String text = "Your stack contains of ";
		//So lange noch ein Element vorhanden ist
		while(current != null) {
			//Füge den Inhalt des Elements zum String hinzu
			text += current.getValue() + " ";
			//Wähle das nächste Element aus
			current = current.next;
		}
		return text;
	}
}
