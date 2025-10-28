package topdown;

import java.util.Arrays;

public class BestTimeShellBuyCoolDown {

    public static void main(String[] args) {
        int[] p=new int[]{1,2,3,0,2};
        int[][] memo=new int[p.length+1][2];
        for(int[] row:memo)
            Arrays.fill(row,-1);
        System.out.println(f(p,0,0,memo));
    }
    public static int f(int[] p,int i,int b,int[][] memo){
        if(i>=p.length){
            return 0;
        }
        if(memo[i][b]!=-1){
            return memo[i][b];
        }
        if(b==0){
            return memo[i][b]=Math.max(-p[i]+f(p,i+1,1,memo),f(p,i+1,0,memo));
        }else{
            return memo[i][b]=Math.max(p[i]+f(p,i+2,0,memo),f(p,i+1,1,memo));
        }
    }
}





package bottomup;

public class BestTimeShellBuyCoolDown {

    public static void main(String[] args) {
        int[] p=new int[]{1,2,3,0,2};
        int[][] dp=new int[p.length+2][2];
        for(int i=p.length-1;i>=0;i--){
            for(int b=0;b<2;b++){
                if(b==0){
                    dp[i][b]=Math.max(-p[i]+dp[i+1][1],dp[i+1][0]);
                }else{
                    dp[i][b]=Math.max(p[i]+dp[i+2][0],dp[i+1][1]);
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}





package spaceoptimization;

public class BestTimeShellBuyCoolDown {

    public static void main(String[] args) {
        int[] p=new int[]{1,2,3,0,2};
        int[][] dp=new int[p.length+2][2];
        for(int i=p.length-1;i>=0;i--){
            for(int b=0;b<2;b++){
                if(b==0){
                    dp[i][b]=Math.max(-p[i]+dp[i+1][1],dp[i+1][0]);
                }else{
                    dp[i][b]=Math.max(p[i]+dp[i+2][0],dp[i+1][1]);
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}


