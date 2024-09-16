package algorithm;

public class DutchNationalFlag {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {0,0,1,2,0,1,2};
		DutchNationalFlag obj = new DutchNationalFlag();
		obj.sort(arr);
		obj.print(arr);
	}

	private void print(int[] arr) {
		for(int ele:arr) {
			System.out.print(ele+" - ");
		}
		System.out.println();
	}

	private void sort(int[] arr) {
		
		int i=0;
		int j=0;
		int k=arr.length-1;
		while(i<=k) {
			if(arr[i]==0) {
				swap(arr,i,j);
				i++;j++;
			}
			else if(arr[i]==1) {
				i++;
			}
			else if(arr[i]==2) {
				swap(arr,i,k);
				k--;
			}
			
		}
		
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}

}
