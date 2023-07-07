class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        
        Map<Character,Integer> map=new HashMap<>();
        int i=0;
        int maxFre=0;
        for(int j=0;j<s.length();j++)
        {
            char curr=s.charAt(j);
            if(!map.containsKey(curr))
            {
                map.put(curr,0);
            }
            map.put(curr,map.get(curr)+1);
            
            maxFre=Math.max(maxFre,map.get(curr));
            
            
            if(j-i+1>maxFre+k)
            {
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }
        }
        
        return s.length()-i;
        
    }
}