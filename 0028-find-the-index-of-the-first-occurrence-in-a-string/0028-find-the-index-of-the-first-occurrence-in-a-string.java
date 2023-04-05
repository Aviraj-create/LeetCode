class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.equals(haystack))return 0;
        int n=needle.length();
        for(int i=0;i<haystack.length()-n+1;i++)
        {
            String s=haystack.substring(i,i+n);
            if(needle.equals(s))return i; 
        }
        
        return -1;
    }
}