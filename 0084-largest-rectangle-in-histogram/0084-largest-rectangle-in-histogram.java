class Solution {
    public int largestRectangleArea(int[] A) {
       
        int n=A.length;
        int[] leftsmaller=new int[n];
        Stack<Integer> st=new Stack();
        for(int i=0;i<n;i++)
        {
            if(st.empty())
            {
                leftsmaller[i]=0;
                st.push(i);
                continue;
            }
            while(!st.empty() && A[st.peek()]>=A[i])
            {
                st.pop();
            }
            if(st.empty())
            {
                leftsmaller[i]=0;
            }
            else
            {
                leftsmaller[i]=st.peek()+1;
                
            }
            st.push(i);
            
        }
        
        st.clear();
        
        int[] rightsmaller=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            if(st.empty())
            {
                rightsmaller[i]=n-1;
                st.push(i);
                continue;
            }
            while(!st.empty() && A[st.peek()]>=A[i])
            {
                st.pop();
            }
            if(st.empty())
            {
                rightsmaller[i]=n-1;
            }
            else
            {
                rightsmaller[i]=st.peek()-1;
                
            }
            st.push(i);
        }
        // for(int i=0;i<n;i++)
        // {
        //      System.out.print(leftsmaller[i]);       
        // }
        // System.out.println(" ");
        // for(int i=0;i<n;i++)
        // {
        //      System.out.print(rightsmaller[i]);       
        // }
        
        int max=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,((Math.abs(leftsmaller[i]-rightsmaller[i])+1)*A[i]));
        }
       
        
        return max;
    }
        
    }
