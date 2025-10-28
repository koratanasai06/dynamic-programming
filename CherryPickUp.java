package topdown;

public class CherryPickUp {
    public static void main(String[] args) {
        int[][] grid = {
                {3, 1, 1},
                {2, 5, 1},
                {1, 5, 5},
                {2, 1, 1}
        };
        System.out.println(solve(0,0,grid[0].length-1,grid.length,grid[0].length,grid));
    }
    static int solve(int row,int col1,int col2,int n,int m,int[][] grid){

        //pruning
        if(col1<0||col1>=m||col2<0||col2>=m)
            return Integer.MIN_VALUE;

        //base case
        if(row==n-1){
            if(col1==col2)
                return grid[row][col1];
            else
                return grid[row][col1]+grid[row][col2];
        }
        int cur=col1==col2?grid[row][col1]:grid[row][col1]+grid[row][col2];
        int max=Integer.MIN_VALUE;
        for(int j=-1;j<2;j++){
            for(int k=-1;k<2;k++){
                max=Math.max(solve(row+1,col1+j,col2+k,n,m,grid)
                        +cur,max);
            }
        }
        return max;
    }
}
