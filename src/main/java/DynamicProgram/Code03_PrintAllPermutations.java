package DynamicProgram;

import java.util.ArrayList;


// 打印一个字符串的所有全排列
public class Code03_PrintAllPermutations {

    public static ArrayList<String> printAllPermutations(String str)
    {
        ArrayList<String> res = new ArrayList<>();
        if(str == null || str.length() == 0){
            return res;
        }
        char[] chs = str.toCharArray();
        process(chs,0,res);
        return res;
    }

    //str[i..]范围上，所有的字符都可以在i位置上，后续都去尝试
    //str[0..i-1]范围上，是之前做的选择
    public static void process(char[] str, int i, ArrayList<String> res){
        if(i == str.length){
            res.add(String.valueOf(str));
            System.out.println(String.valueOf(str));
        }
        boolean[] visit = new boolean[26];
        for(int j = i;j<str.length;j++){
            if(!visit[str[j]-'a']){
                visit[str[j]-'a'] = true;
                swap(str,i,j);
                process(str,i+1,res);
                swap(str,i,j);
            }
        }
    }

    public static void swap(char[] str,int i,int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    public static void main(String[] args) {
        String str = "abca";
        printAllPermutations(str);
    }
}
