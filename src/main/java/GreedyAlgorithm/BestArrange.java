package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 项目有开始时间和结束时间，怎么安排会议室能使会议室可以安排最多的项目
 */
public class BestArrange {

    public static class Program{
        public int start;
        public int end;
        public Program(int start,int end)
        {
            this.start = start;
            this.end = end;
        }
    }


    //定义一个比较器,按照结束时间从小到大排序
    public static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    //timePoint 当前时间点
    public static int bestArrange(Program[] programs,int timePoint){
        Arrays.sort(programs,new ProgramComparator());
        int result = 0;
        for(int i = 0;i<programs.length;i++){
            if(programs[i].start>=timePoint){
                result++;
                timePoint = programs[i].end;
            }
        }
        return result;
    }
}
