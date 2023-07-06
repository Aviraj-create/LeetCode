class Solution {
    public int maximumProduct(int[] nums, int k) {
         int MOD = 1000000007;

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i:nums)
        {
            pq.offer(i);
        }
        
        while(k-->0)
        {
            int top=pq.poll()+1;
            pq.offer(top);
        }
        long res=1;
        while(!pq.isEmpty())
        {
           res= (res*pq.poll())%MOD;
        }
        
        return (int)res;
        
    }
}