class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();

        for(int i=0;i<nums1.length;i++)
        {
            set1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++)
        {
            set2.add(nums2[i]);
        }
        
        List<List<Integer>>answer=new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());
        
        for(int i=0;i<nums1.length;i++)
        {
            if(set2.contains(nums1[i]))
            {
                continue;
            }
            if(!answer.get(0).contains(nums1[i]))
            {
                answer.get(0).add(nums1[i]);
            }
            
        }
        
        for(int i=0;i<nums2.length;i++)
        {
            if(set1.contains(nums2[i]))
            {
                continue;
            }
            if(!answer.get(1).contains(nums2[i]))
            {answer.get(1).add(nums2[i]);}
        }
        
        return answer;
    }
}