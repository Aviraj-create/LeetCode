class Solution {
//     int f(int i,int j,String A,String B,int[][]dp)
//     {
//         if(i<0 || j<0)return 0;
//         if(dp[i][j]!=-1)return dp[i][j];
        
//         if(A.charAt(i)==B.charAt(j))
//             return dp[i][j]=1+f(i-1,j-1,A,B,dp);
//         {
//             return dp[i][j]=0+Math.max(f(i-1,j,A,B,dp),f(i,j-1,A,B,dp));
//         }
        
        
//     }
//     public int minDistance(String word1, String word2) {
//         int n=word1.length();
//         int m=word2.length();
        
//         int [][]dp=new int[n][m];
        
//         for(int i=0;i<n;i++)
//         {
//             Arrays.fill(dp[i],-1);
//         }
        
//         int comman=f(n-1,m-1,word1,word2,dp);
        
//         return (n-comman)+(m-comman);
//     }
    
    public int minDistance(String word1, String word2) {
  int longest = findLongestCommonSubSequence(word1, word2);
  return word1.length() - longest + word2.length() - longest;
}

private int findLongestCommonSubSequence(String word1, String word2) {
  int[][] matrix = new int[word1.length() + 1][word2.length() + 1];
  int re = 0;
  for (int i = 1; i <= word1.length(); i++) {
    for (int j = 1; j <= word2.length(); j++) {
      if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
        matrix[i][j] = matrix[i - 1][j - 1] + 1;
      } else {
	matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
      }
      re = Math.max(matrix[i][j], re);
      }
    }
  return re;
}
}


