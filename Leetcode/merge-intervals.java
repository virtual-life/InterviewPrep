public class Solution {
    public List<Interval> merge(List<Interval> intervals) {

        if(intervals == null || intervals.size()<=1){
            return intervals;
        }

        List<Interval> result = new ArrayList<Interval>();

        Collections.sort(intervals, new IntervalComparator());
        Interval prev = intervals.get(0);

        for(int i=1 ;i<intervals.size();i++){

            Interval curr = intervals.get(i);
            if(prev.end >= curr.start){
                Interval merged = new Interval(prev.start, Math.max(prev.end,curr.end));
                prev = merged;
            }else{
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);
        return result;

    }
}

class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval v1, Interval v2){
        return v1.start - v2.start;
    }
}