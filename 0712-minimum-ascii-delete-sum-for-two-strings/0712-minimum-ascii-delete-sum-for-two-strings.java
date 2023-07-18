class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        Integer[][] dp=new Integer[s1.length()+1][s2.length()+1];
        return f(0,0,s1,s2,dp);
    }
    
    public int f(int i,int j,String s1,String s2,Integer[][]dp)
    {
        if(i==s1.length() && j==s2.length())
            return 0;
        if (i == s1.length()) {
            int sum = 0;
            for (int k = j; k < s2.length(); k++) {
                sum += s2.charAt(k);
            }
            return sum;
        }

        if (j == s2.length()) {
            int sum = 0;
            for (int k = i; k < s1.length(); k++) {
                sum += s1.charAt(k);
            }
            return sum;
        }
        if(dp[i][j]!=null)return dp[i][j];
        
        if(s1.charAt(i)==s2.charAt(j))
        {
            return dp[i][j]=f(i+1,j+1,s1,s2,dp);
        }
        int temp1=s1.charAt(i)+f(i+1,j,s1,s2,dp);
        int temp2=s2.charAt(j)+f(i,j+1,s1,s2,dp);
        
        return dp[i][j]=Math.min(temp1,temp2);
    }
}



