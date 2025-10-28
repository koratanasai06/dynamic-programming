package topdown;

import java.util.Arrays;

public class FrogJump {
    static int[] stair=new int[]{10,20,30,40,50,60,70,80,90,100};
    static long[] memo=new long[stair.length];
    public static void main(String[] args) {
        Arrays.fill(memo,-1);
        System.out.println(solve(stair.length-1));
    }
    static long solve(int n){
        if(n==0)
            return 0;
        if(memo[n]!=-1)
            return memo[n];
        long oneStepJump=solve(n-1)+Math.abs(stair[n]-stair[n-1]);
        long twoStepJump= n-2<0?Long.MAX_VALUE:solve(n-2)+Math.abs(stair[n]-stair[n-2]);//no way if n goes to index -1
        memo[n]=Math.min(oneStepJump,twoStepJump);
        return memo[n];
    }
}





package topdown;

import java.util.Arrays;

public class FrogJump {
    static int[] stair=new int[]{10,20,30,40,50,60,70,80,90,100};
    static long[] memo=new long[stair.length];
    public static void main(String[] args) {
        Arrays.fill(memo,-1);
        System.out.println(solve(stair.length-1));
    }
    static long solve(int n){
        if(n==0)
            return 0;
        if(memo[n]!=-1)
            return memo[n];
        long oneStepJump=solve(n-1)+Math.abs(stair[n]-stair[n-1]);
        long twoStepJump= n-2<0?Long.MAX_VALUE:solve(n-2)+Math.abs(stair[n]-stair[n-2]);//no way if n goes to index -1
        memo[n]=Math.min(oneStepJump,twoStepJump);
        return memo[n];
    }
}






package spaceoptimization;

public class FrogJump {
    public static void main(String[] args) {
        int[] stair=new int[]{10,20,30,40,50,60,70,80,90,100};
       int prev1=0;
       int prev2= Math.abs(stair[0]-stair[1]);
        for(int i=2;i<stair.length;i++){
            int oneStep=prev2+Math.abs(stair[i-1]-stair[i]);
            int twoStep=prev1+Math.abs(stair[i-2]-stair[i]);
            int cur=Math.min(oneStep,twoStep);
            prev1=prev2;
            prev2=cur;
        }
        System.out.println(prev2);
    }
}

