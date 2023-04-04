class Solution {
    public int partitionString(String s) {
        
       
        int itr=0;
        int count=0;
        HashSet<Character>set=new HashSet<>();
        while(itr<s.length())
        {
           if(!set.contains(s.charAt(itr)))
           {
               set.add(s.charAt(itr));
               itr++;
           }
            else
            {
                set.clear();
                count++;
                
            }
        }
        return count+1;
}
}