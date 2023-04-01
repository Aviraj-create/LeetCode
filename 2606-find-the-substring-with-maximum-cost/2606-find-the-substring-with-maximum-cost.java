class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        
       
        
//         HashMap<Character,Integer>map=new HashMap<>();
        
//         for(int i=0;i<chars.length();i++)
//         {
//             map.put(chars.charAt(i),vals[i]);
//         }
//         int maxCost=0;
//         int cost=0;
//         if(s.length()==0){
//             return 0;
//         }
        
//         for(int i=0;i<s.length();i++)
//         {
//             if(map.containsKey(s.charAt(i)))
//             {
//                 if(map.get(s.charAt(i))<0)
//                 {
//                     maxCost=Math.max(maxCost,cost);
//                     cost=0; 
//                 }
//                 else
//                 {
//                     cost+=map.get(s.charAt(i));
//                 }
//             }
//             else
//             {
//                 cost+=s.charAt(i)-'a'+1;
//             }
//         }
        
//         return maxCost;
        
        int[]arr=new int[100001];
        for(int i=0;i<s.length();i++)
        {
            if(chars.contains(s.charAt(i)+"")){arr[i]=vals[chars.indexOf(s.charAt(i))];}
            else
            {
                arr[i]=(s.charAt(i)-'a'+1);
            }
            
        }
        
        int sum=0;
            int  max=Integer.MIN_VALUE;
            
            for(int i=0;i<s.length();i++)
            {
                sum+=arr[i];
                max=Math.max(max,sum);
                if(sum<0){sum=0;}
            }
        
        return max<0?0:max;
        
        
    }
}