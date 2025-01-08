package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**复原IP地址
 */

public class LeetCode93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder(s);
        backTracing(res,cur,0,0);
        return res;
    }

    void backTracing(List<String> res,StringBuilder cur,int startIndex,int pointNum){
        if(pointNum == 3){
            if(isValid(cur,startIndex,cur.length()-1)){
                res.add(new String(cur));
            }
            return;
        }
        for(int i = startIndex;i<cur.length();i++){
            if(isValid(cur,startIndex,i)){
               cur.insert(i+1,'.');
               pointNum++;
               backTracing(res,cur,i+2,pointNum);
               pointNum--;
               cur.deleteCharAt(i+1);
            }else break;
        }
    }

    boolean isValid(StringBuilder s,int start,int end){
        if(start>end){
            return false;
        }
        if(s.charAt(start) == '0' && start!=end){
            return false;
        }
        int num = 0;
        for(int i = start; i<=end;i++){
            if(s.charAt(i)>'9' ||s.charAt(i)<'0'){
                return false;
            }
            num = num*10+(s.charAt(i)-'0');
            if(num>255){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("123456");
        s.insert(2,'.');
        System.out.println(s);
        s.deleteCharAt(2);
        System.out.println(s);

        LeetCode93 leetCode93 = new LeetCode93();
        List<String> res = leetCode93.restoreIpAddresses("25525511135");
        for (String s1 : res) {
            System.out.println(s1);
        }
    }
}
