/**
 * 场景类 - 3
 * 除了具体的创建对象，单例模式也广泛地用于存放全局变量
 * 但是一般直接使用静态方法以及静态变量要更快一些
 * 这里简单写一个存储项目名称的单例模式常量类
 */
class Constant {

    private static final Constant constant = new Constant();

    // 比如项目的名称
    private final String project = "demo";

    public static Constant newInstance() {
        return constant;
    }

    public String getProject() {
        return project;
    }

    private Constant() {}

    public static void main(String[] args) {
        Constant constant = Constant.newInstance();
        System.out.println(constant.getProject());
    }
}
