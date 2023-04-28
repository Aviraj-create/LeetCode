class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        int n=runningCosts.length;
        long cost=0;
        int i=0,j=0,res=Integer.MIN_VALUE;
        for(;i<n;i++)
        {
            cost+=runningCosts[i];
            pq.add(chargeTimes[i]);
            while(!pq.isEmpty() && pq.peek()+cost*pq.size()>budget)
            {
                cost-=runningCosts[j];
                pq.remove(chargeTimes[j]);
                j++;
            }
            res=Math.max(res,pq.size());
        }
         return res;
    }
   
}