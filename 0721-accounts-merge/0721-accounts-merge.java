public class DisjointSet {
    private int[] parent;
    private int[] rank;
    
    public DisjointSet(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }
    
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public void unify(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        
        if (xRoot == yRoot) {
            return;
        }
        
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
            rank[yRoot]++;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }
    
    public int getParentOfComponent(int x) {
        int root = find(x);
        int parentOfComponent = root;
        
        for (int i = 0; i < parent.length; i++) {
            if (find(i) == root && parent[i] < parentOfComponent) {
                parentOfComponent = parent[i];
            }
        }
        
        return parentOfComponent;
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer>map=new HashMap<>();
        int n=accounts.size();
        DisjointSet ds=new DisjointSet(n);
        
        for(int i=0;i<accounts.size();i++)
        {
            for(int j=1;j<accounts.get(i).size();j++)
            {
                String temp=accounts.get(i).get(j);
                if(!map.containsKey(temp))
                {
                    map.put(temp,i);
                }
                else
                {
                    ds.unify(i,map.get(temp));
                }
            }
        }
        
       ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) mergedMail[i] = new ArrayList<String>();
        for(Map.Entry<String,Integer> it:map.entrySet())
        {
            String t=it.getKey();
            int node=ds.find(it.getValue());
             mergedMail[node].add(t);
        }
        
        List<List<String>>ans=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(mergedMail[i].size()==0)continue;
            Collections.sort(mergedMail[i]);
            ArrayList<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String q:mergedMail[i])
            {
                temp.add(q);
            }
            ans.add(temp);
        }
        
        
        return ans;
        
        
    }
}