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
abstract class AbstractVending {

    public abstract <T extends Drink> T buy(Class<T> tClass);

    public abstract <T extends Drink> T buy(String drinkName);

}

/**
 * 具体工厂类 - 具体的某一种（而不是某一台）自动售货机
 */
class Vending extends AbstractVending {


    /**
     * 和模板方法中相同，此处不做过多展开
     * @param tClass 饮料类的具体Class
     * @param <T> 饮料类的具体实例的类型
     * @return 通过反射实例化的饮料实例
     */
    @Override
    public <T extends Drink> T buy(Class<T> tClass) {
        T drink = null;
        try {
            drink = tClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return drink;
    }

    /**
     * 通过类名的方式来进行反射得到类的实例
     * @param drinkName 类名，此处是饮料名作为类名
     * @param <T> Drink类的子类
     * @return 返回值，具体的饮料实例
     */
    @Override
    public <T extends Drink> T buy(String drinkName) {
        T drink = null;
        try {
            Class<?> tClass = Class.forName(drinkName);
            drink = (T) tClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return drink;
    }
}

/**
 * 下述为Drink类以及对应的子类
 * 代码比较好理解就不加注解了
 */
abstract class Drink {

    private String name = "Drink";

    protected void setName(String name) {
        this.name = name;
    }

    public void drink() {
        System.out.println(name + " 已经被喝掉了");
    }

    public abstract void feel();
}

class Cola extends Drink {

    public Cola() {
        setName("Cola");
    }

    @Override
    public void feel() {
        System.out.println("喝可乐，咕噜咕噜，嗝~");
    }
}


class Orange extends Drink {

    public Orange() {
        setName("Orange");
    }

    @Override
    public void feel() {
        System.out.println("喝橙汁，咕咕咕");
    }
}

class Water extends Drink {

    public Water() {
        setName("Water");
    }

    @Override
    public void feel() {
        System.out.println("这白开水怎么没味儿啊！");
    }
}

class Boy {

    public static void main(String[] args) {
        AbstractVending vending = new Vending();
        Drink cola = vending.buy("Cola");
        Drink orange = vending.buy("Orange");
        Drink water = vending.buy("Water");
        // drink -> feel
        // 喝掉饮料，有不同的感觉
        // 喝是饮料所共有的方法，而感觉则是每个饮料各不相同
        cola.drink();
        cola.feel();
        orange.drink();
        orange.feel();
        water.drink();
        water.feel();
    }
}