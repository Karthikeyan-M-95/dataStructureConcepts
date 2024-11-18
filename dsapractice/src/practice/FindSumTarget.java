package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindSumTarget {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,11,5,10,7,8};
		int[] res= findSumByTarget2(arr,9);
		print(res);
	}

	private static void print(int[] res) {
		// TODO Auto-generated method stub
		System.out.print("The index of element that lead to target are : ");
		for(int x :res) {
			System.out.print(x+" ");
		}
		System.out.println();
	}

	private static int[] findSumByTarget(int[] arr, int target) {
		// TODO Auto-generated method stub
		int[] res= new int[2];
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(!map.containsKey(target - arr[i])) {
				map.put(arr[i],i);
			}else {
				res[1]=i;
				res[0]= (int) map.get(target-arr[i]);
				return res;
			}
		}
		return res;
	}
	
	public static int[] findSumByTarget2(int[] arr, int target) {
		
		int res[]=new int[2];
		Arrays.sort(arr);
		int i=0,j =arr.length-1;
		while(i<j) {
			int sum = arr[i]+arr[j];
			if(sum==target) {
				res[0]=i;
				res[1]=j;
				return res;
			}
			else if(sum>target)
				j--;
			else if(sum<target)
				i++;
		}
		return res;	
	}

}
