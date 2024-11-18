package practice;

import java.util.Arrays;

public class Miscellaneous2 {
	
	public static void findProduct(int[] arr) { // Product of array except self
		int[] res = new int[arr.length];
		int temp=1;
		for(int i=0;i<arr.length;i++) {
			res[i]=temp;
			temp=temp*arr[i];
		}
		
		temp=1;
		for(int i=arr.length-1;i>=0;i--) {
			res[i]=res[i]*temp;
			temp=temp*arr[i];
		}
		
		for(int x:res) {
			System.out.print(x+" ");
		}
	}
	
	public static void threeSum(int[] arr, int target) { // find 3 elements which adds up to the target provided
		for(int i=0;i<arr.length-2;i++) {
			Arrays.sort(arr);
			int j =i+1;
			int k = arr.length-1;
			while(j<k ) {
				int sum = arr[i]+arr[j]+arr[k];
				if(sum == target) {
					System.out.println("the index are : "+arr[i]+" "+arr[j]+" "+arr[k]);
					k--;j++;
				}
				else if(sum>target) {
					k--;
				}else {
					j++;
				}
			}
		}
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[] arr = {2,4,3,7,1,8,9,0};
//		threeSum(arr,10);
		
//		int[] arr= {1,2,3,4};
		int[] arr= {-1,1,0,-3,3};
		findProduct(arr);
	}

}
