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

            if(toKill > (objects.length - 1)) {
                objects = josephus.toArray();
                toKill = k - 1;
            }

            Object killed = objects[toKill];
            josephus.remove(killed);
            result.add((T) killed);
            toKill += k;
        }
        result.addAll(josephus);
        return result;
    }
}
