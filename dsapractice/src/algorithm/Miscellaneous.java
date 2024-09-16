package algorithm;

public class Miscellaneous {

	public void print(int[] arr) {
		for(int ele:arr) {
			System.out.print(ele+" - ");
		}
		System.out.println();
	}
	
	private int[] squareSortedArr(int[] arr) {
		int n= arr.length-1;
		int[] res= new int[n+1];
		int i=0;
		int j = n;
		for(int k = n;k>=0;k--) {
			if(Math.abs(arr[i])> Math.abs(arr[j])) {
				res[k]=arr[i]*arr[i];
				i++;
			}else {
				res[k]=arr[j]*arr[j];
				j--;
			}
		}
		return res;
	}
	
	public int[] rearrangeAlternately(int[] arr) {
		int i=0; 
		int j =0;
		int k = arr.length-1;
		int[] res= new int[k+1];
		
		while(i<=k) {
			System.out.println("i is : "+i+" and k is : "+k);
			res[j]=arr[k];
			j++;k--;
			if(i<=k) {
			res[j]=arr[i];
			i++;j++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Miscellaneous obj = new Miscellaneous();
//		int[] arr= {-4,-1,0,3,10};
//		arr=obj.squareSortedArr(arr);
//		obj.print(arr);
		
		
		int[] arr= {1,2,3,4,5,6,7};
		arr=obj.rearrangeAlternately(arr);
		obj.print(arr);
		
	}

}
