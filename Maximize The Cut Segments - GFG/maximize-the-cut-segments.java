//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


// class Solution {
//     // Function to find the maximum number of cuts.
//     public int maximizeCuts(int n, int x, int y, int z) {
//         int dp[]=new int[n+1];
//         Arrays.fill(dp,-1);
//         return f(n, x, y, z,dp);
//     }

//     public int f(int n, int x, int y, int z,int[]dp) {
//         if (n == 0) {
//             return 0;
//         }
//         if (n < 0) {
//             return -1;
//         }
//         if(dp[n]!=-1)return dp[n];
//         int cutsUsingX = f(n - x, x, y, z,dp);
        
//         int cutsUsingY = f(n - y, x, y, z,dp);
//         int cutsUsingZ = f(n - z, x, y, z,dp);

//         int maxCuts = Math.max(cutsUsingX, Math.max(cutsUsingY, cutsUsingZ));

//         if (maxCuts == -1) {
//             dp[n]=-1;
//         } else {
//             dp[n]=maxCuts + 1;
//         }
        
//         return dp[n];
//     }
// }
class Solution {
    // Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            if (i - x >= 0) {
                dp[i] = Math.max(dp[i], dp[i - x] + 1);
            }
            if (i - y >= 0) {
                dp[i] = Math.max(dp[i], dp[i - y] + 1);
            }
            if (i - z >= 0) {
                dp[i] = Math.max(dp[i], dp[i - z] + 1);
            }
        }
        
        return dp[n] >= 0 ? dp[n] : 0;
    }
}


