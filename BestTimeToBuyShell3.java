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
