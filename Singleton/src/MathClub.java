import java.util.ArrayList;
import java.util.Random;

/**
 * @author bngel
 * 场景类 - 2
 * 现在你被数学题难倒了，需要找一名任意的数学老师来辅导你
 * 因此你来到了数学教学组，这里有 n = 10 名数学老师
 * 你只需要问其中一个老师就可以得到答案
 * （至少是不需要到重新聘请的，也就是不需要重新new一个老师，多聘请一个老师很贵的~）
 */
class MathClub {

    public static void main(String[] args) {
        // 你现在有100道题要问老师，每一道问题都到教学组来一次（尽管可以一个老师讲完，但是这里仅作为例子）
        for (int i = 0; i < 100; i ++) {
            MathTeacher teacher = MathTeacher.getInstance();
            teacher.teach();
        }
    }
}

class MathTeacher {

    private static ArrayList<MathTeacher> teachers = new ArrayList<>();
    private String name;
    static {
        // 一共十名数学老师在教学组
        // 人名均来自网络，如有雷同，纯属巧合
        teachers.add(new MathTeacher("宋爱梅"));
        teachers.add(new MathTeacher("王志芳"));
        teachers.add(new MathTeacher("于光"));
        teachers.add(new MathTeacher("贾隽仙"));
        teachers.add(new MathTeacher("贾燕青"));
        teachers.add(new MathTeacher("刘振杰"));
        teachers.add(new MathTeacher("郭卫东"));
        teachers.add(new MathTeacher("崔红宇"));
        teachers.add(new MathTeacher("马福平"));
        teachers.add(new MathTeacher("冯红"));
    }

    public void teach() {
        System.out.println(name + "老师正在辅导你的数学题");
    }

    public static MathTeacher getInstance() {
        int random = new Random().nextInt(10);
        return teachers.get(random);
    }

    private MathTeacher() {}
    private MathTeacher(String name) {
        this.name = name;
    }
}
