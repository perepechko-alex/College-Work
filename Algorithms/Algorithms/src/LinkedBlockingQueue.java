
public class LinkedBlockingQueue {
	private Node front;
	private Node rear;
	private int queueSize;
	
	public LinkedBlockingQueue(){
		front = null;
		rear = null;
		queueSize = 0;
	}
	
	public void add(Object obj){
		Node newNode = new Node(obj, null);
		if(front == null){
			front = newNode;
			rear = newNode;
		}
		else {
			rear.next = newNode;
			rear = newNode;
		}
		queueSize++;
	}
	
	
	public void remove(){
		front = front.next;
		if(front == null){
			rear = null;
		}
		queueSize--;
	}
	
	
	public void emptyTheQueue(){
		front = null;
		rear = null;
		queueSize = 0;
	}
	

	public Object front() {
		return front.element;
	}


	public boolean isEmpty() {
		return queueSize == 0;
	}


	public int size() {
		return queueSize;
	}


	public String toString() {
		String str = "";
		Node temp = front;
		while(temp != null) {
			str += temp.element + "\n";
			temp = temp.next;
		}
		return str;
	}	

	
	private class Node {
		private Object element;
		private Node next;
		
		private Node(Object elem, Node nextNode){
			element = elem;
			next = nextNode;
		}
	}
}
