//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        Map<Integer,Integer> map=new HashMap<>();
        int[] temp=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            temp[i]=nums[i];
            map.put(nums[i],i);
        }
        int ans=0;
        Arrays.sort(temp);
        
        for(int i=0;i<nums.length;i++)
        {
            if(temp[i]!=nums[i])
            {
                ans++;
                int initial=nums[i];
                
               
                nums[i] = nums[map.get(temp[i])];
                nums[map.get(temp[i])] = initial;
                
                map.put(initial, map.get(temp[i]));
                map.put(temp[i], i);
            }
        }
        return ans;
    }
}
