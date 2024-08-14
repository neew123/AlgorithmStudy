package javaSE;

/**
 * 懒汉式：延迟创建这个实例对象，也就是用的时候去创建对象
 * （1）构造器私有化
 * （2）用一个静态变量保存这个唯一实例
 * （3）提供一个静态方法来获取这个实例对象
 *  (4) 线程安全问题
 */
public class Singleton4 {
    private static Singleton4 instance;
    private Singleton4(){

    }
    public static Singleton4 getInstance(){
        if(instance == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton4();
        }
        return instance;
    }
}
