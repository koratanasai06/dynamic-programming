package topdown;
import java.util.Arrays;

public class MaxSumOfNonAdjElements {
    static int[] arr=new int[]{3,2,7,10};
    static int[] memo=new int[arr.length];
    public static void main(String[] args) {
        Arrays.fill(memo,-1);
        System.out.println(maxSum(arr.length-1));
    }
    static int maxSum(int index){
        if(index<0)
            return 0;
        if(index==0)
            return arr[index];
        if(memo[index]!=-1)
            return memo[index];

        int pick=arr[index]+maxSum(index-2);
        int notPick=maxSum(index-1);
        memo[index]= Math.max(pick,notPick);
        return memo[index];
    }
}
