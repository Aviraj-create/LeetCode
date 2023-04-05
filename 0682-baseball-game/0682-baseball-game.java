class Solution {
    public int calPoints(String[] operations) {
        
        ArrayList<Integer>arr=new ArrayList<>();
        for(String op:operations)
        {
            if(op.equals("C"))
            {
                arr.remove(arr.size()-1);
            }
            else if(op.equals("D"))
            {
                int temp=2*arr.get(arr.size()-1);
                arr.add(temp);
            }
            else if(op.equals("+"))
            {
                int temp=arr.get(arr.size()-1)+arr.get(arr.size()-2);
                arr.add(temp);
            }
            else
            {
                arr.add(Integer.parseInt(op));
            }
        }
       int sum = arr.stream().mapToInt(Integer::intValue).sum();
        return sum;
        
    }
}