/**
 * 场景类 - 客人点了一碗面
 */

import java.util.ArrayList;
import java.util.List;

class Noodles {
    private boolean hasScallion = false; // 是否加葱
    private boolean hasCilantro = false; // 是否加香菜
    private boolean hasVinegar = false; // 是否加醋

    public void setHasCilantro(boolean hasCilantro) {
        this.hasCilantro = hasCilantro;
    }

    public void setHasScallion(boolean hasScallion) {
        this.hasScallion = hasScallion;
    }

    public void setHasVinegar(boolean hasVinegar) {
        this.hasVinegar = hasVinegar;
    }
}

abstract class AbstractNoodlesBuilder {

    protected abstract void addScallion();
    protected abstract void addCilantro();
    protected abstract void addVinegar();

    public abstract Noodles build();

}

class NoodlesBuilder extends AbstractNoodlesBuilder {

    private final Noodles noodles = new Noodles(); // 默认是一碗清汤面

    @Override
    protected void addScallion() {
        System.out.println("给面撒上葱花");
        noodles.setHasScallion(true);
    }

    @Override
    protected void addCilantro() {
        System.out.println("给面撒上香菜");
        noodles.setHasCilantro(true);
    }

    @Override
    protected void addVinegar() {
        System.out.println("给面汤里加点醋");
        noodles.setHasVinegar(true);
    }

    @Override
    public Noodles build() {
        return noodles;
    }

}

class Cook {

    private static final AbstractNoodlesBuilder builder = new NoodlesBuilder(); // 厨师来制作面食

    public Noodles cook(List<String> requirements) {
        for (String requirement: requirements) {
            switch (requirement) {
                case "Scallion":  builder.addScallion(); break;
                case "Cilantro":  builder.addCilantro(); break;
                case "Vinegar":  builder.addVinegar(); break;
                // 如果客人提出了不能满足的要求, 那么就会报错
                default :  throw new RuntimeException("不支持的配方");
            }
        }
        return builder.build();
    }
}

class Restaurant {

    private static Cook cook = new Cook();

    public static void main(String[] args) {
        // 客人来用餐,点了一碗清汤面,需要加葱加醋,但是不加香菜
        ArrayList<String> arrayList = new ArrayList<>();
        // 客人的需求表
        arrayList.add("Scallion");
        arrayList.add("Vinegar");
        // 厨师按照客人的需求来制作
        cook.cook(arrayList);
    }
}