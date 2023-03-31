class Solution {
    int step=0;
    int sum=0;
    public int reachNumber(int target) {
        
        target=Math.abs(target);
        
        
        while(true){
            step++;
            sum+=step;
            
            if(sum==target)return step;
            else if(sum>target &&(sum-target)%2==0)
            {
                return step;
            }
        }
        
        
        
        
    }
}