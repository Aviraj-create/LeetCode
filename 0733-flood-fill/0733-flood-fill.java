class Solution {
    boolean visited[][];
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        visited=new boolean[image.length][image[0].length];
        f(image,sr,sc,image[sr][sc],color);
        return image;
    }
    void f(int[][] image,int i,int j,int col,int colour)
    {
        if(i>=image.length || j>=image[0].length || i<0 ||j<0 || image[i][j]!=col || visited[i][j]==true)return;
        
        image[i][j]=colour;
        visited[i][j]=true;
        f(image,i+1,j,col,colour);
        f(image,i,j+1,col,colour);
        f(image,i,j-1,col,colour);
        f(image,i-1,j,col,colour);
    }
}