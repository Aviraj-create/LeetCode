class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0;
        int n=mat.length;
        
        
      
            for(int j=0;j<n;j++)
            {
              sum+=mat[j][j];
                sum+=mat[n-j-1][j];
            }
        if(n%2!=0)
        {
            sum=sum-mat[n/2][n/2];
        }
        return sum;
    }
}