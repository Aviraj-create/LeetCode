class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                pq.offer(new int[]{dis(i,j,points),i,j});
            }
            
        }
        
        UnionFind uf=new UnionFind(n);
        int ans=0;
        int count=0;
        while(count<n-1)
        {
            int[] temp=pq.poll();
            if(uf.find(temp[1])!=uf.find(temp[2]))
            {
                ans+=temp[0];
                count++;
                uf.union(temp[1],temp[2]);
            }
        }
        return ans;
        
            
    }
    
    public int dis(int i,int j, int[][] points)
    {
        return Math.abs(Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]));
    }
    
    class UnionFind
    {
         int[] parent;
        UnionFind(int n)
        {
            this.parent=new int[n];
            for(int i=0;i<parent.length;i++)
            {
                parent[i]=i;
            }
        }
        
        public void union(int a,int b)
        {
            parent[find(a)]=parent[find(b)];
        }
        public int find(int x)
        {
            if(parent[x]!=x)
            {
              parent[x]=find(parent[x]);
            }
            return parent[x];
        } 
    }
}