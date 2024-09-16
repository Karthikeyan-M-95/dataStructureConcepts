package hashTable;

public class HashTable {

	private int numOfBuckets; // total size of the table
	private int size; // number of hash elements present in the table;
	private HashNode[] buckets;
	
	
	public HashTable() {
		this(10);
	}
	
	public HashTable(int capacity) {
		numOfBuckets=capacity;
		size=0;
		buckets= new HashNode[capacity];
	}
	
	private class HashNode{
		
		private Integer key;
		private String value;
		private HashNode next;
		
		HashNode(Integer val, String value){
			this.key=val;
			this.value = value;
		}
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public int length() {
		return size;
	}
	
	public int getBucketIndex(Integer key) {
		return key%numOfBuckets;
	}
	
	public void addEle(Integer key, String value) {
		if(key==null || value == null) 
			throw new IllegalArgumentException("Key or Value is null");
		
		int bucketIndex = getBucketIndex(key);
		HashNode head =buckets[bucketIndex];
		while(head!= null) {
			if(head.key.equals(key)) {
				head.value=value;
				return;
			}
			head= head.next;
		}
		size++;
		head = buckets[bucketIndex];
		HashNode node= new HashNode(key, value);
		node.next = head; // we are trying to make the new element as first element in the series
		buckets[bucketIndex]= node;
	}
	
	public String getKey(int key) {
		
		int index= getBucketIndex(key);
		HashNode node = buckets[index];
		while(node!= null) {
			if(node.key.equals(key)) {
				return node.value;
			}
			node = node.next;
			
		}
		return null;
	}
	
	public void printEle() {
		for(int i=0;i<numOfBuckets;i++) {
			System.out.print(i+" : ");
			HashNode head= buckets[i];
			
			while(head!= null) {
				System.out.print(head.value+" - ");
				head=head.next;
			}
			System.out.println(head+" - ");
		}
	}
	
	public String deleteKey(int key) {
		int index = getBucketIndex(key);
		HashNode head = buckets[index];
		HashNode prev = null;
		
		while(head!= null) {
			if(head.key.equals(key)) {
				break;
			}
			prev=head;
			head=head.next;
		}
		if(head ==  null) {
			return null;
		}
		
		size--;
		if(prev !=null) {
			prev.next=head.next;
		}else {
			buckets[index]=head.next;
		}
		return head.value;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashTable ht = new HashTable();
		ht.addEle(105, "Karthik");
		ht.addEle(114, "Wick");
//		System.out.println(ht.length());
		ht.addEle(134, "Trigger");
		ht.printEle();
		ht.addEle(105, "Nick");
		System.out.println(ht.getKey(114));
		System.out.println(ht.deleteKey(114));
		ht.printEle();
	}

}
