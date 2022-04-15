import java.util.Random;

/**
 * @author bngel
 * 场景类 - 租房
 */

abstract class HousingAgent {

    // 定义同事类
    protected ConcreteLandlord1 c1;
    protected ConcreteLandlord2 c2;

    // 具体的业务逻辑
    public abstract void rentA(); // 租出房屋A
    public abstract void rentB(); // 租出房屋B

    // 通过getter/setter方法进行对应的获取/设置
    public ConcreteLandlord1 getC1() {
        return c1;
    }
    public ConcreteLandlord2 getC2() {
        return c2;
    }
    public void setC1(ConcreteLandlord1 c1) {
        this.c1 = c1;
    }
    public void setC2(ConcreteLandlord2 c2) {
        this.c2 = c2;
    }
}

class ConcreteHousingAgent extends HousingAgent {

    @Override
    public void rentA() {
        c1.rentA();
    }

    @Override
    public void rentB() {
        c2.rentB();
    }
}

abstract class Landlord {

    protected HousingAgent agent;

    public Landlord(HousingAgent agent) {
        this.agent = agent;
    }
}

class ConcreteLandlord1 extends Landlord {

    public ConcreteLandlord1(HousingAgent agent) {
        super(agent);
    }

    public void rentA() {
        // 正常来说直接把自己的房屋租出去
        // 但是万一对租客不满意就让他去租别人的
        boolean flag = new Random().nextBoolean();
        if (flag) {
            System.out.println("把房屋A租出去啦");
        } else {
            System.out.println("房东A不想租");
            super.agent.rentB();
        }
    }
}

class ConcreteLandlord2 extends Landlord {

    public ConcreteLandlord2(HousingAgent agent) {
        super(agent);
    }

    public void rentB() {
        // 正常来说直接把自己的房屋租出去
        // 但是万一对租客不满意就让他去租别人的
        boolean flag = new Random().nextBoolean();
        if (flag) {
            System.out.println("把房屋B租出去啦");
        } else {
            System.out.println("房东B不想租");
            super.agent.rentA();
        }
    }
}

class Graduate {

    public static void main(String[] args) {
        // 刚毕业的大学生想租房
        // 找到一个中介
        HousingAgent agent = new ConcreteHousingAgent();
        agent.setC1(new ConcreteLandlord1(agent)); // 中介联系房东A
        agent.setC2(new ConcreteLandlord2(agent)); // 中介联系房东B
        // 中介去给他租了个房
        agent.rentA();

    }
}
