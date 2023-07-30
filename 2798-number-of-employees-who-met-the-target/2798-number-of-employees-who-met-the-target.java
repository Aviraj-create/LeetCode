class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int i=0;
        Arrays.sort(hours);
        for(;i<hours.length;i++)
        {
            if(hours[i]>=target)break;
        }
        return hours.length-i;
    }
}