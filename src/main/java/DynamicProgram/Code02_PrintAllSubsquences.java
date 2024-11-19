package DynamicProgram;

import java.util.ArrayList;
import java.util.List;

public class Code02_PrintAllSubsquences {

    public static void printAllSubsquences(String str)
    {
        char[] chs = str.toCharArray();
        //process(chs,0);
        List<Character> res = new ArrayList<>();
        process2(chs,0,res);

    }

    public static void process(char[] str,int i)
    {
        if(i == str.length){
            System.out.println(String.valueOf(str));
            return;
        }
        process(str,i+1);
        char tmp = str[i];
        str[i] = 0;
        process(str,i+1);
        str[i] = tmp;

    }

    //当前来到i位置，要和不要，走两条路
    public static void process2(char[] str, int i, List<Character> res){
        if( i == str.length){
            printList(res);
            return;
        }
        List<Character> resKeep = new ArrayList<>(res);
        resKeep.add(str[i]);
        process2(str,i+1,resKeep);
        List<Character> resNoInclude = new ArrayList<>(res);
        process2(str,i+1,resNoInclude);
    }

    public static void printList(List<Character> list)
    {
        for(Character c : list)
        {
            System.out.print(c);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        String str = "aba";
        printAllSubsquences(str);
    }
}
