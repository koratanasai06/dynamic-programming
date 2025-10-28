package topdown;

import java.util.Arrays;

public class DistinctSubSeqence {
    public static void main(String[] args) {
        String s="rabbbit";
        String t="rabbit";
        int[][] memo=new int[s.length()][t.length()];
        for(int[] row:memo)
            Arrays.fill(row,-1);
        System.out.println(count(s,s.length()-1,t,t.length()-1,memo));
    }
    static int count(String s,int i,String t,int j,int[][] memo){
        if(j<0)
            return 1;
        if(i<0)
            return 0;
        if(memo[i][j]!=-1)
            return memo[i][j];

        int pick=0;
        if(s.charAt(i)==t.charAt(j))
            pick=count(s,i-1,t,j-1,memo);
        int notPick=count(s,i-1,t,j,memo);

        memo[i][j]=pick+notPick;

        return memo[i][j];

    }
}





package bottomup;

public class DistinctSubSeqence {
    public static void main(String[] args) {
        String s="rabbbit";
        String t="rabbit";
        int[][] memo=new int[s.length()][t.length()];
        if(s.charAt(0) == t.charAt(0)){
            memo[0][0]=1;
        }
        for(int i=1;i<s.length();i++){
            for(int j=0;j<t.length();j++){
                if(j<=i){
                    int pick=0;
                    if(s.charAt(i)==t.charAt(j))
                        pick=memo[i-1][j-1];
                    int notPick=memo[i-1][j];

                    memo[i][j]=pick+notPick;
                }
            }
        }
        System.out.println(memo[s.length()-1][t.length()-1]);
    }
}


