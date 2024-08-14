package javaSE;

/**
 *     饿汉式：直接创建实例对象，不管是否需要
 *     (1)构造器私有化
 *    （2）自行创建，并用静态变量保存
 *    （3）向外提供这个实例
 *    （4）强调这是一个单例，用final修饰
 *
 *    在类初始化的时候就加载静态常量
 */
public class Singleton1 {
    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){

    }

}
