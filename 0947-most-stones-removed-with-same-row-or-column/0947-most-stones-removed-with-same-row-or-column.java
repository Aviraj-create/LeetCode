class DisjointSet
{
    private int[]parent ;
    private int[]rank;
    
    DisjointSet(int n)
    {
        parent=new int[n+1];
        rank=new int[n+1];
        
        for(int i=0;i<=n;i++)
        {
            parent[i]=i;
        }
    }
    
    public int find(int x)
    {
        if(parent[x]!=x)
        {
            parent[x]=find(parent[x]);
        }
        
        return parent[x];
    }
    
    public void unify(int a,int b)
    {
        int parA=find(a);
        int parB=find(b);
        
        if(parA==parB)return;
        if(rank[parA]>rank[parB])
            parent[parB]=parA;
        else if(rank[parA]<rank[parB])
        {
            parent[parA]=parB;
        }
        else
        {
            parent[parA]=parB;
            rank[parB]++;
        }
        
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        
        int maxRow=0;
        int maxCol=0;
        for(int[]it:stones)
        {
            maxRow=Math.max(it[0],maxRow);
            maxCol=Math.max(it[1],maxCol);
        }
        
        DisjointSet ds=new DisjointSet(maxRow+maxCol+1);
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<stones.length;i++)
        {
            int nodeRow=stones[i][0];
            int nodeCol=stones[i][1]+maxRow+1;
            
            ds.unify(nodeRow,nodeCol);
            map.put(nodeRow,1);
            map.put(nodeCol,1);
        }
        
        int count=0;
       for( Map.Entry<Integer,Integer> it:map.entrySet())
       {
           if(ds.find(it.getKey())==it.getKey())
           {
               count++;
           }
       }
        System.out.println(ds.find(0));
        return stones.length-count;
    }
}