package topdown;

import java.util.Arrays;

public class BestTimeToBuyShell3 {
    public static void main(String[] args) {
        int[] p=new int[]{3,3,5,0,0,3,1,4};
        int[][][] memo=new int[p.length][2][3];

        for(int[][] td:memo)
            for(int[] row:td)
                Arrays.fill(row,-1);

        System.out.println(f(p,0,0,2,memo));
    }
    public static int f(int[] p,int i,int buy,int t,int[][][] memo){
        if(i==p.length ||t==0){
            return 0;
        }
        if(memo[i][buy][t]!=-1){
            return memo[i][buy][t];
        }
        if(buy==0){
            return memo[i][buy][t]=Math.max(-p[i]+f(p,i+1,1,t,memo),f(p,i+1,0,t,memo));
        }else{
            return memo[i][buy][t]=Math.max(p[i]+f(p,i+1,0,t-1,memo),f(p,i+1,1,t,memo));
        }
    }
}



package bottomup;

public class BestTimeToBuyShell3 {
    public static void main(String[] args) {
        int[] p=new int[]{3,3,5,0,0,3,1,4};
        int[][][] dp=new int[p.length+1][2][3];

        //base case all by default 0

        for(int i=p.length-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                for(int t=1;t<3;t++){
                    if(buy==0){
                        dp[i][buy][t]=Math.max(-p[i]+dp[i+1][1][t],dp[i+1][0][t]);
                    }else{
                        dp[i][buy][t]=Math.max(p[i]+dp[i+1][0][t-1],dp[i+1][1][t]);
                    }
                }
            }
        }
        System.out.println(dp[0][0][2]);
    }

}



package spaceoptimization;

public class BestTimeToBuyShell3 {
    public static void main(String[] args) {
        int[] p=new int[]{3,3,5,0,0,3,1,4};
        int[][] prev=new int[2][3],curr=new int[2][3];

        //base case all by default 0

        for(int i=p.length-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                for(int t=1;t<3;t++){
                    if(buy==0){
                        curr[buy][t]=Math.max(-p[i]+prev[1][t],prev[0][t]);
                    }else{
                        curr[buy][t]=Math.max(p[i]+prev[0][t-1],prev[1][t]);
                    }
                }
            }
            prev=curr;
        }
        System.out.println(prev[0][2]);
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





