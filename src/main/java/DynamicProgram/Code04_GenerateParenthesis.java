package DynamicProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class Code04_GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        process(n,new StringBuilder(),res,0,0);
        return res;
    }
    public static void process(int n,StringBuilder cur,List<String> res,int open,int close){
        if(cur.length() == 2*n){
            res.add(cur.toString());
            return;
        }
        if(open<n){
            cur.append('(');
            process(n,cur,res,open+1,close);
            cur.deleteCharAt(cur.length()-1);
        }
        if(close<open){
            cur.append(')');
            process(n,cur,res,open,close+1);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> res = generateParenthesis(n);
        for(String str : res){
            System.out.println(str);
        }
    }
}
