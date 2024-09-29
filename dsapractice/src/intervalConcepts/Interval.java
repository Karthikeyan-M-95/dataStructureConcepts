package intervalConcepts;
import java.util.Comparator;

public class Interval {

	protected int start;
	protected int end;
	
	Interval(int start, int end){
		this.start=start;
		this.end=end;
	}
	
	public static Comparator<Interval> getStartComparator(){
		return new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		};
	}
	
}
