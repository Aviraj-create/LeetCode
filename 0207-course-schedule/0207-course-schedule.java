class Solution {
    public boolean canFinish(int numCourses, int[][] arr) {
        
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int m=0;m<arr.length;m++)
        {
            adj.get(arr[m][0]).add(arr[m][1]);
        }
        
        int []indegree=new int[numCourses];
        
        for(int i=0;i<numCourses;i++)
        {
            for(int it:adj.get(i))
            {
                indegree[it]++;
            }
        }
        
        Queue<Integer>q=new LinkedList<>();
        
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        ArrayList<Integer>topo=new ArrayList<>();
        
        while(!q.isEmpty())
        {
            int curr=q.poll();
            topo.add(curr);
            for(int p:adj.get(curr))
            {
                indegree[p]--;
                if(indegree[p]==0){q.add(p);}
            }
        }
        
        if(topo.size()==numCourses)return true;
        return false;
        
    }
}