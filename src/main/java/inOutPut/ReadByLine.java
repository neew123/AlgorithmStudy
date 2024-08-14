package inOutPut;

import java.io.*;

public class ReadByLine {

    public static String line;

    public static String[] parts;

    public static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        while ((line = in.readLine())!=null){
            parts = line.split(" ");
            sum = 0;
            for(String num:parts){
                sum+=Integer.valueOf(num);
            }
            out.println(sum);
        }
        out.flush();;
        in.close();
        out.close();
    }

}
