package algorithm;

public class MergeSort {
	
	public void print(int[] arr) {
		for(int ele:arr) {
			System.out.print(ele+" - ");
		}
		System.out.println();
	}
	
	public void merge(int[] arr, int[] temp, int low, int mid, int high) {
//		System.out.println("low is : "+low +" mid is : "+mid+" high is : "+high);
		for(int i=low;i<=high;i++) {
			temp[i]=arr[i];
		}
		
		int i=low; // traverse left sorted subarray
		int j=mid+1; // traverse right sorted subarray
		int k=low; // will merge both arrays into original array (arr)
		while(i<= mid && j<=high) {
			if(temp[i]<=temp[j]) {
				arr[k]=temp[i];
				i++;
			}else {
				arr[k]=temp[j];
				j++;
			}
			k++;
		}
		while(i<=mid) {
			arr[k]=temp[i];
			i++;k++;
		}
	}
	
	public void sort(int[] arr, int[] temp, int low, int high) {
		if(low<high) {
			int mid=low+(high-low)/2; // overflow condition (low+high)/2  
			sort(arr,temp,low,mid);
			sort(arr,temp,mid+1,high);
			merge(arr,temp,low,mid,high);
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSort obj = new MergeSort();
		int[] arr= {12,42,1,3,5,322,56,77,87,84,34,54,0};
		int[] temp=new int[arr.length];
		obj.sort(arr, temp, 0, arr.length-1);
		obj.print(arr);
	}

}
