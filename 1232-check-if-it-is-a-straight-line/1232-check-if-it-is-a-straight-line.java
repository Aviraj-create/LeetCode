class Solution {
    public boolean Line(int[] p,int[]p1,int[]p2)
    {
        int y=p[1], x=p[0],y1=p1[1],x1=p1[0],y2=p2[1],x2=p2[0];
        
        return ((y-y1)*(x2-x1)==(x-x1)*(y2-y1));
    }
    public boolean checkStraightLine(int[][] c) {
        if(c.length==2)return true;
        for(int temp[]:c)
        {
            if(!Line(temp,c[1],c[0]))return false;
        }
        return true;
    }
}