package Comparator;

import java.util.Arrays;
import java.util.Comparator;

public class StudentComparator {
    public static class Student{
        public String name;
        public int id;
        public int age;

        public Student(String name,int id,int age){
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static class IdComparator implements Comparator<Student> {

       //返回负数的时候，第一个参数排在前面
        //返回正数的时候，第二个参数排在前面
        @Override
        public int compare(Student o1, Student o2) {
            return o1.id - o2.id;
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("A",2,20);
        Student s2 = new Student("B",3,21);
        Student s3 = new Student("C",1,22);
        Student[] students = new Student[]{s1,s2,s3};
        Arrays.sort(students,new IdComparator());
        for(Student stu:students){
            System.out.println(stu.name);
        }
    }
}
