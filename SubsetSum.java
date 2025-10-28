package topdown;

import java.util.Arrays;

public class SubsetSum {
    public static void main(String[] args) {
        int[] set=new int[]{4,5,2};
        int target=0;
        Boolean[][] memo=new Boolean[target+1][set.length];
        for(Boolean[] row:memo)
            System.out.println(Arrays.toString(row));
        System.out.println();
        System.out.println(isSubsetSum(set,target,set.length-1,memo));
        System.out.println();
        for(Boolean[] row:memo)
            System.out.println(Arrays.toString(row));
    }
    static boolean isSubsetSum(int[] set, int target, int index, Boolean[][] memo) {
        if(memo[target][index]!=null)
            return memo[target][index];

        if(target == 0){
            memo[target][index]=true;
            return memo[target][index];
        }

        if(index == 0){
            memo[target][index]=set[0] == target;
            return memo[target][index];
        }

        boolean notPick=isSubsetSum(set,target,index-1,memo);
        boolean pick=set[index]<=target &&
                isSubsetSum(set,target-set[index],index-1,memo);
        memo[target][index]=notPick||pick;

        return memo[target][index];
    }
}
