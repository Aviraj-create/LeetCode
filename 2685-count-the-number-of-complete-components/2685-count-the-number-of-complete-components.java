class Solution {
    boolean visited[];
    ArrayList<ArrayList<Integer>>adj;
    public int countCompleteComponents(int n, int[][] edges) {
        
        visited=new boolean[n];
        adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int j[]:edges)
        {
            adj.get(j[0]).add(j[1]);
            adj.get(j[1]).add(j[0]);
        }
        
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(visited[i]!=true)
            {
                List<Integer> comp=new ArrayList<Integer>();
                dfs(i,comp);
                int compSize=comp.size();
                int maxEdges=((compSize)*(compSize-1))/2;
                int actual=0;
                
                for(int u:comp)
                {
                    actual+=adj.get(u).size();
                }
                
                actual/=2;
                
                if(maxEdges==actual)
                    count++;
            }
        }
        
        return count;
        
    }
    
    public void dfs(int node,List<Integer> comp)
    {
        visited[node]=true;
        comp.add(node);
        for(int i:adj.get(node))
        {
            if(visited[i]!=true)
            {
                dfs(i,comp);
            }
        }
    }
}