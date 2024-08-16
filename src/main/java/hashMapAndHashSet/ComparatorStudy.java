package hashMapAndHashSet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 比较器
 */
public abstract class ComparatorStudy {

    public static class Employee{
        public int company;
        public int age;
        public Employee(int c,int a){
            company = c;
            age = a;
        }

    }

    public static class EmployeeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            //举例：谁年龄小，谁优先级高
            //通用：返回负数，o1优先级高；返回正数，o2优先级高；
            return o1.age-o2.age;
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1,60);
        Employee e2 = new Employee(2,27);
        Employee e3 = new Employee(1,35);
        Employee e4 = new Employee(3,23);
        Employee e5 = new Employee(3,55);
        Employee[] arr = new Employee[]{e1,e2,e3,e4,e5};
        Arrays.sort(arr,new EmployeeComparator());
        //lambda表达式写法
        Arrays.sort(arr,(o1,o2)->o1.age-o2.age);
        //所有员工按照谁的公司编号小，谁在前；如果公司编号一样，谁年龄小谁在前
        Arrays.sort(arr,(a,b)->
            a.company!= b.company?(a.company- b.company):(a.age-b.age)
        );
        //如果不想去重，就需要增加更多的比较，比如对象内存地址或者对象数组下标之类
        TreeSet<Employee> ts = new TreeSet<>((a,b)-> a.company!=b.company?(a.company- b.company)
                :a.age!=b.age?(a.age-b.age):(a.hashCode()-b.hashCode()));

    }
}
