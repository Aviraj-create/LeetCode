class Solution {
    
    public int buildMst(int n,int[][]edges,int[]pick,int[] skip)
    {
        UnionFind uf=new UnionFind(n);
        int cost=0;
        
        if(pick!=null)
        {
            uf.union(pick[0],pick[1]);
            cost+=pick[2];
        }
        
        for(int edge[]:edges)
        {
            if(edge!=skip && uf.union(edge[0],edge[1]))
            {
               
                cost+=edge[2];
            }
        }
        
        return uf.count==1?cost:Integer.MAX_VALUE;
    }
    
    
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges){
        
      List<Integer> critical=new ArrayList<>();
      List<Integer> pseudocritical=new ArrayList<>();
      Map<int[],Integer> map=new HashMap<>();
        for(int i=0;i<edges.length;i++)
        {
            map.put(edges[i],i);
        }
        
        Arrays.sort(edges,(e1,e2)->Integer.compare(e1[2],e2[2]));
        
        int minCost=buildMst(n,edges,null,null);
        for(int[]edge:edges)
        {
            int idx=map.get(edge);
            
            int costWithout=buildMst(n,edges,null,edge);
            if(costWithout>minCost)
            {
                critical.add(idx);
            }
            else
            {
                int costWith=buildMst(n,edges,edge,null);
                if(costWith==minCost)
                {
                    pseudocritical.add(idx);
                }
            }
        }
        
       
        return Arrays.asList(critical,pseudocritical);
        
    }
    
    class UnionFind{
        final int[] parent;
        int count;
        public UnionFind(int size){
            this.parent=new int[size];
            for(int i=0;i<size;i++)
            {
                parent[i]=i;
            }
            count=parent.length;
        }
        
        public int find(int x)
        {
            if(parent[x]!=x)
            {
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
        
       
        
        boolean union(int x,int y)
        {
            int parentX=find(x);
            int parentY=find(y);
            
            if (parentX != parentY) {
            parent[parentX] = parentY;
             count--;
                return true;
       }
            else
            {
                return false;
            }
           
        }
    }
    
    
}