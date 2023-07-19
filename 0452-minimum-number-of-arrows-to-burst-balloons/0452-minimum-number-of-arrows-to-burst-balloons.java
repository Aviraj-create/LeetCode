class Solution {
    public int findMinArrowShots(int[][] points) {
       Arrays.sort(points, Comparator.comparingInt(arr -> arr[0]));
        int start=points[0][0];
        int end=points[0][1];
        int count=1;
      for(int i=1;i<points.length;i++)
      {
          if(points[i][0]>=start && points[i][0]<=end || points[i][1]>=start && points[i][1]<=end)
          {
              start=Math.max(start,points[i][0]);
              end=Math.min(end,points[i][1]);
          }
          else
          {
              count++;
              start=points[i][0];
              end=points[i][1];
          }
      }
        return count;
    }
}