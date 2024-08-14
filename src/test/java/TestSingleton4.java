import javaSE.Singleton4;

import java.util.concurrent.*;

public class TestSingleton4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Singleton4 s1 = Singleton4.getInstance();
//        Singleton4 s2 = Singleton4.getInstance();
//
//        System.out.println(s1 == s2);
//        System.out.println(s1);
//        System.out.println(s2);

        //在多线程下的场景
        System.out.println("多线程");
        Callable<Singleton4> c = new Callable<Singleton4>() {
            @Override
            public Singleton4 call() throws Exception {
                return Singleton4.getInstance();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton4> f1 = es.submit(c);
        Future<Singleton4> f2 = es.submit(c);

        Singleton4 ss1 = f1.get();
        Singleton4 ss2 = f2.get();

        System.out.println(ss1 == ss2);
        System.out.println(ss1);
        System.out.println(ss2);
        es.shutdown();
    }
}
