class Solution {
    public int isWinner(int[] p1, int[] p2) {
        
        int sc1=0;
        int sc2=0;
        int n=p1.length;
        
        for(int i=0;i<n;i++)
        {
            if(i>=1 && p1[i-1]==10)
            {
                sc1 = sc1 + p1[i] * 2;
                continue;
            }
            if(i>=2 && p1[i-2]==10)
            {
                sc1 = sc1 + p1[i] * 2;
                continue;
            }
            sc1 = sc1 + p1[i] ;
            
        }
        
        for(int i=0;i<n;i++)
        {
            if(i>=1 && p2[i-1]==10)
            {
                sc2 = sc2 + p2[i] * 2;
                continue;
            }
            if(i>=2 && p2[i-2]==10)
            {
                sc2 = sc2 + p2[i] * 2;
                continue;
            }
            sc2 = sc2 + p2[i] ;
        }
        
        if(sc1>sc2)return 1;
        if(sc2>sc1)return 2;
        return 0;
    }
}