public class Solution {
    public int maxPathSum(TreeNode root) {
        int[] ans=new int[1];
        ans[0]=Integer.MIN_VALUE;
        f(root,ans);
        return ans[0];
    }
    public int f(TreeNode node,int[] ans)
    {
        
        if(node==null)return 0;
        
        int left=Math.max(f(node.left,ans),0);
        int right=Math.max(f(node.right,ans),0);
        
        ans[0]=Math.max(ans[0],node.val+left+right);
        return node.val+Math.max(left,right);
    }
}
