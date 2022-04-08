import java.util.ArrayList;
import java.util.Random;

/**
 * @author bngel
 * 对单例模式进行一个扩展
 * 使单例模式拓展为固定数量的多例模式
 * 多例模式的模板类
 */
public class ExpandSingleton {

    // 多例模式中出于方便也同样使用了单例模式中的饿汉式
    private static ArrayList<ExpandSingleton> prototype = new ArrayList<>();
    // 这里假设有5个单例
    public static final int COUNT = 5;
    // 为每一个实例打个标记
    private int flag;

    static {
        for (int i = 0; i < COUNT; i ++) {
            prototype.add(new ExpandSingleton(i));
        }
    }

    private ExpandSingleton() {}

    private ExpandSingleton(int num) {
        flag = num;
    }

    public static ExpandSingleton newInstance() {
        // 制定策略从创建的多个实例中获取一个
        // 这里简单采用随机获取的方式
        int index = new Random().nextInt(COUNT);
        return prototype.get(index);
    }

    public void doSomething() {
        System.out.println("Here is singleton: " + flag);
    }

    public static void main(String[] args) {
        // 假设做 100 次测试
        for (int i = 0; i < 100; i ++) {
            ExpandSingleton instance = ExpandSingleton.newInstance();
            // 测试 100 次内是否只会出现 0-4 的 flag
            // 成功则说明确实只会在5个实例中选出一个作为返回，而不是新建实例
            instance.doSomething();
        }
    }

}
