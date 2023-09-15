class Solution {
    public int largestVariance(String s) {
        int[] map=new int[26];
        for(char ch:s.toCharArray()){
            map[ch-'a']++;
        }
        
        int globalmax=0;
        
        for(int i=0;i<26;i++)
        {
            for(int j=0;j<26;j++)
            {
                if(i==j || map[i]==0 || map[j]==0)continue;
                
                char major=(char)(i+'a');
                char minor=(char)(j+'a');
                
               int major_count=0,minor_count=0,rest_minor=map[j];
                
                for(char ch:s.toCharArray())
                {
                    if(ch==major)
                    {
                        major_count++;
                    }
                    if(ch==minor)
                    {
                        minor_count++;
                        rest_minor--;
                    }
                    
                    if(minor_count>0)
                    {
                        globalmax=Math.max(globalmax,major_count-minor_count);
                    }
                    
                    if(minor_count>major_count && rest_minor>0)
                    {
                        major_count=0;
                        minor_count=0;
                    }
                }
                
                
                
            }
        }
        return globalmax;

    }
}