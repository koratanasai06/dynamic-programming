package topdown;

import java.util.Arrays;

public class BestTimeToBuyShell2 {
    public static void main(String[] args) {
        int[] nums=new int[]{7,1,5,3,6,4};
        int[][] memo = new int[2][nums.length+1];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        System.out.println(f(nums,0,0,memo));
        for(int[]  row:memo){
            System.out.println(Arrays.toString(row));
        }
    }
    public static int f(int[] nums,int i,int buy,int[][] memo){
        if(i==nums.length){
            return memo[buy][i]=0;
        }
        if(memo[buy][i]!=-1){
            return memo[buy][i];
        }
        int profit=Integer.MIN_VALUE;
        if(buy==0){
            profit=Math.max(-nums[i]+f(nums,i+1,1,memo),f(nums,i+1,0,memo));
        }else{
            profit=Math.max(nums[i]+f(nums,i+1,0,memo),f(nums,i+1,1,memo));
        }
        return memo[buy][i]=profit;
    }
}




package bottomup;

import java.util.Arrays;

public class BestTimeToBuyShell2 {
    public static void main(String[] args) {
        int[] nums=new int[]{7,1,5,3,6,4};
        int n=nums.length;
        int[][] dp = new int[2][n+1];
        dp[0][nums.length]=dp[1][n]=0;
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                int profit=Integer.MIN_VALUE;
                if(buy==0){
                    profit=Math.max(-nums[i]+dp[1][i+1],dp[0][i+1]);
                }else{
                    profit=Math.max(nums[i]+dp[0][i+1],dp[1][i+1]);
                }
                dp[buy][i]=profit;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[0][0]);
    }
}



package spaceoptimization;

public class BestTimeToBuyShell2 {
    public static void main(String[] args) {
        int[] nums=new int[]{7,1,5,3,6,4};
        int n=nums.length;
        int[] sodp = new int[2];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                int profit=Integer.MIN_VALUE;
                if(buy==0){
                    profit=Math.max(-nums[i]+sodp[1],sodp[0]);
                }else{
                    profit=Math.max(nums[i]+sodp[0],sodp[1]);
                }
                sodp[buy]=profit;
            }
        }
        System.out.println(sodp[0]);
    }
}


