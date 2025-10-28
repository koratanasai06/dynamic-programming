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
