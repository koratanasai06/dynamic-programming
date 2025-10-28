package topdown;

public class WiggleSubSeq {
    public static void main(String[] args) {
        int[] nums=new int[]{1,17,5,10,13,15,10,5,16,8};
        int n=nums.length;
        System.out.println(find(n-2,nums[n-1]-nums[n-2],nums));
    }
    static int find(int i,int prevDiff,int[] nums){
        if(i==0)
            return 1;
        int curDiff=nums[i]-nums[i-1];
        int pick=0,notPick=0;
        if(curDiff==0 || curDiff<0 && prevDiff<0 || curDiff>0 && prevDiff>0)
            notPick=find(i-1,curDiff,nums);
        else
            pick=1+find(i-1,curDiff,nums);

        return pick+notPick;
    }
}
