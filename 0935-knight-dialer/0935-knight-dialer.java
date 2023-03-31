// class Solution {


//         int[][]board={{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
//         int directions[][]={{1,-2},{1,2},{-1,-2},{-1,2},{2,1},{2,-1},{-2,1},{-2,-1}};

//         int mod=(int)Math.pow(10,9)+7;

//     public int knightDialer(int n) {
//         if(n==1)return 10;

//         long num=0L;
//         long[][] dp=new long[n+1][10];
//         for(int i=0;i<board.length;i++)
//         {
//             for(int j=0;j<board[0].length;j++)
//             {
//                 if(board[i][j]!=-1)
//                 {
//                     num=(num+helper(board[i][j],n-1,i,j,board,dp))%mod;
//                 }
//             }
//         }

//         return (int)num;
        
//     }

//     public long helper(int start,int n,int row,int col,int[][]board,long[][]dp)
//     {
//         if(n==1) return 1L;

//         if(dp[n][start]>0){return dp[n][start];}
//         long ans=0;
//         for(int p[]:directions)
//         {
//             int newRow=row+p[0];
//             int newCol=col+p[1];

//             if(newRow<0 || newRow>board.length-1 || newCol<0 || newCol>board[0].length-1 || board[newRow][newCol]==-1)
//             {
//                 continue;
//             }

//             ans=(ans+helper(board[newRow][newCol],n-1,newRow,newCol,board,dp))%mod;
//         }

//         return dp[n][start]=ans;
//     }
// }

class Solution {
    
    int[][] board = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
    
    int[][] directions = {{1,-2},{1,2},{-1,-2},{-1,2},{2,-1},{2,1},{-2,-1},{-2,1}};

    int mod = (int)Math.pow(10,9)+7;
    
    public int knightDialer(int n) {
       
        if(n == 1){
            return 10;
        }
        
        //start from every number 
        long num = 0;
        long[][] dp = new long[n+1][10];
        for(int i = 0 ; i < board.length ; i++){
            
            for(int j = 0 ; j < board[0].length ; j++){
               if(board[i][j] != -1){
                   num=( num + helper(board[i][j],n,i,j,board,dp))%mod;   
               }
            
            }
        }
        
        return (int)num;
    }
    
    
    public long helper(int start,int n,int row,int col,int[][] board,long[][] dp ){
        
        if(n == 1){
            
            return 1L;
        
        }
        
        if(dp[n][start] >0){
            return dp[n][start];
        }
        long ans = 0;
        
        //do this for all the direction
        for(int[] direc : directions){
            
            int newRow = row + direc[0];
            int newCol = col + direc[1];
            
            if(newRow < 0 || newRow > board.length - 1 || newCol < 0 || newCol > board[0].length - 1
              || board[newRow][newCol] == -1)
            {
                continue;
            }
            
            ans=(ans + helper(board[newRow][newCol],n-1,newRow,newCol,board,dp))%mod;
            
        }
        
        return dp[n][start] = ans;
        
    }
}