class Solution {
    public int largestAltitude(int[] gain) {
        int al=0;
        int ans=0;
        for(int i:gain)
        {
            al+=i;
            ans=Math.max(ans,al);
        }
        return ans;
    }
}