class Solution {
    public int minTaps(int n, int[] ranges) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[0]!=b[0])?(a[0]-b[0]):(b[1]-a[1]));
        for(int i=0;i<ranges.length;++i)
        {
          int temp[] = {Math.max(0, i - ranges[i]),Math.min(n, i + ranges[i])};

            pq.add(temp);
        }
        
        int current=0;
        int count=0;
        
        while(!pq.isEmpty())
        {
            int[] out=pq.poll();
            if(current<out[0])
            {
                return -1;
            }
            
            if(current>out[0])
            {
                out[0]=current;
                pq.add(out);
            }
            else
            {
                count++;
                current=out[1];
                if(current==n){
return count;}
            }
        }return count;
    }
}