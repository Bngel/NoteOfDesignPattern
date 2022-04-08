import java.util.Random;

/**
 * @author bngel
 * 场景类 - 1
 * 校园中只有一个校长
 * 多个老师需要向校长汇报工作
 */
class Campus {

    public static void main(String[] args) {
        // 模拟3个老师向校长汇报
        Teacher teacher1 = new Teacher();
        Teacher teacher2 = new Teacher();
        Teacher teacher3 = new Teacher();
        // 每次都是用newInstance生成变量而不是在Campus类中直接准备好一个类变量
        // 也是为了模拟每次老师报告都是从校长类中重新获取的，测试是否都是同一个校长
        teacher1.doSomething(Principal.newInstance());
        teacher2.doSomething(Principal.newInstance());
        teacher3.doSomething(Principal.newInstance());
    }
}

/**
 * 单例校长类 - 负责处理老师们的汇报工作
 */
class Principal {

    // 创建一个唯一的随机序列号表示都是同一个校长
    // 这里不使用static修饰是为了分离类变量和单例变量的关系
    // 保证是同一个单例变量
    private final int num = new Random().nextInt(100);
    // 方便起见，场景模拟均使用饿汉式单例模式
    private static final Principal singleton = new Principal();

    public static Principal newInstance() {
        return singleton;
    }

    public int getNum() {
        return num;
    }

    // 养成好习惯，方法排序按照 public - protected - private

    private Principal() {}
}

/**
 * 老师类 - 负责向校长汇报工作
 */
class Teacher {

    private final int num = new Random().nextInt(10);

    public void doSomething(Principal principal) {
        System.out.println(num + "号教师向校长（"+ principal.getNum()+"）报告");
    }
}
