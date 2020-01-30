package eval;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class State<Value> {
    private Map<String, Value> map = new HashMap<>();

    public Value lookup(String name) {
        Value option = map.get(name);
        if (option != null)
            return option;
        else
            throw new RuntimeException("unknown identifier: " + name);
    }

    public void bind(String name, Value value) {
        if (map.containsKey(name))
            throw new RuntimeException("redefining identifier: " + name);
        else
            map.put(name, value);
    }

    public void bindAll(List<String> names, List<Value> values) {
        if (names.size() == values.size())
            for (int i = 0; i < names.size(); i++)
                bind(names.get(i), values.get(i));
        else
            throw new IllegalArgumentException("bindAll incompatible argument lengths: " + names + " and " + values);
    }
    @Override public String toString() {
        return map.toString();
    }
}