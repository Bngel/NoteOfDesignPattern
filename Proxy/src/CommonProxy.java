/**
 * @author bngel
 * 代理模式模板
 */

interface Subject {
    void request();
}

class RealSubject implements Subject {

    @Override
    public void request() {
        // 业务逻辑处理
    }
}

class Proxy implements Subject {

    Subject subject = null;

    // 指定具体代理对象
    public Proxy(Subject subject) {
        this.subject = subject;
    }

    // 默认代理对象
    public Proxy() {
        subject = new Proxy();
    }

    @Override
    public void request() {
        // 代理逻辑
        before();
        subject.request();
        after();
    }

    /**
     * 预处理操作
     */
    private void before() {

    }

    /**
     * 善后处理操作
     */
    private void after() {

    }
}
