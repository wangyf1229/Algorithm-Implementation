/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return new LinkedList<Interval>();
        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        List<Interval> result = new LinkedList<Interval>();
        int s = intervals.get(0).start;
        int e = intervals.get(0).end;
        for (int i = 0; i < intervals.size(); i++) {
            if (e >= intervals.get(i).start) {
                e = Math.max(e, intervals.get(i).end);
            } else {
                result.add(new Interval(s, e));
                s = intervals.get(i).start;
                e = intervals.get(i).end;
            }
        }
        result.add(new Interval(s, e));
        return result;
    }
}