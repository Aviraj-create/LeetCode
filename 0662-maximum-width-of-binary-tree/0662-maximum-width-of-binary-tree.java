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
class Pair
{
    TreeNode node;
    int num;
    Pair(TreeNode _node,int _num)
    {
        node=_node;
        num=_num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root==null)return 0;
        int ans=0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty())
        {
            int mini=q.peek().num;
            int size=q.size();
            
            int first=0;
            int last=0;
            
            for(int i=0;i<size;i++)
            {
                
                int currid=q.peek().num-mini;
                TreeNode temp=q.peek().node;
                q.poll();
                if(i==0)first=currid;
                if(i==size-1)last=currid;
                
                if(temp.left!=null)
                {
                    q.add(new Pair(temp.left,(2*currid)+1));
                }
                 if(temp.right!=null)
                {
                    q.add(new Pair(temp.right,(2*currid)+2));
                }
            }
            ans=Math.max(ans,last-first+1);
        }
        
        return ans;
        
    }
}