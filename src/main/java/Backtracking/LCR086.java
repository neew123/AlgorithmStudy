package Backtracking;

import java.util.ArrayList;
import java.util.List;

/** 分割回文串
 * 给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class LCR086 {
    public  List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> cur = new ArrayList<>();
        int startIndex = 0;
        backTracing(res,s,cur,startIndex);
        return res;
    }

    void backTracing(List<List<String>> res,String s,List<String> cur,int startIndex){
        //分割线到结尾
        if(startIndex>=s.length()){
            res.add(new ArrayList<>(cur));
        }
        //分割的串 [startIndex,i]
        for(int i = startIndex;i<s.length();i++){
            if(isPalindrome(s,startIndex,i)){
                String str = s.substring(startIndex,i+1);
                cur.add(str);
            }else {
                continue;
            }
            backTracing(res,s,cur,i+1);
            cur.remove(cur.size()-1);
        }
    }

    boolean isPalindrome(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        LCR086 lcr086 = new LCR086();
        List<List<String>> res = lcr086.partition(s);
        for (List<String> list : res) {
            for (String s1 : list) {
                System.out.print(s1 + " ");
            }
            System.out.println();
        }
    }
}
