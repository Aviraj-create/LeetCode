class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer,List<Pair<Integer,Double>>> adj=new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            adj.put(i,new ArrayList<Pair<Integer,Double>>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]));
        }
        
        Set<Integer> visited=new HashSet<>();
        double[] dist=new double[n];
        Arrays.fill(dist,Double.MIN_VALUE);
        
        
        PriorityQueue<Pair<Integer,Double>> pq=new PriorityQueue<>((a,b) -> Double.compare(b.getValue(), a.getValue()));
        pq.offer(new Pair(start,(double)1));
        dist[start]=1;
        while(!pq.isEmpty())
        {
            int cur=pq.peek().getKey();
            double p=pq.poll().getValue();
            
            if(visited.contains(cur))continue;
            visited.add(cur);
            
            Iterator<Pair<Integer,Double>> it=adj.get(cur).iterator();
            while(it.hasNext())
                
            {
                Pair pair=it.next();
                int v=(int)pair.getKey();
                double pr=(double)pair.getValue();
                
                if(!visited.contains(v))
                {
                    double newD=pr*p;
                    if(dist[v]<newD)
                    {
                        dist[v]=newD;
                    }
                    
                    pq.offer(new Pair(v,dist[v]));
                    
                }
            }
        }
        
        return (dist[end]==Double.MIN_VALUE)?0:dist[end];
    }
}