package practice;
import java.util.Map;
import java.util.HashMap;

public class LongestSubStringNonRepeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str ="abcabcbb";
		longestSusString(str);

	}

	private static void longestSusString(String str) {
		// TODO Auto-generated method stub
		
		Map<Character,Integer> map = new HashMap<>();
		int maxLength=0;
		int start =0;
		for(int end=0;end<str.length();end++) {
			char rightchar= str.charAt(end);
			if(map.containsKey(rightchar)) {
				start=Math.max(end,map.get(rightchar)+1);
			}
			map.put(rightchar, end);
			maxLength= Math.max(maxLength, end-start+1);
		}
		System.out.println(maxLength);
	}

}
