package hashMapAndHashSet;

import java.util.HashSet;

public class HashSetAndHashMap {
    public static void main(String[] args) {
        System.out.println("--------------String----------------");
        String str1 = new String("hello");
        String str2 = new String("hello");
        //false,因为不同的内存地址
        System.out.print("str1 == str2: ");
        System.out.println(str1 == str2);
        //true,因为字符串的内容相同
        System.out.println("str1 equals str2: "+str1.equals(str2));

        System.out.println("--------------HashSet----------------");
        HashSet<String> set  = new HashSet<>();
        set.add(str1);
        System.out.println(set.contains("hello"));
        System.out.println(set.contains(str2));
        set.add(str2);
        System.out.println(set.size());
        set.remove(str1);
        set.clear();
        System.out.println(set.isEmpty());
    }
}
