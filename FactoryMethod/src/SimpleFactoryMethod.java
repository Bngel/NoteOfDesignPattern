/**
 * @author bngel
 * 简单工厂方法模式
 */
class SimpleFactory {

    /**
     * 直接使用静态方法来创建对应的实例
     * @param tClass 具体实例的类
     * @param <T> 具体的类
     * @return 实例
     */
    public static <T extends AbstractSimpleProduct> T create(Class<T> tClass) {
        T product = null;
        try {
            product = tClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}

abstract class AbstractSimpleProduct {

    public abstract void method();
}

class SimpleProduct extends AbstractSimpleProduct{

    @Override
    public void method() {
        System.out.println("default");
    }
}