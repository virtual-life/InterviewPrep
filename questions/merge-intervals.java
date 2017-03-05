// Time - O(nlogn)
// Space - O(n)
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

public List<Meeting> mergeRanges(List<Meeting> meetings) {

    // sort by start times
    List<Meeting> sortedMeetings = new ArrayList<Meeting>(meetings);
    Collections.sort(sortedMeetings, new Comparator<Meeting>() {
        public int compare(Meeting m1, Meeting m2)  {
            return m1.startTime - m2.startTime;
        }
    });

    // initialize mergedMeetings with the earliest meeting
    List<Meeting> mergedMeetings = new ArrayList<Meeting>();
    mergedMeetings.add(sortedMeetings.get(0));

    for (Meeting currentMeeting : sortedMeetings) {

        Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);

        // if the current and last meetings overlap, use the latest end time
        if (currentMeeting.startTime <= lastMergedMeeting.endTime) {
            lastMergedMeeting.endTime = Math.max(lastMergedMeeting.endTime, currentMeeting.endTime);

        // add the current meeting since it doesn't overlap
        } else {
            mergedMeetings.add(currentMeeting);
        }
    }

    return mergedMeetings;
}

/**
    What if we did have an upper bound on the input values? Could we improve our runtime? Would it cost us memory?
    Could we do this "in-place" on the input list and save some space? What are the pros and cons of doing this in-place?
 * /
 /*
  * In-Place 
  * 1) Sort all intervals in decreasing order of start time.
  
    Collections.sort(list ,Collections.reverseOrder());
    //for an array
    Arrays.sort(array, Collections.reverseOrder());
    
    2) Traverse sorted intervals starting from first interval, 
      do following for every interval.
        a) If current interval is not first interval and it 
          overlaps with previous interval, then merge it with
          previous interval. Keep doing it while the interval
          overlaps with the previous one.         
        b) Else add current interval to output list of intervals.
 */
 
