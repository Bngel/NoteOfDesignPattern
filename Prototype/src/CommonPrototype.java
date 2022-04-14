class PrototypeClass implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
        PrototypeClass prototype = null;
        try {
            prototype = (PrototypeClass) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prototype;
    }
}
