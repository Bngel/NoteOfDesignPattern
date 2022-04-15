/**
 * @author bngel
 * 中介者模式模板方法
 */

abstract class Mediator {

    // 定义同事类
    protected ConcreteColleague1 c1;
    protected ConcreteColleague2 c2;

    // 具体的业务逻辑
    public abstract void doSomething1();
    public abstract void doSomething2();

    // 通过getter/setter方法进行对应的获取/设置
    public ConcreteColleague1 getC1() {
        return c1;
    }
    public ConcreteColleague2 getC2() {
        return c2;
    }
    public void setC1(ConcreteColleague1 c1) {
        this.c1 = c1;
    }
    public void setC2(ConcreteColleague2 c2) {
        this.c2 = c2;
    }
}

class ConcreteMediator extends Mediator {

    @Override
    public void doSomething1() {
        super.c1.selfMethod1();
        super.c2.selfMethod2();
    }

    @Override
    public void doSomething2() {
        super.c1.selfMethod1();
        super.c2.selfMethod2();
    }
}

abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }
}

class ConcreteColleague1 extends Colleague {

    public ConcreteColleague1(Mediator mediator) {
        super(mediator);
    }

    public void selfMethod1() {
        // 处理自己的业务逻辑
    }

    public void depMethod1() {
        // 自己处理不了的业务逻辑
        super.mediator.doSomething1();
    }
}

class ConcreteColleague2 extends Colleague {

    public ConcreteColleague2(Mediator mediator) {
        super(mediator);
    }

    public void selfMethod2() {
        // 处理自己的业务逻辑
    }

    public void depMethod2() {
        // 自己处理不了的业务逻辑
        super.mediator.doSomething2();
    }
}
