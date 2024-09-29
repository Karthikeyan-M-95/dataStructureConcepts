 package intervalConcepts;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class OverlappingInterval {
	
	private List<Interval> list;
	
	public List<Interval> merge(List<Interval> interval){
		
		if(interval.size() < 2) {
			return interval;
		}
		LinkedList<Interval> res = new LinkedList<>();
		Interval obj = interval.get(0);
		int start =obj.start;
		int end=obj.end;
		for(int i=1;i<interval.size();i++) {
			Interval curr= interval.get(i);
			if(curr.start<=end) {
				end = Math.max(end,curr.end);
			}else {
				res.add(new Interval(start,end));
				start=curr.start;
				end = curr.end;	
			}
		}
		res.add(new Interval(start,end));
		return res;
	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval){
		
		if(intervals==null || intervals.isEmpty())
			return intervals;
		List<Interval> res = new LinkedList<>();
		int i =0;
		while(i<intervals.size() && intervals.get(i).end<newInterval.start) {
			res.add(intervals.get(i));
			i++;
		}
		while(i<intervals.size() && intervals.get(i).start<= newInterval.end) {
			Interval curr = intervals.get(i);
			newInterval.start= Math.min(curr.start, newInterval.start);
			newInterval.end= Math.max(curr.end, newInterval.end);
			i++;
		}
		res.add(newInterval);
		
		while(i<intervals.size()){
			res.add(intervals.get(i));
			i++;
		}
		
		return res;
	}

	public static void main(String[] args) {
		List<Interval> list = new LinkedList<>();
		OverlappingInterval obj = new OverlappingInterval();
		Interval i1 = new Interval(0,1);
		Interval i2 = new Interval(2,5);
		Interval i3 = new Interval(9,10 );
		Interval l4 = new Interval(4,6);
		list.add(i1);
		list.add(i2);
		list.add(i3);
		
		
//		list.sort(comparingInterval(in -> in.start));
//		list = obj.merge(list);
		list=obj.insert(list, l4);
		for(Interval w : list) {
			System.out.println(w.start+" "+w.end+" ");
		}

	}

}
