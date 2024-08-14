package javaSE;

/**
 * 线程安全版懒汉式：延迟创建这个实例对象，也就是用的时候去创建对象
 * （1）构造器私有化
 * （2）用一个静态变量保存这个唯一实例
 * （3）提供一个静态方法来获取这个实例对象
 *
 *  创建对象时使用同步方式
 */
public class Singleton5 {
    private static Singleton5 instance;
    private Singleton5(){

    }
    public static Singleton5 getInstance(){
        if(instance == null){
            synchronized (Singleton5.class){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton5();}
        }
        return instance;
    }
}
