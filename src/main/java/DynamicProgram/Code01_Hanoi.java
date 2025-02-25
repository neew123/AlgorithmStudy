package DynamicProgram;


import java.util.HashSet;
import java.util.Set;

/**
 * 汉诺塔问题
 */
public class Code01_Hanoi {

    public static void hanno(int n){
        if(n>0){
            func(n,"左","右","中");
        }
        Set<String> set = new HashSet<>();
    }

    // n个盘子，从from柱子，经过help柱子，到to柱子
    public static void func(int n ,String from,String to,String help){
        if( n == 1){
            System.out.println("Move 1 from "+from+" to "+to);
        }else {
            func(n-1,from,help,to);
            System.out.println("Move "+n+" from "+from+" to "+to);
            func(n-1,help,to,from);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        hanno(n);
    }
}
