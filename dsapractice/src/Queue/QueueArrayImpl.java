package Queue;

public class QueueArrayImpl {

	private int[] qarr;
	private int head;
	private int tail;
	private int size;
	
	QueueArrayImpl(int cap){
		qarr= new int[cap];
		head=0;
		tail=-1;
		size=0;
		
	}
	
	QueueArrayImpl(){
		this(5);
	}
	
	public int[] resize(int[] arr, int cap) {
		int[] copy= new int[cap];
		for(int i=0;i<arr.length;i++) {
			copy[i]=arr[i];
		}
		
		return copy;
		
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isFull() {
		return tail==qarr.length-1;
	}
	
	public void enqueue(int val) {
		if(this.isFull())
			qarr=this.resize(qarr, qarr.length*2);
		
		tail++;
		qarr[tail]=val;
		size++;

	}
	
	public int dequeue() {
		if(isEmpty()) {
			this.head=0;
			this.tail=-1;
			throw  new IllegalArgumentException("Empty Stack");
		}
			
		
		int res = qarr[head];
		qarr[head]=0;
		head++;
		size--;
		return res;
	}
	
	public void print() {
		for(int ele:qarr) {
			System.out.print(ele+" - ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		QueueArrayImpl q = new QueueArrayImpl();
		q.enqueue(3);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(24);
		q.enqueue(49);
		q.print();
		System.out.println(q.size());
//		System.out.println(q.qarr.length);
		System.out.println(q.isFull());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
//		System.out.println(q.dequeue());
		q.print();
		System.out.println(q.head+" "+q.tail);
	}
}
