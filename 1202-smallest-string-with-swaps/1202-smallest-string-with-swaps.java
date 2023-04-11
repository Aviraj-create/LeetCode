class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
       int n=s.length();
        char[]str=s.toCharArray();
        Map<Integer,PriorityQueue<Character>>map=new HashMap<>();
        UnionFind uf=new UnionFind(n);
        
        for(List<Integer> pair:pairs)
        {
            uf.unify(pair.get(0),pair.get(1));
        }
        
        for(int i=0;i<n;i++)
        {
            int parentId=uf.findAbsParent(i);
            PriorityQueue<Character>pq=map.getOrDefault(parentId,new PriorityQueue<Character>());
            pq.offer(str[i]);
            map.put(parentId,pq);
        }
        
        for(int i=0;i<n;i++)
        {
            int parentId=uf.findAbsParent(i);
            str[i]=map.get(parentId).poll();
        }
        String string = new String(str);  
        return string;
    }
    
    class UnionFind {   
        int[] parent;
        UnionFind(int n) {
            this.parent = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }		
        public void unify(int a, int b) {
            parent[findAbsParent(a)] = parent[findAbsParent(b)];
        }
        public int findAbsParent(int x) {
            if(parent[x] != x) parent[x] = findAbsParent(parent[x]);
            return parent[x];
        }
    }
}