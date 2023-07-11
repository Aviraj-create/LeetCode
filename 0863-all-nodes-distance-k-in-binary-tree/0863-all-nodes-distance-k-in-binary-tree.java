class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                
                if (!adj.containsKey(temp.val)) {
                    adj.put(temp.val, new ArrayList<>());
                }
                
                if (temp.left != null) {
                    q.add(temp.left);
                    if (!adj.containsKey(temp.left.val)) {
                        adj.put(temp.left.val, new ArrayList<>());
                    }
                    
                    adj.get(temp.val).add(temp.left.val);
                    adj.get(temp.left.val).add(temp.val);
                }
                
                if (temp.right != null) {
                    q.add(temp.right);
                    if (!adj.containsKey(temp.right.val)) {
                        adj.put(temp.right.val, new ArrayList<>());
                    }
                    
                    adj.get(temp.val).add(temp.right.val);
                    adj.get(temp.right.val).add(temp.val);
                }
            }
        }
        
        int maxNodeValue = getMaxNodeValue(root);
        boolean[] visited = new boolean[maxNodeValue + 1]; // Initialize with maximum node value
        
        List<Integer> ans = new ArrayList<>();
        dfs(target.val, adj, k, ans, visited);
        return ans;
    }
    
    public void dfs(int curr, Map<Integer, ArrayList<Integer>> adj, int k, List<Integer> ans, boolean[] visited) {
        if (k == 0) {
            ans.add(curr);
            return;
        }
        
        visited[curr] = true;
        for (int i : adj.get(curr)) {
            if (!visited[i]) {
                dfs(i, adj, k - 1, ans, visited);
            }
        }
    }
    
    public int getMaxNodeValue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return Math.max(root.val, Math.max(getMaxNodeValue(root.left), getMaxNodeValue(root.right)));
    }
}
