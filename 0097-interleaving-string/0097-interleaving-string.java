class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        HashMap<String,Boolean> map=new HashMap<>();
        if(s1.length()+s2.length()!=s3.length())return false;
        
        return f(0,0,0,s1,s2,s3,map);
    }
    
    boolean f(int i1,int i2,int i3,String s1,String s2, String s3,HashMap<String,Boolean> map)
    {
        if(i1==s1.length() && i2==s2.length() && i3==s3.length())return true;
        
        if(i1==s1.length())
        {
            return s2.substring(i2).equals(s3.substring(i3));
        }
        if(i2==s2.length())
        {
           return s1.substring(i1).equals(s3.substring(i3));
        }
        
        String key=i1+" "+i2+" "+i3;
        if(map.containsKey(key)){
            return map.get(key);
        }
        
        boolean res=false;
        if(s3.charAt(i3)==s2.charAt(i2))
        {
            res=res|| f(i1,i2+1,i3+1,s1,s2,s3,map);
            if(res)return res;
        }
        if(s3.charAt(i3)==s1.charAt(i1))
        {
            res=res|| f(i1+1,i2,i3+1,s1,s2,s3,map);
             if(res)return res;
        }
        map.put(key,res);
        return res;
    }
}