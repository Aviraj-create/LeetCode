class Solution {
    public int maxVowels(String s, int k) {
        int maxV=0;
        int temp=Integer.MIN_VALUE;
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        int j=0;
        int i=0;
        for(;i<k;i++)
        {
            if(set.contains(s.charAt(i)))
            {
                maxV++;
            }
        }
        temp=Math.max(temp,maxV);
        while(i!=s.length())
        {
            System.out.println(s.charAt(i)+ " "+ s.charAt(j));
            if(set.contains(s.charAt(i)))
                maxV++;
            if(set.contains(s.charAt(j)))
                maxV--;
            j++;
            i++;
            temp=Math.max(temp,maxV);
        }
        
        return temp;
               
    
}
}