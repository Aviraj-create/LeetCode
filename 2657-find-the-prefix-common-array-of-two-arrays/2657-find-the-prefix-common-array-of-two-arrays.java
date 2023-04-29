class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> ofA=new HashSet<>();
        Set<Integer> ofB=new HashSet<>();
        
        int n=A.length;
        int[] c=new int[n];
        int tillNow=0;
        for(int i=0;i<n;i++)
        {
            if(A[i]!=B[i])
            {
                
                ofA.add(A[i]);
                ofB.add(B[i]);
                
                if(ofA.contains(B[i]))
                {
                    tillNow++;
                }
                if(ofB.contains(A[i]))
                {
                    tillNow++;
                }
            }
            else
            {
                ofA.add(A[i]);
                ofB.add(B[i]);
                
                tillNow++;
            }
            
            
            
            
            c[i]=tillNow;
        }
              
        
        return c;
    }
}