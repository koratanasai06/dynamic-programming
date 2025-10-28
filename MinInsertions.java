package topdown;

import java.util.Arrays;

public class MinInsertions {

    public static void main(String[] args) {
        String s="mbadm";
        int[][] memo=new int[s.length()][s.length()];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        int result=minInsertions(s,0,s.length()-1,memo);
        System.out.println(result);

        for(int[] row:memo){
            System.out.println(Arrays.toString(row));
        }
    }
    public static int minInsertions(String s,int i,int j,int[][] memo){
        if(i>=j){
            memo[i][j]=0;
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            memo[i][j]= minInsertions(s,i+1,j-1,memo);
        }else{
            int left= 1+minInsertions(s,i,j-1,memo);
            int right= 1+minInsertions(s,i+1,j,memo);
            memo[i][j]= Math.min(left,right);
        }
        return memo[i][j];
    }
}
