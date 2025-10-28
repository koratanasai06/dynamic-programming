package topdown;

public class EditDistance {
    public static void main(String[] args) {
        String str1="saturday";
        String str2="sunday";
        int[][] cache=new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<=str1.length();i++)
            for(int j=0;j<=str2.length();j++)
                cache[i][j]=-1;
        System.out.println(
                String.format(
                        """
                        number of operations required
                        to change String 1-> %s to String 2->%s are :%d
                        """,str1,str2,editDistance(str1,str2,str1.length(),str2.length(),cache)
                )
        );
    }
    static int editDistance(String str1,String str2,int i, int j,int[][] cache){
        if(i==0) return j;//insert all chars
        if(j==0) return i;//delete all chars

        if(cache[i][j]!=-1) return cache[i][j];

        if(str1.charAt(i-1)==str2.charAt(j-1))
            cache[i][j]= editDistance(str1,str2,i-1,j-1,cache);
        else{
            int insert=editDistance(str1,str2,i,j-1,cache);
            int delete=editDistance(str1,str2,i-1,j,cache);
            int replace=editDistance(str1,str2,i-1,j-1,cache);
            cache[i][j]=Math.min(insert,Math.min(delete,replace))+1;
        }
        return cache[i][j];
    }
}
