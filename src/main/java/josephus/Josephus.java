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
        final Object[] objects = getItems(items);
        
        int next = k;
        int start = k;
        final int n = objects.length - 1;
        
        while (josephus.size() != 1) {
        	int lastKilled = -1;
            for (int kill = start; kill < objects.length; kill += next) {
                killed.add((T) objects[kill]);
                josephus.remove(objects[kill]);
                lastKilled = kill;
            }
            
            start = (lastKilled + next) - n;
            
            if(killed.contains(start)) {
            	start++;
            }
            
            next = next * 2;
        }
        
        killed.addAll(josephus);
        return killed;
    }
    
    private static <T> Object[] getItems(final List<T> items) {
    	Object[] objects = new Object[items.size() + 1];
    	objects[0] = 0;
    	for (int i = 1; i < objects.length; i++) {
    		objects[i] = items.get(i - 1);
		}
    	return objects;
    }
}
