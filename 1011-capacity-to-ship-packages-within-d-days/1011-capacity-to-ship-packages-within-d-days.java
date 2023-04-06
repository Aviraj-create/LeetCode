class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for(int i:weights){
            left = Math.max(left,i);
            right += i;
        }
        
        int mid;
        int ans = right;
        while(left<=right){
            mid=(left+right)/2;
            if(check(weights,days,mid)==true){
                ans = mid;
                right = mid-1;
            }else left=mid+1;
        }
        return ans;
    }

     private boolean check(int[] weights,int days,int capacity){
        int requiredDays = 1;
        int currentweight = 0;
        for(int i:weights){
            if(currentweight+i>capacity){
                requiredDays++;
                currentweight=0;
            }
            currentweight+=i;
        }
        if(requiredDays>days)return false;
        else return true;
    }
}