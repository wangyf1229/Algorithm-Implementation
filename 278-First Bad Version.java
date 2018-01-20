/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long start = 1;
        long end = n;
        while (start + 1 < end) {
            long mid = (start + end)/2;
            if (isBadVersion((int) mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (isBadVersion((int) start))  return (int) start;
        return (int) end;
    }
}