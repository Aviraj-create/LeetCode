/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
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
        
        return bfs(start,adj);
        
       
        
        
        
        

    }
    
    public int bfs(int startIndex,Map<Integer, ArrayList<Integer>> adj)
    {
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[100001];
        int maxDistance=0;
        int[] dist=new int[100001];
        dist[startIndex]=0;
        visited[startIndex]=true;
        q.offer(startIndex);
        while(!q.isEmpty())
        {
            int ver=q.poll();
            for(int neigh:adj.get(ver))
            {
                if(!visited[neigh])
                {
                    visited[neigh]=true;
                    dist[neigh]=dist[ver]+1;
                    maxDistance=Math.max(maxDistance,dist[neigh]);
                    q.offer(neigh);
                }
            }
        }
        
        return maxDistance;
        
    }
}