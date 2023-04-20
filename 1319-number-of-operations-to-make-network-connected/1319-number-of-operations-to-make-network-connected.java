class Solution {
    public void dfs(int i,Set<Integer>set,ArrayList<ArrayList<Integer>>adj)
    {
        set.add(i);
        for(int temp:adj.get(i))
        {
            if(!set.contains(temp))
            {
                dfs(temp,set,adj);
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        for(int j=0;j<connections.length;j++)
        {
            adj.get(connections[j][0]).add(connections[j][1]);
             adj.get(connections[j][1]).add(connections[j][0]);
        }
        int count=0;
        Set<Integer>set=new HashSet<>();
        
        for(int k=0;k<n;k++)
        {
            if(!set.contains(k))
            {
                count++;
                dfs(k,set,adj);
            }
        }
        
        int numEdge=connections.length;
        if(numEdge<n-1)return -1;
        else
            return count-1;
        
        
    }
}