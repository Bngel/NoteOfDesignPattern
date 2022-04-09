/**
 * @author bngel
 * 场景类 - 1
 */

/**
 * 虚拟工厂类 - 自动售卖机
 * 表示每个自动售卖机都具备的功能
 * 有两个buy方法
 * 一个是与模板中相同的Class作为参数
 * 一个则是采用了String作为参数，多一种选择
 */
abstract class AbstractVendingMachine {

    public abstract Drink buy();

}

/**
 * 具体工厂类
 */
class ColaVending extends AbstractVendingMachine {

    @Override
    public Cola buy() {
        return new Cola();
    }
}

class OrangeVending extends AbstractVendingMachine {

    @Override
    public Orange buy() {
        return new Orange();
    }
}

class WaterVending extends AbstractVendingMachine {

    @Override
    public Water buy() {
        return new Water();
    }
}



class Girl {

    public static void main(String[] args) {
        AbstractVendingMachine colaVending = new ColaVending();
        AbstractVendingMachine orangeVending = new OrangeVending();
        AbstractVendingMachine waterVending = new WaterVending();

        Drink cola = colaVending.buy();
        Drink orange = orangeVending.buy();
        Drink water = waterVending.buy();

        cola.drink();
        cola.feel();
        orange.drink();
        orange.feel();
        water.drink();
        water.feel();
    }
}