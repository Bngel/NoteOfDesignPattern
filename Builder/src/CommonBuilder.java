/**
 * @author bngel
 *
 * 建造者模式的模板
 */

class Product {
    public void doSomething() {
        // 独立业务处理
    }
}

abstract class Builder {
    //设置产品的不同部分,以获得不同的产品
    public abstract void setPart();

    // 建造产品
    public abstract Product buildProduct();
}

class ConcreteProductBuilder extends Builder {

    private Product product = new Product();

    @Override
    public void setPart() {
        // 产品类中的具体逻辑
        // 对product进行DIY
    }

    @Override
    public Product buildProduct() {
        return product;
    }
}

class Director {

    private Builder builder = new ConcreteProductBuilder();

    public Product getAProduct() {
        builder.setPart();
        return builder.buildProduct();
    }
}