package practice;

public class MaxSumSubArray { // find max sum in sub array using kadane's Algorithm
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {4,3,-2,6,-12,7,-1,6};
		int sum = findMaxSum(arr);
		System.out.println("The max element in sub array is : "+ sum);
	}

	private static int findMaxSum(int[] arr) {
		// TODO Auto-generated method stub
		int currMax = arr[0];
		int maxSoFar = arr[0];
		for(int i=1;i<arr.length;i++) {
			currMax = currMax+arr[i];
			if(currMax<arr[i]) {
				currMax=arr[i];
			}
			
			if(maxSoFar < currMax) {
				maxSoFar=currMax;
			}
		}
		return maxSoFar;
	}

}
