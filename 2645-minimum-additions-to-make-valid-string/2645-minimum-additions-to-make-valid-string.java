class Solution {
    public int addMinimum(String word) {
   int k=0;
    char prev='z';
        int n=word.length();
        
        for(int i=0;i<n;i++)
        {
            k+=word.charAt(i)<=prev?1:0;
            prev=word.charAt(i);
        }
        return k*3-n;
        
//         return k*3-n;
        // int n=s.length();
        // int i=0;
        // int ans=0;
        // while(i<n)
        // {
        //     String s1=s.substring(i,i+2);
        //     if(s.substring(i,i+3)=="abc")
        //     {
        //         i+=3;
        //     }
        //     else if(s1=="ab" || s1=="ac" || s1=="bc")
        //     {
        //         ans+=1;
        //         i+=2;
        //     }
        //     else
        //     {
        //         ans+=2;
        //         i+=1;
        //     }
        
        
        
    }
}
