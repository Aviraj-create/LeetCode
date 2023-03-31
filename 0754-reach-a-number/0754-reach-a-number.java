class Solution {
    int step=0;
    int sum=0;
    public int reachNumber(int target) {
        
        target=Math.abs(target);
        
        
        while(sum<target)
        {
            step++;
            sum+=step;
        }
        
        while((sum-target)%2!=0)
        {
            step++;
            sum+=step;
        }
        
        return step;
        
        
        
        
    }
}