/**
 * @author bngel
 * 一个简单的使用工厂方法模式的模板
 * 虚拟工厂类 - 具体工厂类
 * 虚拟产品类 - 具体产品类
 * （可以不止一种产品，这里就单独写一种Product类作为演示）
 */

/**
 * 虚拟工厂类
 * 给具体的工厂类提供虚拟方法
 */
abstract class AbstractFactory {

    // 表示创建产品的方法，此处使用的是通过具体的产品类的Class来确定需要创建的产品
    // 也可以通过String等其他方式来指定
    public abstract <T extends AbstractProduct> T create(Class<T> tClass);

}

/**
 * 具体工厂类
 * 继承虚拟工厂类，提供真正的创建对象的方法的实现
 */
class CommonFactory extends AbstractFactory{

    @Override // 对虚拟工厂类的方法进行重写
    public <T extends AbstractProduct> T create(Class<T> tClass) {
        T product = null; // 创建一个null对象作为初始化，使catch到异常后也能有null返回作为结果
        try {
            // 明明这样就可以实现，但是书里写的更加复杂
            // (T)Class.forName(tClass.getName()).newInstance()
            // 暂时对此感到不解
            product = tClass.newInstance(); // 通过反射创建新的对象
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}

/**
 * 虚拟产品类
 * 对产品类的属性以及方法做好规范
 * 如果有所有具体产品类都通用的方法也可以直接实现
 */
abstract class AbstractProduct {

    /**
     * 通用方法
     */
    public void method1() {
        System.out.println("所有产品都会这么做");
    }

    /**
     * 每个产品实现各异的方法
     */
    public abstract void method2();
}

/**
 * 具体产品类
 * 继承虚拟产品类，在虚拟产品类提供的默认方法外，具体实现虚拟类中规定的虚拟方法
 */
class Product extends AbstractProduct {

    @Override
    public void method2() {
        System.out.println("这是一个具体的产品类的特性");
    }
}

class Client {

    public static void main(String[] args) {
        AbstractFactory factory = new CommonFactory();
        AbstractProduct product = factory.create(Product.class);
        product.method1();
        product.method2();
    }
}