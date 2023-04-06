class Solution {
    public long distinctNames(String[] ideas) {
        
        HashSet<Integer>[] hash=new HashSet[26];
        
        for(int i=0;i<26;i++)
        {
           hash[i]=new HashSet<>();
        }
        
        for(String s:ideas)
        {
            hash[s.charAt(0)-'a'].add(s.substring(1).hashCode());
        }
        
        long res=0L;
        
        for(int i=0;i<26;i++)
        {
            for(int j=0;j<26;j++)
            {
                long c1=0,c2=0;
                
                for(int c:hash[i])
                {
                    if(!hash[j].contains(c)) c1++;
                }
                for(int c:hash[j])
                {
                    if(!hash[i].contains(c)) c2++;
                }
                
                res+=c1*c2;
            }
        }
        
        return res;
        
    }
}