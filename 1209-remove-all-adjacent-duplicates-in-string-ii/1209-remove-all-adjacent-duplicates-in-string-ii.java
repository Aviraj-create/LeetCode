class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stchar=new Stack();
        Stack<Integer> stint=new Stack();
        
        for(char ch:s.toCharArray())
        {
            if(stchar.size()>0 && stchar.peek()==ch)
            {
                stint.push(stint.peek()+1);
            }
            else
            {
                stint.push(1);
            }
            stchar.push(ch);
            
            if(stint.peek()==k)
            {
                for(int i=0;i<k;i++)
                {
                    stint.pop();
                    stchar.pop();
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stchar.isEmpty())
        {
            sb.append(stchar.peek());
            stchar.pop();
        }
        
        return sb.reverse().toString();
    }
}