class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb=new StringBuilder();
        
        int i=0,j=0;
        
        int n=word1.length();
        int m=word2.length();
        
        while(i<=n-1 && j<=m-1)
        {
            sb.append(word1.charAt(i));
            i++;
            sb.append(word2.charAt(j));
            j++;
        }
        if(i==n)
        {
            sb.append(word2.substring(j,m));
        }
        else
        {
            sb.append(word1.substring(i,n));
        }
        return sb.toString();
    }
}