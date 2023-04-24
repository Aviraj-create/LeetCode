class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
            for(int i=0;i<stones.length;i++)
            {
                pq.add(stones[i]);
            }
        while(pq.size()>1)
        {
            int y=pq.poll();
            int x=pq.poll();
            
            if(y==x && pq.isEmpty())return 0;
            
            if(y==x)
            {
                y=0;
                x=0;
            }
            else
            {
                y=y-x;
            }
            
            if(y!=0)
            {
                pq.add(y);
            }
        }
        
        return pq.poll();
    }
}