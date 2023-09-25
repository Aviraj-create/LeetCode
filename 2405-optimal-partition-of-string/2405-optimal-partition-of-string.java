class Solution {
    public int partitionString(String s) {
        int count=1;
        Set<Character> set=new HashSet<>();
        
        for(char ch:s.toCharArray())
        {
            if(!set.contains(ch))
            {
                set.add(ch);    
            }
            else
            {
                count++;
                set.clear();
                set.add(ch);
            }
        }
        return count;
    }
}