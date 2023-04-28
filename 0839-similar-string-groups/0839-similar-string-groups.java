class Solution {
    public int numSimilarGroups(String[] strs) {
        
        UnionFind uf = new UnionFind(strs.length);
        int count = 0;
        for(int i=0; i<strs.length-1; i++) {
            for(int j=i+1; j<strs.length; j++) {
                if(isSimilar(strs[i],strs[j])) {
                    uf.unify(i,j);
                }
            }
        }
       
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<uf.parent.length; i++) {
            if(!set.contains(uf.find(i))) {
                count++;
                set.add(uf.find(i));
            }
        }
        return count;
    }
    
    public boolean isSimilar(String a, String b) {
        int diff = 0;
        int len = a.length();
        for(int i=0; i<len; i++) {
            if(a.charAt(i) != b.charAt(i) && ++diff >= 3)
                return false;
        }
        return true;
    }
}

class UnionFind {
    public int[] parent;
    private int[] rank;
    
    public UnionFind(int size) {
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
        return parent[x] == x ? x : find(parent[x]);
    }

    public void unify(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return;
        }
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }
}
