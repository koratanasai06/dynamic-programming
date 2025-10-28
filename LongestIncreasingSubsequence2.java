package topdown;

import java.util.Arrays;

public class LongestIncreasingSubsequence2 {
    void main(){
        int[] arr=new int[]{4,2,1,4,3,4,5,8,15};
        int[][] memo=new int[arr.length][arr.length];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        int k=3;
        IO.println(f(0,-1,3,arr,memo));
    }
    int f(int c,int p,int k,int[] nums,int[][] memo){
        if(c==nums.length)
            return 0;
        if(memo[c][p+1]!=-1)
            return memo[c][p+1];
        int len=0;
        if(p==-1 || nums[c]-nums[p]>0 && nums[c]-nums[p]<=k)
            len=1+f(c+1,c,k,nums,memo);
        len=Math.max(len,f(c+1,p,k,nums,memo));
        return memo[c][p+1]=len;
    }
}
