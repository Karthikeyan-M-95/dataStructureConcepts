package practice;

public class HashTable {
	
	HashNode[] bucket;
	int numOfBucket;
	int cap;
	
	HashTable(){
		this(10);
	}
	
	HashTable(int capacity){
		this.numOfBucket = capacity;
		this.cap = 0;
		bucket = new HashNode[capacity];
	}
	
	
	
	private class HashNode{
		
		private int index;
		private String value;
		private HashNode next;
		
		HashNode(int key, String value){
			this.value = value;
			this.next = null;
			this.index = key;
			
		}
	}

	public boolean isEmpty() {
		return cap==0;
	}
	
	public int size() {
		return cap;
	}
	
	private void print() {
		
		for(int i =0;i<numOfBucket;i++) {
			HashNode node = bucket[i];
			System.out.print("The bucket Index is : "+ i);
			if(node != null) {
				printNodeList( node);
			}
			System.out.println();
		}
		
	}

	private void printNodeList(HashNode node) {
		// TODO Auto-generated method stub
		while(node!=null) {
			System.out.print(" : "+node.value+" ");
			node=node.next;
		}
		
	}
	
	public void insert(Integer key, String value) {
		int index = getBucketIndex(key);
		HashNode head = bucket[index];
		while(head!=null) {
			if((head.index)==(key)) {
				head.value=value;
				return;
			}
			head=head.next;
			
		}
		head = bucket[index];
		HashNode node = new HashNode(key,value);
		node.next=head;
		bucket[index]=node;
		cap++;
		
	}
	
	public String get(Integer key) {
		if(key==null)
			throw new IllegalArgumentException("Invalid Key");
		int index = getBucketIndex(key);
		HashNode head = bucket[index];
		while(head != null) {
			if(head.index==key) {
				return head.value;
			}
			head=head.next;
		}
		return null;
	}
	
	public String removeKey(Integer key) {
		int index = getBucketIndex(key);
		HashNode node = bucket[index];
		HashNode prev=null;
		if(node == null)
			throw new IllegalArgumentException("No Element present");
		
		while(node != null) {
			if((node.index)==(key)) {
				break;
			}
			prev = node;
			node= node.next;
		}
		
		if(node == null)
			return null;
		
		cap--;
		if(prev != null) {
			prev.next=node.next;
		}else {
			bucket[index]= node.next;
		}
		return node.value;
	}
	
	private int getBucketIndex(Integer key) {
		// TODO Auto-generated method stub
		return key % numOfBucket;
	}

	public static void main(String[] args) {
		HashTable ht = new HashTable();
		ht.insert(105, "Karthik");
		ht.insert(114, "Wick");
//		System.out.println(ht.length());

		ht.insert(134, "Trigger");
		ht.insert(105, "Nick");
		ht.print();
		System.out.println(ht.get(114));
		ht.removeKey(114);
		ht.removeKey(105);
		ht.print();
		
//		System.out.println(ht.getKey(114));
//		System.out.println(ht.deleteKey(114));
//		ht.printEle();

	}



}
