class Solution {
    public boolean canConstruct(String s1, String s2) {
//         Map<Character,Integer>map1=new HashMap<>();
//         for(int i=0;i<s1.length();i++)
//         {
//             if(!map1.containsKey(s1.charAt(i)))
//             {
//                 map1.put(s1.charAt(i),1);
//             }
//             else
//             {
//                 map1.put(s1.charAt(i),map1.get(s1.charAt(i))+1);
//             }
//         }
        
        
//          Map<Character,Integer>map2=new HashMap<>();
//         for(int i=0;i<s2.length();i++)
//         {
//             if(!map2.containsKey(s2.charAt(i)))
//             {
//                 map2.put(s2.charAt(i),1);
//             }
//             else
//             {
//                 map2.put(s2.charAt(i),map2.get(s2.charAt(i))+1);
//             }
//         }
        
// //         System.out.println(map1);
// //         System.out.println(map2);
        
        
        
//         for (Map.Entry<Character, Integer> it: map1.entrySet())
//         {
//             if(!map2.containsKey(it.getKey()))return false;
//             if(it.getValue()>map2.get(it.getKey()))
//             {
//                 return false;
//             }
//         }
        
        
        
//         return true;
        
        if(s1.length()>s2.length())return false;
        
        int[]alphabetCount=new int[26];
        for(char c:s2.toCharArray())
        {
            alphabetCount[c-'a']++;
        }
         for(char c:s1.toCharArray())
        {
             if(alphabetCount[c-'a']==0)return false;
             alphabetCount[c-'a']--;
        }
        
        return true;
        
        
    }
}