package topdown;

public class NoOfWays {
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        int[][] dp = new int[5][5];
        System.out.println("""
                the number of ways is to reach from first to last:
                """+ways(arr,4,4,dp));

    }
    static int ways(int[][] arr,int row,int col,int[][] dp){
        if(row==0 && col==0){
            return 1;
        }
        if(col<0||row<0)
            return 0;
        if(dp[row][col]!=0){
            return dp[row][col];
        }
        dp[row][col]=ways(arr,  row-1,col,dp)+ways(arr,row,col-1,dp);
        return dp[row][col];
    }
}
