package practice;

public class SubSequence {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str ="abcde";
		String seq ="aec";
		
		boolean isSeq = isSubSequence(str,seq);
		System.out.println(isSeq);

	}

	private static boolean isSubSequence(String str, String seq) {
		// TODO Auto-generated method stub
		int i=0,j=0;
		while(i<str.length()&& j<seq.length()) {
			if(str.charAt(i)==seq.charAt(j)) {
				j++;
			}
			i++;
		}
		return j==seq.length();
		
	}

}
