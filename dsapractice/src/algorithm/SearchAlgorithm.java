package algorithm;

public class SearchAlgorithm {
	
	public int linearSearch(int[] arr, int key) {
		for(int x:arr) {
			if(x==key)
				return x;
		}
		return -1;
	}
	
	public int binarySearch(int[] arr, int key) {
		int low=0;
		int high = arr.length-1;
		while(low<=high) {
			int mid = low+(high-low)/2;
			if(arr[mid]==key)
				return arr[mid];
			if(key>arr[mid])
				low=mid+1;
			else
				high=mid-1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		SearchAlgorithm obj = new SearchAlgorithm();
		int[] arr= {2,3,5,6,12,23,34,56,75};
		System.out.println(obj.linearSearch(arr, 15));
	}
}
