/**
 * 场景类 - 汉堡包
 * 汉堡包的话会有不同的款，照烧鸡腿堡，麻辣鸡腿堡
 * 但是对于不同的汉堡，总归是 面包 + 馅 + 面包 的
 * 因此我们可以给出一个指定的“组装”流程作为模板方法
 */
abstract class Hamburger {

    // 模板方法
    public final void cook() {
        setTopBread();
        setStuffing();
        setBottomBread();
        System.out.printf("这是一款将[%s]和[%s]和[%s]进行组合的汉堡包%n",
                topBread.getClass().getName(), stuffing.getClass().getName(), bottomBread.getClass().getName());
    }
    // 基本方法
    abstract protected void setTopBread();
    abstract protected void setBottomBread();
    abstract protected void setStuffing();


    // 盖在顶层的面包，也就是平常吃的隆起的那块面包部分
    protected Bread topBread;
    // 中间的填料，也许有生菜，也许有西红柿，也许有鸡排，总之是“馅”
    protected Stuffing stuffing;
    // 最后垫底的汉堡面包
    protected Bread bottomBread;
}

abstract class Bread {

}

abstract class Stuffing {

}

// 普通的小麦面包
class WheatBread extends Bread {

}

// 假设我们要做的是板烧堡，那么我们就创建一个板烧类作为馅料
class PanRoasted extends Stuffing {

}

// 具体的汉堡类
class PanRoastedHamburger extends Hamburger {

    @Override
    protected void setTopBread() {
        topBread = new WheatBread();
    }

    @Override
    protected void setBottomBread() {
        bottomBread = new WheatBread();
    }

    @Override
    protected void setStuffing() {
        stuffing = new PanRoasted();
    }
}

class Restaurant {
    public static void main(String[] args) {
        Hamburger hamburger = new PanRoastedHamburger();
        hamburger.cook();
    }
}