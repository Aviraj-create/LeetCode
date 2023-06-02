class Solution {
    int count=0;
    public int maximumDetonation(int[][] bombs) {
        int n=bombs.length;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            count=0;
            dfs(i,bombs,new boolean[n]);
            ans=Math.max(ans,count);
        }
        return ans;
    }
    
    public void dfs(int idx,int[][]bombs,boolean[] v)
    {
        count++;
        v[idx]=true;
        int n=bombs.length;
        
        for(int i=0;i<n;i++)
        {
            if(!v[i] && inBombRange(i,idx,bombs))
            {
                dfs(i,bombs,v);
            }
        }
    }
    public boolean inBombRange(int i,int idx,int[][] bombs)
    {
        int[] a=bombs[i];
        int[] b=bombs[idx];
        
        int x=a[0]-b[0];
        int y=a[1]-b[1];
        
        if(Math.pow(x,2)+Math.pow(y,2)<=Math.pow(b[2],2))
        {
            return true;
        }
    return false;
    }
}