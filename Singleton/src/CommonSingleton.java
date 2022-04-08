/**
 * @author bngel
 * 常见的两种单例模式模板：
 * 1. 饿汉式单例模式
 * 2. 懒汉式单例模式
 */
class CommonSingleton {

    public static void main(String[] args) {
        NormalSingleton normalSingleton = NormalSingleton.getInstance();
        normalSingleton.doSomething();
        LazySingleton lazySingleton = LazySingleton.getInstance();
        lazySingleton.doSomething();
    }
}

/**
 * 1. 饿汉式单例模式
 * 在加载类时将对应的单例直接进行创建
 * 优点：线程安全，没有加锁，执行效率较高
 * 缺点：不是懒加载，类加载时就初始化，浪费内存空间
 */
class NormalSingleton {

    private static final NormalSingleton singleton = new NormalSingleton();

    private NormalSingleton() {}

    public static NormalSingleton getInstance() {
        return singleton;
    }

    public void doSomething() {
        System.out.println("this is NormalSingleton");
    }
}

/**
 * 2. 懒汉式单例模式
 * 在加载类时还没有进行单例的创建，而是等到真正需要用的时候才进行创建
 * 优点：懒加载
 * 缺点：线程不安全
 */
class LazySingleton {

    private static LazySingleton singleton = null;

    private LazySingleton() {}

    public static LazySingleton getInstance() {
        // 此处存在一定的线程安全问题
        if (singleton == null) {
            singleton = new LazySingleton();
        }
        return singleton;
    }

    public void doSomething() {
        System.out.println("this is LazySingleton");
    }
}

/**
 * 2. 懒汉式单例模式 - 线程安全版
 * 通过synchronized关键字实现线程安全
 */
class SyncLazySingleton {

    // 使用volatile关键字保证单例变量的可见性和有序性
    // 当其中一个线程将其生成后，其余线程能够立刻感知到
    // 从而保证单例不会被重复生成
    private static volatile SyncLazySingleton singleton = null;

    private SyncLazySingleton() {}

    // 方法 1 - 方法增加synchronized关键字
    // 优点：懒加载，线程安全
    // 缺点：效率较低
    public synchronized static SyncLazySingleton getSyncInstance1() {
        if (singleton == null) {
            singleton = new SyncLazySingleton();
        }
        return singleton;
    }

    // 方法 2 - 双重检查锁（DCL，即double-checked locking）
    // 优点：懒加载，线程安全，效率较高
    // 缺点：实现较复杂
    public static SyncLazySingleton getSyncInstance2() {
        if (singleton == null) {
            synchronized (singleton) {
                if (singleton == null) {
                    singleton = new SyncLazySingleton();
                }
            }
        }
        return singleton;
    }

    public void doSomething() {
        System.out.println("this is SyncLazySingleton");
    }
}