class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i[]:prerequisites)
        {
            adj.get(i[0]).add(i[1]);
        }
        
        int[]indegree=new int[numCourses];
        
        for(int i=0;i<numCourses;i++)
        {
            for(int it:adj.get(i))
            {
                indegree[it]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)q.add(i);
        }
        ArrayList<Integer> topo=new ArrayList<>();
        while(!q.isEmpty())
        {
            int temp=q.poll();
            topo.add(temp);
            for(int i:adj.get(temp))
            {
                indegree[i]--;
                if(indegree[i]==0)q.add(i);
            }
        }
        
        return (topo.size()==numCourses)?true:false;
    }
}