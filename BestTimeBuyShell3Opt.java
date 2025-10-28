package topdown;

import java.util.Arrays;

public class BestTimeBuyShell3Opt {
    public static void main(String[] args) {
        int[] p=new int[]{3,3,5,0,0,3,1,4};
        int[][] memo=new int[p.length+1][5];

        for(int[] row:memo)
            Arrays.fill(row,-1);

        System.out.println(f(p,0,0,memo));
    }
    public static int f(int[] p,int i,int t,int[][] memo){
        if(i==p.length ||t==4){
            return 0;
        }
        if(memo[i][t]!=-1){
            return memo[i][t];
        }
        if(t%2==0){
            return memo[i][t]=Math.max(-p[i]+f(p,i+1,t+1,memo),f(p,i+1,t,memo));
        }else{
            return memo[i][t]=Math.max(p[i]+f(p,i+1,t+1,memo),f(p,i+1,t,memo));
        }
    }
}





package bottomup;

public class BestTimeBuyShell3Opt {
    public static void main(String[] args) {
        int[] p=new int[]{3,3,5,0,0,3,1,4};
        int[][] dp=new int[p.length+1][5];
        //base case already 0

        for(int i=p.length-1;i>=0;i--){
            for(int t=3;t>=0;t--){
                if(t%2==0){
                    dp[i][t]=Math.max(-p[i]+dp[i+1][t+1],dp[i+1][t]);
                }else{
                    dp[i][t]=Math.max(p[i]+dp[i+1][t+1],dp[i+1][t]);
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}




package spaceoptimization;

public class BestTimeBuyShell3Opt {
    public static void main(String[] args) {
        int[] p=new int[]{3,3,5,0,0,3,1,4};
        int[] prev=new int[5],curr=new int[5];

        //base case already 0

        for(int i=p.length-1;i>=0;i--){
            for(int t=3;t>=0;t--){
                if(t%2==0){
                    curr[t]=Math.max(-p[i]+prev[t+1],prev[t]);
                }else{
                    curr[t]=Math.max(p[i]+prev[t+1],prev[t]);
                }
            }
            prev=curr.clone();
        }

        System.out.println(curr[0]);

    }
}
