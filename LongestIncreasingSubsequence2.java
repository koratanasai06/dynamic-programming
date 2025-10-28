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





package bottomup;

public class LongestIncreasingSubsequence2 {
    void main(){
        int[] nums=new int[]{4,2,1,4,3,4,5,8,15};
        int k=3;
        int[][] dp=new int[nums.length+1][nums.length+1];
        for(int c=nums.length-1;c>=0;c--){
            for(int p=c-1;p>=-1;p--){
                int len=0;
                if(p==-1 || nums[c]-nums[p]>0 && nums[c]-nums[p]<=k)
                    len=1+dp[c+1][c+1];
                len=Math.max(len,dp[c+1][p+1]);
                dp[c][p+1]=len;
            }
        }
        IO.println(dp[0][0]);
    }
}






package spaceoptimization;

public class LongestIncreasingSubsequence2 {
    void main(){
        int[] nums=new int[]{4,2,1,4,3,4,5,8,15};
        int k=3;
        int[] prev=new int[nums.length+1],cur=new int[nums.length+1];
        for(int c=nums.length-1;c>=0;c--){
            for(int p=c-1;p>=-1;p--){
                int len=0;
                if(p==-1 || nums[c]-nums[p]>0 && nums[c]-nums[p]<=k)
                    len=1+prev[c+1];
                len=Math.max(len,prev[p+1]);
                cur[p+1]=len;
            }
            prev=cur.clone();
        }
        IO.println(prev[0]);
    }
}






package spaceoptimization;

import java.util.Arrays;

public class LongestIncreasingSubsequenceOpt2 {
    void main(){
        int[] nums=new int[]{4,2,1,4,3,4,5,8,15};
        int k=3;
        int[] sodp=new int[nums.length+1];
        Arrays.fill(sodp,1);
        int r=0;
       for(int i=1;i<nums.length;i++){
           for(int j=0;j<i;j++){
               if(nums[i]-nums[j]>0 && nums[i]-nums[j]<=k){
                   sodp[i]=Math.max(sodp[i],sodp[j]+1);
                   r=Math.max(r,sodp[i]);
               }
           }
       }
        IO.println(r);
    }
}



