package practice;
import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "codeforcodefr";
		int index = getFirstNonRepeatingIndex(str);
		System.out.println(index);

	}

	private static int getFirstNonRepeatingIndex(String str) {
		// TODO Auto-generated method stub
		char[] arr = str.toCharArray();
		Map<Character,Integer> map = new HashMap();
		for(char x:arr) {
			map.put(x, map.getOrDefault(x, 0)+ 1 );
		}
		
		for(int i=0;i<=map.size();i++) {

			if(map.get(arr[i])==1) {
				System.out.println("The first non repeating element is : "+arr[i]);
				return i;
			}
				
		}
		System.out.println("No elements present");
		return -1;
		
	}

}
