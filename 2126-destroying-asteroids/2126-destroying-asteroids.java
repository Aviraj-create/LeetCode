class Solution {
    public boolean asteroidsDestroyed(int mass, int[] a) {
        Arrays.sort(a);
        long sum =0L;
        sum+=mass;
        for(int i=0;i<a.length;i++)
        {
            if(sum>=a[i])
            {
                sum+=a[i];
                continue;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}