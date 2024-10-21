import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomIterator implements Iterator<String> {
    private CustomStringCollection collection;
    private int currentIndex = 0;

    public CustomIterator(CustomStringCollection collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < collection.getSize();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return collection.get(currentIndex++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}