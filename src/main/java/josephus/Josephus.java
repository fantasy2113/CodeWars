package josephus;

import java.util.ArrayList;
import java.util.List;

public class Josephus {
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> result =  new ArrayList<>();
        List<T> josephus =  new ArrayList<>(items);
        int toKill = k - 1;
        Object[] objects = items.toArray();
        while (!josephus.isEmpty()) {
            Object killed = objects[toKill];
            josephus.remove(killed);
            result.add((T) killed);
            toKill += k;
            if (toKill > (objects.length - 1)) {
                toKill = toKill - (objects.length - 1);
            }
        }
        result.addAll(josephus);
        return result;
    }
}
