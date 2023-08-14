//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n) {
        int[] memo = new int[n + 1];
        return f(n, memo);
    }
    
    public static int f(int n, int[] memo) {
        if (n == 0) return 0;
        if (n == 1 || n==2) return 1;
        
        if (memo[n] != 0) {
            return memo[n];
        }
        
        memo[n] = (f(n - 1, memo) + f(n - 2, memo)) % 1000000007;
        return memo[n];
    }
}

