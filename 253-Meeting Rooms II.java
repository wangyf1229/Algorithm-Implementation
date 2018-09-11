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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        PriorityQueue<Interval> rooms = new PriorityQueue<>((a, b) -> a.end - b.end);
        rooms.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval lastAvailableRoom = rooms.poll();
            if (lastAvailableRoom.end > intervals[i].start) {
                rooms.offer(intervals[i]);
            } else {
                lastAvailableRoom.end = intervals[i].end;
            }
            rooms.offer(lastAvailableRoom);
        }
        return rooms.size();
        
    }
}