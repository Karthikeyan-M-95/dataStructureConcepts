package practice;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class SlidingWindowMaximum {
	
	public static int maxSumSubArraySizeK(int[] arr, int len) {
		
		int sum=0;
		int maxSum=0;
		int start=0;
		for(int end =0;end<arr.length;end++) {
			sum=sum+arr[end];
			
			if(end>= len-1) {
				maxSum=Math.max(maxSum, sum);
				sum=sum-arr[start];
				start++;
			}			
		}
		return maxSum;
		
	}
	
	public static int[] nextGreaterElement(int[]arr) {
		
		int[] res= new int[arr.length];
		Stack<Integer> stk = new Stack();
		
		for(int i=arr.length-1;i>=0;i--) {
			
			if(!stk.isEmpty()) {
				while(!stk.isEmpty() && arr[i]>= arr[stk.peek()]) {
					stk.pop();
				}
			}
			
			if(stk.isEmpty()) {
				res[i]=arr.length;
			}else {
				res[i]=stk.peek();
			}
			
			stk.push(i);
		}
		
		return res;
	}
	
	public static List<Integer> slidingWindow(int[] arr, int window) {
		int[] gre= nextGreaterElement(arr);
		ArrayList<Integer> res =new ArrayList<>();
		
		for(int i=0;i<=arr.length-window;i++) {
			int j=i;
			while(gre[j]<i+window) {
				j=gre[j];
			}
			res.add(arr[j]);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[] arr= {44,77,33,44,88,11};
//		System.out.println(slidingWindow(arr,3));
		LocalDateTime now = LocalDateTime.now();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yy HH:MM:SS");
		Date d1 = new Date();
		System.out.println(formatter.format(d1));
		int[] arr= {2,7,3,5,8,1};
	
		System.out.println();
		System.out.println(formatter.format(new Date()));
		System.out.println(maxSumSubArraySizeK(arr, 2));
	}

}
