/**
 * @author bngel
 * 抽象工厂模式的模板
 */

abstract class AbstractProductA {

    public void shareMethod() {

    }

    public abstract void doSomething();
}

abstract class AbstractProductB {

    public void shareMethod() {

    }

    public abstract void doSomething();
}


class ProductA1 extends AbstractProductA {

    @Override
    public void doSomething() {
        System.out.println("产品A1的实现方法");
    }

}

class ProductA2 extends AbstractProductA {

    @Override
    public void doSomething() {
        System.out.println("产品A2的实现方法");
    }

}

class ProductB1 extends AbstractProductB {

    @Override
    public void doSomething() {
        System.out.println("产品B1的实现方法");
    }

}

class ProductB2 extends AbstractProductB {

    @Override
    public void doSomething() {
        System.out.println("产品B2的实现方法");
    }

}

abstract class AbstractCreator {
    // 创建A产品家族
    public abstract AbstractProductA createProductA();
    // 创建B产品家族
    public abstract AbstractProductB createProductB();
}

class Creator1 extends AbstractCreator {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}

class Creator2 extends AbstractCreator {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}

class Client {
    public static void main(String[] args) {
        AbstractCreator creator1 = new Creator1();
        AbstractCreator creator2 = new Creator2();
        AbstractProductA productA1 = creator1.createProductA();
        AbstractProductA productA2 = creator2.createProductA();
        AbstractProductB productB1 = creator1.createProductB();
        AbstractProductB productB2 = creator2.createProductB();
    }
}