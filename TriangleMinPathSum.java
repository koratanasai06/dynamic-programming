package topdown;

import java.util.Arrays;
import java.util.List;

public class TriangleMinPathSum {
    public static void main(String[] args) {

        List<List<Integer>> triangle = List.of(
                List.of(2),
                List.of(3,4),
                List.of(6,5,7),
                List.of(4,1,8,3)
        );
        int[][] memo=new int[triangle.size()][triangle.size()];
        for(int[] row:memo)
            Arrays.fill(row,-1);
        System.out.println(solve(triangle,0,0,memo));
    }
    public static int solve(List<List<Integer>> triangle,int row,int col,int[][] memo){

        //base case;
        if(row==triangle.size()-1)
            return triangle.get(row).get(col);
        if(memo[row][col]!=-1)
            return memo[row][col];

        int vdown=solve(triangle,row+1,col,memo);
        int drdown=solve(triangle,row+1,col+1,memo);
        memo[row][col]=Math.min(vdown,drdown)+triangle.get(row).get(col);
        return memo[row][col];
    }
}
