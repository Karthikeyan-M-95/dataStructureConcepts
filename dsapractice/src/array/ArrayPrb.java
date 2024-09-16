package array;

public class ArrayPrb {

	public void printarr(int[][] arr) {
		for(int i =0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[i][j]+" ");
			}
//			System.out.println();
		}
	}
	public void printarr(int[] arr) {
		
			for(int j=0;j<arr.length;j++) {
				System.out.print(arr[j]+" ");
			}
			System.out.println();
		
	}
	
	public int[] mergerSortedArr(int[] a, int[] b) {
		
		int[] arr =new int[a.length+b.length];
		int i=0;
		int j=0 , k =0;
		while(i<a.length && j<b.length) {
			if(a[i]<b[j]) {
				arr[k]=a[i];
				i++; k++;
			}else {
				arr[k]=b[j];
				j++;k++;
			}
			
		}
		while(i<a.length) {
					arr[k]=a[i];
					i++;k++;
			}	
			while(j<b.length) {
					arr[k]=b[j];
					j++;k++;
				}
			return arr;
	}
	
	public void printSpiral(int[][] arr , int r, int c) {
		int k=0;
		int l=0;
		
		while(k< r && l<c) {
			for(int i=l;i<r;i++) {
				System.out.print(arr[k][i]+" ");
			}
			k++;
			for(int i=k;i<r;i++) {
				System.out.print(arr[i][c-1]+" ");
			}
			c--;
			if(k<r) {
			for(int i=c-1;i>=l;i--) {
				System.out.print(arr[r-1][i]+" ");
				}
			}
			r--;
			if(l<c) {
			for(int i=r-1;i>=k;i--) {
				System.out.print(arr[i][l]+" ");
				}
			}
			l++;
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayPrb obj = new ArrayPrb();
		int[][]	arr = {
				{3,4,5,6},
				{12,15,17,19},
				{24,26,27,28},
				{31,33,35,37}
		};
		
		int a[]= {3,23,32,56,76,77};
		int b[]= {1,22,27,66};
//		System.out.println(arr.length);
//		obj.printarr(arr);
		System.out.println();
//		obj.printSpiral(arr,arr.length,arr.length);
		a=obj.mergerSortedArr(a, b);
		obj.printarr(a);
		
		

	}

}
