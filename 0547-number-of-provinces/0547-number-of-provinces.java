class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
         for(int i=0;i<isConnected.length;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<isConnected.length;i++)
        {
            
            for(int j=0;j<isConnected[0].length;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
                
            }
        }
        
        boolean[] v=new boolean[isConnected.length];
        int prov=0;
        for(int i=0;i<isConnected.length;i++)
        {
            if(!v[i])
            {
                prov++;
                dfs(i,adj,v);
            }
        }
        return prov;
      
    }
    
    public void dfs(int i,ArrayList<ArrayList<Integer>> adj,boolean[] v)
    {
        v[i]=true;
        for(int temp:adj.get(i))
        {
            if(!v[temp])
            {
                dfs(temp,adj,v);
            }
        }
    }
}