package javaSE;


/**
 * 在内部类加载和初始化时，才创建INSTANCE实例对象
 * 静态内部类不会自动随着外部类的加载和初始化而初始化，需要单独去加载和初始化
 * 因为是在内部类加载和初始化时创建，所以是线程安全的
 */
public class Singleton6  {
    private Singleton6(){

    }

    private static class Inner{
        private static final Singleton6 instance = new Singleton6();
    }

    public static Singleton6 getInstance(){
        return  Inner.instance;
    }
}
