package topdown;

public class RodCutting {
    public static void main(String[] args) {
        int[] prices=new int[]{2,5,7,8};
        int len=4;
        System.out.println(find(prices,len,3));
    }
    public static int find(int[] prices,int len,int index){
        if(len==0)
            return 0;
        if(index==0)
            return len*prices[0];
        int dontCut=find(prices,len,index-1);
        int cut=Integer.MIN_VALUE;
        if(len>=index+1)
            cut=prices[index] +find(prices,len-(index+1),index);
        return Math.max(cut,dontCut);
    }
}
