package topdown;

import java.util.Arrays;

public class MinCoins {
    public static void main(String[] args) {
        int[] coins=new int[]{9,6,5,1};
        int target=13;
        int[][] memo=new int[coins.length][target+1];
        for(int[] arr:memo){
            Arrays.fill(arr,-1);
        }
        System.out.println("Minimum Number of Coins  : "+ minCoins(coins,target,coins.length-1,memo));
    }
    public static int minCoins(int[] coins,int target,int index,int[][] memo){
        if(target==0){
            return 0;
        }
        if(index==0){
             if(target%coins[index]==0)
                 return target/coins[index];
             return Integer.MAX_VALUE;
        }
        if(memo[index][target]!=-1){
            return memo[index][target];
        }
        int pick=Integer.MAX_VALUE;
        if(target>=coins[index]) {
            pick=minCoins(coins, target - coins[index], index,memo);
            if(pick!=Integer.MAX_VALUE)
                pick+=1;
        }
        int notPick=minCoins(coins,target,index-1,memo);
        memo[index][target]=Math.min(notPick,pick);
        return memo[index][target];
    }
}
