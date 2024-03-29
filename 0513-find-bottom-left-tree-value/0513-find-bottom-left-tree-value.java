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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            ArrayList<Integer> temp=new ArrayList<>();
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                TreeNode t=q.poll();
                temp.add(t.val);
                
                if(t.left!=null)
                {
                    q.add(t.left);
                }
                if(t.right!=null)
                {
                    q.add(t.right);
                }
               
            }
             arr.add(temp);
            
        }
        
        return arr.get(arr.size()-1).get(0);
    }
}