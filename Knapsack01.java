package topdown;

import java.util.Arrays;

public class Knapsack01 {
    public static void main(String[] args) {
        int wt = 7;
        int[] weights = new int[]{1, 3, 4, 5};
        int[] values  = new int[]{1, 4, 5, 7};
        int n=values.length;
        int[][] memo=new int[n][wt+1];
        for(int[] row:memo)
            Arrays.fill(row,-1);
        System.out.println(calculate(wt,weights,values,n-1,memo));
    }
    static int calculate(int wt,int[] weights,int [] values,int index,int[][] memo){
        if(wt==0)
            return 0;
        if(index==0)
            return weights[index]<=wt?values[index]:0;
        if(memo[index][wt]!=-1)
            return memo[index][wt];
        int notPick=calculate(wt,weights,values,index-1,memo);
        int pick=Integer.MIN_VALUE;
        if (weights[index]<=wt)
            pick=values[index]+calculate(wt-weights[index],weights,values,index-1,memo);
        memo[index][wt]= Math.max(notPick,pick);
        return memo[index][wt];
    }
}
