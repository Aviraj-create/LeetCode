class Solution {
    public int[] findOrder(int numCourses, int[][] arr) {
        
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int m=0;m<arr.length;m++)
        {
            adj.get(arr[m][1]).add(arr[m][0]);
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
         int topo[] = new int[numCourses];
        int ind = 0;
        // o(v + e)
        while (!q.isEmpty()) {
            int node = q.peek();

            q.remove();
            topo[ind++] = node;
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }


        if (ind == numCourses) return topo;
        int[] ar = {};
        return ar;
        
        
        
    }
}