import java.util.HashMap;
import java.util.Map;

public class DelayInitialization {

    private static final Map<String, Drink> prMap = new HashMap<>();

    public static synchronized Drink createDrink(String type) throws Exception {
        Drink drink = null;
        if (prMap.containsKey(type)) {
            drink = prMap.get(type);
        } else {
            drink = switch (type) {
                case "Cola" -> new Cola();
                case "Orange" -> new Orange();
                case "Water" -> new Water();
                default -> null;
            };
            prMap.put(type, drink);
        }
        return drink;
    }
}
