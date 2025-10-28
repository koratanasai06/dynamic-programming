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
