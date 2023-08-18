class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++)
        {
            int[] arr=roads[i];
            map.get(arr[0]).add(arr[1]);
            map.get(arr[1]).add(arr[0]);
        }
        int ans=0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
               int rank=map.get(i).size()+map.get(j).size();
                if(map.get(i).contains(j) || map.get(j).contains(i))
                {
                    rank--;
                }
                ans=Math.max(rank,ans);
                 
                
            }
        }
        return ans;
    }
}