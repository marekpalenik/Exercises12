package exercise1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class SuperIterator implements Iterator {

    private final java.util.Iterator<Integer> iterator;

    SuperIterator(Collection<Iterator> iters) {
        List<Integer> list = new ArrayList<>();
        for (Iterator it : iters) {
            while (it.hasNext()) {
                list.add(it.next());
            }
        }
        list.sort(Comparator.naturalOrder());
        iterator = list.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public int next() {
        return iterator.next();
    }


}
