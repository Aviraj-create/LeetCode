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
// class Solution {
//     public int minDepth(TreeNode root) {
//         if(root==null)return 0;
//         int lh=minDepth(root.left);
//         int rh=minDepth(root.right);
        
//         return (lh==0 || rh==0)?lh+rh+1:1+Math.min(lh,rh);
//     }
// }

class Solution {
    public int minDepth(TreeNode root)
    {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)return 0;
        q.add(root);
        int depth=0;
        
        while(!q.isEmpty())
        {
            depth++;
            int n=q.size();
            for(int i=0;i<n;i++)
            {
               TreeNode temp= q.poll();
               if(temp.left==null && temp.right==null)return depth;
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
            
        }
        
        return depth;
        
    }
}