package exercise1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SuperIteratorTest {

    Collection<Iterator> iters = new ArrayList<>();

    @Before
    public void init() {
        iters = new ArrayList<>();

        Iterator i1 = new TestIterator(1, 5, 45, 345);
        iters.add(i1);
        Iterator i2 = new TestIterator(2, 4, 67, 105);
        iters.add(i2);
    }


    @Test
    public void testSuperIterator() {

        SuperIterator s = new SuperIterator(iters);

        List<Integer> results = new ArrayList<>();
        while (s.hasNext()) {
            results.add(s.next());
        }

        assertEquals(Arrays.asList(1, 2, 4, 5, 45, 67, 105, 345), results);
    }


    private static class TestIterator implements Iterator {

        private final java.util.Iterator<Integer> iterator;

        public TestIterator(Integer... args) {
            List<Integer> list = Arrays.asList(args);
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

}

