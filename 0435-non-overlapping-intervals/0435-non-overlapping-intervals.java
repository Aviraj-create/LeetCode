import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                // Overlapping intervals found
                count++;
                prevEnd = Math.min(prevEnd, intervals[i][1]); // Choose the interval with the smaller end time
            } else {
                // Non-overlapping interval
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}
