/**
 * @author bngel
 * 场景类 - 可口可乐公司
 */

/**
 * 小瓶的,330ml的可乐
 */
class SmallCupCola extends Cola {

    @Override
    public void feel() {
        System.out.println("喝了一瓶小瓶可乐");
    }
}

/**
 * 大瓶的,550ml的可乐
 * 下述雪碧同理
 */
class BigCupCola extends Cola {

    @Override
    public void feel() {
        System.out.println("喝了一瓶大瓶可乐");
    }
}

class SmallCupSprite extends Sprite {

    @Override
    public void feel() {
        System.out.println("喝了一瓶小瓶雪碧");
    }
}

class BigCupSprite extends Sprite {

    @Override
    public void feel() {
        System.out.println("喝了一瓶大瓶雪碧");
    }
}

/**
 * 虚拟工厂类，定义出需要创建的产品族
 */
abstract class AbstractDrinkFactory {

    public abstract Cola createCola();

    public abstract Sprite createSprite();

}

/**
 * 制造大瓶饮料的工厂
 */
class BigCupFactory extends AbstractDrinkFactory {

    @Override
    public Cola createCola() {
        return new BigCupCola();
    }

    @Override
    public Sprite createSprite() {
        return new BigCupSprite();
    }
}

/**
 * 制造小瓶饮料的工厂
 */
class SmallCupFactory extends AbstractDrinkFactory {

    @Override
    public Cola createCola() {
        return new SmallCupCola();
    }

    @Override
    public Sprite createSprite() {
        return new SmallCupSprite();
    }
}

/**
 * 可口可乐
 */
abstract class Cola implements Drink {

    @Override
    public void drink() {

    }

}

/**
 * 雪碧
 */
abstract class Sprite implements Drink {

    @Override
    public void drink() {

    }

}

/**
 * 饮品的接口
 */
interface Drink {

    void drink();

    void feel();

}

public class CocaCola {

    public static void main(String[] args) {

        // 创建出两个工厂分别用于制造大瓶和小瓶的饮料
        AbstractDrinkFactory bigCupFactory = new BigCupFactory();
        AbstractDrinkFactory smallCupFactory = new SmallCupFactory();
        // 大瓶饮料制造工厂得到的饮料都是大瓶的
        Cola bigCupCola = bigCupFactory.createCola();
        Sprite bigCupSprite = bigCupFactory.createSprite();
        // 小瓶饮料同理
        Cola smallCupCola = smallCupFactory.createCola();
        Sprite smallCupSprite = smallCupFactory.createSprite();

    }

}