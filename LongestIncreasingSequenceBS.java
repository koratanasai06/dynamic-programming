package spaceoptimization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSequenceBS {
    void main(){
        int[] arr=new int[]{1,7,8,4,5,6,-1,9};
        List<Integer> list=new ArrayList<>();
        list.addLast(arr[0]);
        int len=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>list.getLast()){
                list.addLast(arr[i]);
                ++len;
            }else{
                int result=Collections.binarySearch(list,arr[i]);
                if(result<0){
                    result=-result-1;
                    list.set(result,arr[i]);
                }
            }
        }
        System.out.println(len);
    }
}
