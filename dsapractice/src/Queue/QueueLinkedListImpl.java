package Queue;

public class QueueLinkedListImpl {
	
	private Node front;
	private Node rear;
	private int length;
	
	public QueueLinkedListImpl() {
		front=rear=null;
		this.length=0;
	}

	private class Node{
		
		private int data;
		private Node next;
		
		Node(int val){
			this.data=val;
			this.next=null;
		}
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public int size() {
		return length;
	}
	
	public void enqueue(int val) {
		Node node= new Node(val);
		if(this.front==null) {
			front=rear=node;
		}
		else {
			rear.next=node;
			rear=node;
		}
		length++;
	}
	
	public int dequeue() {
		
		if(isEmpty())
			throw new IllegalArgumentException("Empty Queue");
		else {
			Node temp= front;
			front=front.next;
			temp.next=null;
			length--;
			return temp.data;
		}
	}
	
	public void print() {
		Node temp = front;
		while(temp!=null) {
			System.out.print(" - "+temp.data);
			temp=temp.next;
			
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		QueueLinkedListImpl q = new QueueLinkedListImpl();
		q.enqueue(10);
		q.enqueue(15);
		q.enqueue(18);
		q.enqueue(23);
		q.enqueue(25);
		q.enqueue(35);
		System.out.println(q.isEmpty());
		System.out.println(q.dequeue());
		q.print();
		System.out.println(q.size());
	}
}
