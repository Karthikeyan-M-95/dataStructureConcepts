package practice;

import java.util.Set;

public class RemoveIntegers {
	
	public static String removeVowels(String str) {
		char[] arr= str.toCharArray();
		Set<Character> set= Set.of('a','e','i','o','u');
		StringBuilder sb = new StringBuilder();
		for(char ch : arr) {
			if(!set.contains(ch)) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	public static long reverseNumber(int val) {
		
		boolean isNeg=false;
		if(val < 0) {
			isNeg=true;
			val = val*-1;
		}
		long res=0;
		int mod=0;
		
		while(val>0) {
			mod = val%10;
			val = val/10;
			res =res*10+mod;
		}
		
		return isNeg ? res*-1 : res;
	}
	
	public static int removeOccurence(int[] arr, int val){ // find the no. of unique values in an array and seperate them
		int i=0,j=arr.length-1;
		while(i<=j) {
			if(arr[j]==val) {
				
				j--;
			}
		 if(arr[i]==val) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j]=temp;
				j--;
			}
			i++;
		}
		for(int x:arr) {
			System.out.print(x+" ");
		}
		System.out.println("\n");
		return i;
	}

	
	public static int removeDuplicate(int[] arr) { // Remove Duplicate Occurence in a sorted array and return total unique values
		int i=1;
		for(int j=1;j<arr.length;j++) {
			if(arr[j]!= arr[j-1]) {
				arr[i]=arr[j];
				i++;
			}
		}
		for(int x:arr) {
			System.out.print(x+" ");
		}
		System.out.println();
		return i;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ice cream";
//		System.out.println(removeVowels(str));
		
//		System.out.println(reverseNumber(2147483647));
		
//		int[] arr= {0,1,2,2,3,0,4,2};
//		System.out.println(removeOccurence(arr, 2));
		

		int[] arr= {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicate(arr));
//		for(int x:res) {
//			System.out.print(x+" ");
//		}
		
//		System.out.println(removeDuplicate(arr)); 

	}

}
