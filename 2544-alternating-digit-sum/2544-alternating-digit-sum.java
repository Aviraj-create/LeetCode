class Solution {
    public int alternateDigitSum(int n) {
        
       String str = Integer.toString(n);  
       int[] digits = new int[str.length()];

    
    for (int i = 0; i < str.length(); i++) {
        digits[i] = Character.getNumericValue(str.charAt(i));
    }
        int temp=0;
        boolean flag=false;
        for(int i=0;i<digits.length;i++)
        {
            if(flag==false)
            {
                temp+=digits[i];
                flag=true;
            }
            else
            {
                temp-=digits[i];
                flag=false;
            }
        }
        
        return temp;
    }
}