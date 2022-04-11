/**
 * @author bngel
 * 实现模板方法模式的模板
 */

abstract class AbstractClass {

    // 基本方法
    protected abstract void doSomething();

    protected abstract void doAnything();

    // 模板方法
    public void templateMethod() {
        this.doAnything();
        this.doSomething();
    }
}

class ConcreteClass1 extends AbstractClass {

    // 实现基本方法
    @Override
    protected void doSomething() {
        // 业务逻辑处理
    }

    @Override
    protected void doAnything() {

    }
}

class ConcreteClass2 extends AbstractClass {

    @Override
    protected void doSomething() {

    }

    @Override
    protected void doAnything() {

    }
}

// 场景类
class Client {

    public static void main(String[] args) {
        AbstractClass abstractClass1 = new ConcreteClass1();
        AbstractClass abstractClass2 = new ConcreteClass2();
        abstractClass1.templateMethod();
        abstractClass1.templateMethod();
    }
}