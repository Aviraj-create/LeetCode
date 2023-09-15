class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int[] point:points)
        {
            int x=point[0];
            int y=point[1];
            
            int dis=x*x+y*y;
            pq.offer(new int[]{x,y,dis});
        }
        int[][] ans=new int[k][2];
        while(k-->0)
        {
            int temp[]=pq.poll();
            ans[k][0]=temp[0];
            ans[k][1]=temp[1];
            
        }
        return ans;
    }
}