class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        if(n<=2)return true;
        
        int first=arr[0];
        int second=arr[1];
        
        for(int i=1;i<n-1;i++)
        {
            if(arr[i]-arr[i+1]!=first-second)return false;
        }
        return true;
    }
}