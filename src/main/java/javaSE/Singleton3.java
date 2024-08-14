package javaSE;

import java.io.IOException;
import java.util.Properties;

/**
 * 类的加载和初始化执行静态代码块
 *
 * 初始化的值需要从文件中读取
 */
public class Singleton3 {
    public static final Singleton3 INSTANCE;
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    static {
        Properties properties = new Properties();
        //获取pro的方法
        try {
            properties.load(Singleton3.class.getClassLoader().getResourceAsStream("single.properties"));
            INSTANCE = new Singleton3((String) properties.get("info"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private Singleton3(String info){
        this.info = info;
    }

    @Override
    public String toString() {
        return "Singleton3{" +
                "info='" + info + '\'' +
                '}';
    }
}
