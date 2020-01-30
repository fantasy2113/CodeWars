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
        int start = k - 1;


        Object[] objects = items.toArray();
        final int n = objects.length;
        while (josephus.size() != 1) {
            int store = -1;
            for (int kill = start; kill < objects.length; kill += next) {
                killed.add((T) objects[kill]);
                josephus.remove(objects[kill]);
                store = kill;
            }
            start = (store + next) - n;
            next += next;
        }
        killed.addAll(josephus);
        return killed;
    }
}
