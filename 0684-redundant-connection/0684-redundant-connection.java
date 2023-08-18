class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer,Set<Integer>> map=new HashMap<>();
        for(int[] edge:edges)
        {
            if(!map.containsKey(edge[0])) map.put(edge[0],new HashSet<>());
            if(!map.containsKey(edge[1])) map.put(edge[1],new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q=new LinkedList<>();
        for(int key:map.keySet())
        {
            if(map.get(key).size()==1)q.offer(key);
        }
        while(!q.isEmpty())
        {
            int temp=q.poll();
            Set<Integer> list=map.get(temp);
            map.remove(temp);
            
            for(int neighbour:list)
            {
                map.get(neighbour).remove(temp);
                if(map.get(neighbour).size()==1)
                {
                    q.offer(neighbour);
                }
            }
            
        }
        
        for(int i=edges.length-1;i>=0;i--)
        {
           int edge[]=edges[i];
            if(map.containsKey(edge[0]) && map.containsKey(edge[1]))
            {
                return edge;
            }

        }
        return new int[]{};

        
        
        
    
        
        
    }
}