// class Pair{
//     char ch;
//     int freq;
//     public Pair(char ch,int freq)
//     {
//         this.ch=ch;
//         this.freq=freq;
//     }
// }
class Solution {
    public int minDeletions(String s) {
        
       HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray())
        {
            if(!map.containsKey(ch))
            {
                map.put(ch,0);
            }
            map.put(ch,map.get(ch)+1);
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        for(Integer a:map.values())
        {
            ans.add(a);
        }
        Collections.sort(ans);
        int count=0;
        Set<Integer> visited=new HashSet<>();
        for(int i=0;i<ans.size();i++)
        {
            if(ans.get(i)==0)continue;
            if(!visited.contains(ans.get(i)))
            {
                visited.add(ans.get(i));
            }
            else
            {
                count++;
                ans.set(i, ans.get(i)-1);
                i--;
            }
        }
        return count;
        
    }
}