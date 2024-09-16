package algorithm;



public class SortingAlgorithm {
	
	public void selectionSort(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n-1;i++) {
			
			int min=i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[min]) {
					min=j;
					
				}
			}
			int temp =arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
			
		}
		this.print(arr);
	}
	
	public int[] insertionSort(int[] arr) {
		int n = arr.length;
		
		for(int i=1;i<n;i++) {
			
			int temp= arr[i];
			int j=i-1;
			while(j>=0 && arr[j]>temp) {
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=temp;
		}
		this.print(arr);
		
		return arr;
	}
	
	public int[] bubbleSort(int[] arr) {
		int len= arr.length;
		boolean isSwapped;
//		
		for(int i=0;i<len-1;i++) {
			isSwapped=false;
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					isSwapped=true;
				}
			}
			if(isSwapped==false) {
				break;
			}
		}
		return arr;
	}
	
	public void print(int[] arr) {
		for(int x:arr) {
			System.out.print(x+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortingAlgorithm obj = new SortingAlgorithm();
		int[] arr= {12,42,1,3,5,322,56,77,87,84,34,54,0};
		obj.print(arr);
		obj.bubbleSort(arr);
		obj.print(arr);
		
	}

}
