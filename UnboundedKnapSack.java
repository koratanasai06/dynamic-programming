package topdown;

import java.util.Arrays;

public class UnboundedKnapSack {
    public static void main(String[] args) {
        int[] weights = new int[]{4,5,9};
        int[] values = new int[]{9,10,20};
        int capacity = 15;
        int[][] memo = new int[weights.length][capacity+1];
        for(int[] m:memo) Arrays.fill(m,-1);
        System.out.println("the maximum amount = "+maxValue(weights,values,weights.length-1,capacity,memo));
    }
    public static int maxValue(int[] weights,int[] values,int index,int capacity,int[][] memo){
        if(capacity==0)return 0;
        if(index==0)
            return (capacity/weights[0])*values[0];
        if(memo[index][capacity]!=-1)return memo[index][capacity];
        int notTake=maxValue(weights,values,index-1,capacity,memo);
        int take=Integer.MIN_VALUE;
        if(capacity>=weights[index]){
            take=values[index]+maxValue(weights,values,index,capacity-weights[index],memo);
        }
        memo[index][capacity]=Math.max(take,notTake);
        return memo[index][capacity];
    }
}
