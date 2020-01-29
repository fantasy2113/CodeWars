package josephus;

import java.util.ArrayList;
import java.util.List;

public class Josephus {
    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        if (k == 1) {
            return items;
        }
        List<T> killed = new ArrayList<>();
        List<T> josephus = new ArrayList<>(items);
        int next = k;
        int offset = 1;


        Object[] objects = items.toArray();
        final int length = objects.length - 1;
        while (josephus.size() != 1) {
            for (int kill = next - offset; kill < objects.length; kill += next) {
                killed.add((T) objects[kill]);
                josephus.remove(objects[kill]);
            }
            next += next;
            offset += 1;
        }
        killed.addAll(josephus);
        return killed;
    }
}
