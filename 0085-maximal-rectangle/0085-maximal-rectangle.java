class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] matrix1=new int[matrix.length][matrix[0].length];
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]=='0')
                {
                    matrix1[i][j]=0;
                }
                else
                {
                    matrix1[i][j]=1;
                }
            }
        }
        int max=0;
        max=Math.max(max,f(matrix1[0]));
        for(int i=1;i<matrix1.length;i++)
        {
            
            
            // int[] temp=new int[matrix[0].length];
            
            for(int j=0;j<matrix1[0].length;j++)
            {
                if(matrix1[i][j]!=0)
                {
                    matrix1[i][j]+=matrix1[i-1][j];
                }    
            }
            max=Math.max(max,f(matrix1[i]));
            
            
        }
        return max;
        
    }
    
   public int f(int[] A)
    {
         {
       
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
       
        
        int max=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,((Math.abs(leftsmaller[i]-rightsmaller[i])+1)*A[i]));
        }
       
        
        return max;
    }
    }
}