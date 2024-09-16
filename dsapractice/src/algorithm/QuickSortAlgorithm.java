package algorithm;

public class QuickSortAlgorithm {

	public void print(int[] arr) {
		for(int ele:arr) {
			System.out.print(ele+" - ");
		}
		System.out.println();
	}
	
	private void sort(int[] arr, int low, int high) {
		if(low<high) {
			int pos = quickSort( arr, low, high);
			sort(arr,low, pos-1);
			sort(arr,pos+1,high);
		}
	}
	
	private int quickSort(int[] arr, int low, int high) {
		int i=low,j=low;
		int pivot = arr[high];
		while(low<high) {
			if(arr[i]<pivot) {
				int temp = arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
				j++;
			}
			i++;
		}
		return j-1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuickSortAlgorithm obj = new QuickSortAlgorithm();
		int[] arr= {12,42,1,3,5,322,56,77,87,84,34,54,0};
		obj.print(arr);
		obj.sort(arr, 0, arr.length-1);
		obj.print(arr);
	}

}
