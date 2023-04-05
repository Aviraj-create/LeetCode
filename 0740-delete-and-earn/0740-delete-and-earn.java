
// class Solution {
    
//     public int f(int index,ArrayList<Integer>arr,HashMap<Integer,Integer>map)
//     {
//         if(arr.size()==0)return 0;
        
        
        
//     }
//     public int deleteAndEarn(int[] nums) {
//         HashMap<Integer,Integer>map=new HashMap<>();
//         ArrayList<Integer>arr=new ArrayList<>();
//         for(int num:nums)
//         {
//             arr.add(num);
            
//             if(!map.containsKey(num))
//             {
//                 map.put(num,1);
//             }
//             else
//             {
//                 map.put(num,map.get(num)+1);
//             }
//         }
        
//         int points=0;
        
//     }
// }
class Solution {
  public int deleteAndEarn(int[] nums) {
    // Reduce to 198. House Robber
    int[] bucket = new int[10001];

    for (final int num : nums)
      bucket[num] += num;

    int prev1 = 0;
    int prev2 = 0;

    for (final int num : bucket) {
      final int dp = Math.max(prev1, prev2 + num);
      prev2 = prev1;
      prev1 = dp;
    }

    return prev1;
  }
}
