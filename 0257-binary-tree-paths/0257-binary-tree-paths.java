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
    String arrow="->";
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        f(root,ans,sb);
        return ans;
    }
    public void f(TreeNode root,List<String>ans,StringBuilder sb)
    {
        if(root==null)return;
        if(root.left==null && root.right==null)
        {
            sb.append(Integer.toString(root.val));
            String temp=sb.toString();
            ans.add(temp);
            return;
        }
        sb.append(Integer.toString(root.val));
       
        if(root.left!=null)
        {
            sb.append(arrow);
             String q=sb.toString();
            sb.delete(sb.length()-2,sb.length());
            f(root.left,ans,new StringBuilder(q));
        }
        if(root.right!=null)
        {
             sb.append(arrow);
            String w=sb.toString();
            f(root.right,ans,new StringBuilder(w));
        }
        
    }
}