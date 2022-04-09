import java.lang.reflect.Constructor;

class SingletonFactory {

    private static Singleton singleton = null;
    static {
        try {
            Class<Singleton> tClass = Singleton.class;
            Constructor<Singleton> constructor = tClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            singleton = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Singleton create() {
        return singleton;
    }
}

class Singleton {

    private Singleton() {}

    public void show() {
        System.out.println("show");
    }
}
