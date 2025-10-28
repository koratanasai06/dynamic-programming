package topdown;

import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] grid=new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        int[][] memo=new int[grid.length][grid[0].length];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        System.out.println(solve(grid,grid.length-1,grid[0].length-1,memo));
    }
    static int solve(int[][] grid,int row,int col,int[][] memo){
        if(row<0 || col<0)
            return Integer.MAX_VALUE;
        if(row==0&& col==0)
            return grid[row][col];
        if(memo[row][col]!=-1)
            return memo[row][col];
        int up=solve(grid,row-1,col,memo);
        int left=solve(grid,row,col-1,memo);
        memo[row][col]=Math.min(up,left)+grid[row][col];
        return memo[row][col];
    }
}
