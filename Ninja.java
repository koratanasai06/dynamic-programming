package topdown;

import java.util.Arrays;

public class Ninja {
    static  int[][] dayVacation = {
            {10,20,5},
            {100,200,50},
            {30,40,20},
    };
    static int[][] memo=new int[dayVacation.length][4];
    public static void main(String[] args) {
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        System.out.println(find(dayVacation.length-1,3));
    }
    static int find(int row,int col){
        if(row<0)
            return 0;
        if(memo[row][col]!=-1)
            return memo[row][col];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            if(col!=i){
                int temp=dayVacation[row][i]+find(row-1,i);
                max=Math.max(max,temp);
            }
        }
        memo[row][col]=max;
        return memo[row][col];
    }
}
