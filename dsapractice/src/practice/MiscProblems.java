package practice;

import java.util.HashSet;
import java.util.Set;

public class MiscProblems {

	public void findDuplicate(int[] arr) { // find duplicate elements in array using for loop -o(n2)
		boolean dupl=false;
		Integer ele=null;
		for(int i=0;i<arr.length;i++) {
			dupl=false;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
					dupl=true;
					ele = arr[i];
				}
					
			}
			if(dupl==true) {
				System.out.println("Array has duplicate elements : "+ele);
				return;
			}
			
		}
	}
	
	public boolean findDup(int[] arr) {  // find duplicate elements in array using HashSet in o(1) 
		Set<Integer> set = new HashSet<>();
		for(int x: arr) {
			if(set.contains(x))
				return true;
			
			set.add(x);
		}
		
		return false;
	}
	
	public void sort(int[] arr) { // Duplicate can also be found by sorting the array and then comparing n & n+1 elements - o(nlog n)
		
		for(int i=1;i<arr.length;i++) {
			int j = i-1;
			int temp = arr[i];
			while(j>=0 && arr[j]>temp) {
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=temp;
		}
	}
	
	public void print(int[] arr) {
		for(int x : arr) {
			System.out.print(x+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,6,7,8 ,10,14,15,3,16,17,18,19,21,2};
		
		MiscProblems m= new MiscProblems();
		m.sort(arr);
		m.print(arr);
		
//		m.findDuplicate(arr);
		System.out.println(m.findDup(arr));
		
	}

}
