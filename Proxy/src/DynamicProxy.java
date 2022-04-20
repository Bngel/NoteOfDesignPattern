import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author bngel
 * 动态代理模板
 */

class MyInvocationHandler implements InvocationHandler {

    private Object target = null;

    public MyInvocationHandler(Object obj) {
        this.target = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target, args);
    }
}

class DynamicProxy<T>{

    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h){
        if (true) { // JoinPoint
            // 执行一个前置通知
            // (new BeforeAdvice()).exec();
        }
        return (T) Proxy.newProxyInstance(loader, interfaces, h);
    }
}

interface IAdvice {
    void exec();
}

class BeforeAdvice implements IAdvice {

    @Override
    public void exec() {
        // 前置通知逻辑
    }
}

class Client {

    public static void main(String[] args) {
        Subject subject = new RealSubject();
        InvocationHandler handler = new MyInvocationHandler(subject);
        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), handler);
        proxy.request();
    }
}