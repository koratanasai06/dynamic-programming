package topdown;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums=new int[]{3, 10, 2, 1, 20};
        int[][] memo=new int[nums.length][nums.length];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        System.out.println(f(nums,0,-1,memo));
    }
    public static int f(int[] nums,int c,int p,int[][] memo){
        if(c==nums.length){
            return 0;
        }
        if(memo[c][p+1]!=-1){
            return memo[c][p];
        }
        int len=f(nums,c+1,p,memo);
        if(p==-1 || nums[c]>nums[p]){
            len=Math.max(len,1+f(nums,c+1,c,memo));
        }
        return memo[c][p+1]=len;
    }
}
