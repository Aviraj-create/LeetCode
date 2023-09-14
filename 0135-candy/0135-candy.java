class Solution {
    public int candy(int[] ratings) {
        
        int n=ratings.length;
        
        int LP[]=new int[n];
        int RP[]=new int[n];
       Arrays.fill(LP,1);
       Arrays.fill(RP,1); 
        
        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1])
            {
                LP[i]=LP[i-1]+1;
            }
        }
        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
            {
                RP[i]=RP[i+1]+1;
            }
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            count+=Math.max(RP[i],LP[i]);
        }
        return count;
        
    }
}