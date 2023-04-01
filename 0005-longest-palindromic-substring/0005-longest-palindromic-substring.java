class Solution {
    private int maxLen,start;
    public String longestPalindrome(String s) {
        
        if(s.length()<2){return s;}
        
        for(int i=0;i<s.length();i++)
        {
            extendPali(s,i,i);
            extendPali(s,i,i+1);
        }
        
        return s.substring(start,start+maxLen);  
    }
    public void extendPali(String s,int j,int k){
        while(j>=0 && k<s.length() && s.charAt(j)==s.charAt(k)){
            j--;
            k++;
        }
        
        if(maxLen<k-j-1)
        {
            start=j+1;
            maxLen=k-j-1;
        }
    }
    
}