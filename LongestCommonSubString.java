package topdown;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubString {
    static Map<String,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        String s1="abcjklp";
        String s2="acjkp";
        int result=find(s1.length(),s2.length(),s1.toCharArray(),s2.toCharArray(),0);
        System.out.println(result);
    }
    public static int find(int i,int j,char[] s1,char[] s2,int count) {
        if (i == 0 || j == 0)
            return count;
        String key=i+"|"+j+"|"+count;
        if(map.containsKey(key))
            return map.get(key);
        int currentCount=count;
        if (s1[i - 1] == s2[j - 1])
            currentCount=find(i-1,j-1,s1,s2,count+1);
        int result=Math.max(currentCount,Math.max(find(i-1,j,s1,s2,0)
                                                    ,find(i,j-1,s1,s2,0)));
         map.put(key,result);
         return result;
    }
}
