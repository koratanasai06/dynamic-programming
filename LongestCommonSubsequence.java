package topdown;

import java.util.Arrays;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
       String s1="ABCBDAB";
       String s2="BDCABA";
       int[][] memo=new int[s1.length()][s2.length()];
       for(int[] row:memo){
           Arrays.fill(row,-1);
       }
       System.out.println(find(s1.length()-1,s2.length()-1,s1,s2,memo));
    }
    public static int find(int i,int j,String s1,String s2,int[][] memo){
        if(i<0 || j<0){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j))
            memo[i][j]=1+find(i-1,j-1,s1,s2,memo);
        else
            memo[i][j]=Math.max(find(i-1,j,s1,s2,memo),find(i,j-1,s1,s2,memo));
        return  memo[i][j];
    }
}
