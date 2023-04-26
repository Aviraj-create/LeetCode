class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> lists=new ArrayList<>();
        List<String>list=new ArrayList<>();
        
        f(0,s,lists,list);
        return lists;
    }
    
    public void f(int idx,String s,List<List<String>>lists,List<String>list)
    {
        if(idx==s.length())
        {
            
            lists.add(new ArrayList< >(list));
            return;
        }
        
        for(int i=idx;i<s.length();i++)
        {
            if(isPali(s,idx,i))
            {
                list.add(s.substring(idx,i+1));
                f(i+1,s,lists,list);
                list.remove(list.size()-1);
            }
        }
    }
    
    public boolean isPali(String s,int idx,int i)
    {
        while(idx<=i)
        {
            if(s.charAt(idx++)!=s.charAt(i--))
                return false;
        }
        return true;
    }
    
    
    
    
}