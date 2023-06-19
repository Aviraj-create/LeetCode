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
    public int maxLevelSum(TreeNode root) {
        Map<Integer,ArrayList<Integer>> levelSum=new HashMap<>();
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int level=1;
        while(!q.isEmpty())
        {
            int n=q.size();
            int sum=0;
            
            for(int i=0;i<n;i++)
            {
                TreeNode temp=q.poll();
                
                sum+=temp.val;
                if(temp.left!=null)
                {
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    q.add(temp.right);
                }
            }
            
            
            if(!levelSum.containsKey(sum))
            {
                 levelSum.put(sum,new ArrayList<>());
            }
            
            levelSum.get(sum).add(level);
           
            
            level++;
        }
        
        
        int r=-10001;
        
        for(Map.Entry<Integer,ArrayList<Integer>> entry:levelSum.entrySet())
        {
            r=Math.max(r,entry.getKey());
        }
        
        Collections.sort(levelSum.get(r));
        return levelSum.get(r).get(0);
        
        
        
    }
}