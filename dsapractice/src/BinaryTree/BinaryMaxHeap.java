package BinaryTree;

import java.util.PriorityQueue;

/**
 * Priority Queue is a DS that allows us to find max/min element among a collection in unit time.
 * it supports operations such as - insert(key) / deleteMax()/deleteMin()/getMax()/getMin
 * 
 * Binary Heap is a DS that helps in implementing Priority Queue operation efficiently. 
 * 
 * 
 * *
 */
public class BinaryMaxHeap {
	
	Integer[] heap;
	int n;
	
		public BinaryMaxHeap(int cap) {
			heap = new Integer[cap+1];
			n=0;
		}
		
		public boolean isEmpty() {
			return n==0;
		}
		
		public int size() {
			return n;
		}
		
		public void print() {
			for(int i=1;i<heap.length;i++) {
				System.out.print(heap[i]+" ");
			}
			System.out.println();
		}
		
		public void insert(int x) {
			if(n== heap.length-1) {
				heap=resize(2*heap.length);
			}
			n++;
			heap[n]=x;
			swim(n);
		}
		
		public int deleteMax() {
			int max = heap[1];
			swap(1,n);
			n--;
			sink(1);
			heap[n+1]=null;
			if(n>0 && (n ==((heap.length-1)/4))) {
				resize(heap.length/2);
			}
			return max;
		}
		
		private void sink(int k) {
			// TODO Auto-generated method stub
			while(2*k<=n) {
				int j =2*k;
				if(j<n && heap[j]<heap[j+1])
					j++;
				if(heap[k]>= heap[j])
					break;
				swap(j,k);
				k=j;
			}
			
		}

		private void swap(int i, int n2) {
			int temp = heap[i];
			heap[i]=heap[n2];
			heap[n2]=temp;
		}

		private void swim(int k) {
			while(k>1 && heap[k ]>heap[k/2]	) {
				int temp = heap[k];
				heap[k]= heap[k/2];
				heap[k/2]= temp;
				k=k/2;
			}
		}

		private Integer[] resize(int j) {
				Integer[] arr = new Integer[j];
				for(int i=0;i< heap.length;i++) {
					arr[i]=heap[i];
				}
			return arr;
			}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryMaxHeap heap = new BinaryMaxHeap(5);
		System.out.println(heap.size());
		System.out.println(heap.isEmpty());
		heap.insert(12);
		heap.insert(20);
		heap.insert(30);
		heap.insert(10);
		heap.insert(15);
		heap.print();
		System.out.println(heap.deleteMax());
		heap.print();
		
	}

}
