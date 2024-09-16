package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueProblems {

	public String[] findBinaryNum(int n	) {
		
		Queue<String> q = new LinkedList<>();
		String[] str= new String[n];
		q.offer("1"); 
		for(int i=0;i<n;i++) {
			str[i]=q.poll();
			String n1 = str[i]+0;
			String n2 = str[i]+1;
			q.offer(n1);
			q.offer(n2);
			
		}
		return str;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueueProblems q = new QueueProblems();
		String[] str=q.findBinaryNum(10);
		for(String s:str){
			System.out.print(s+" ");
		}
	}

}
