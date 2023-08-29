class Solution {
    public int bestClosingTime(String s) {
        int left_y=0,left_n=0,right_y=0,right_n=0;
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='Y')right_y++;
            else{
                right_n++;
            }
        }
        int[] prefix=new int[s.length()+1];
        prefix[0]=right_y;
        for(int i=1;i<prefix.length;i++)
        {
            if(s.charAt(i-1)=='Y')
            {
                left_y++;
                right_y--;
            }
            else
            {
                left_n++;
                right_n--;
            }
            
            prefix[i]=left_n+right_y;
        }
        int earliest=0;
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<prefix.length;i++)
        {
            if(prefix[i]<min)
            {
                min=prefix[i];
                earliest=i;
            }
        }
        return earliest;
        
        
    }
}