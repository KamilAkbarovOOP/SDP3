import java.util.Iterator;

public class CustomStringCollection implements Iterable<String> {
    private String[] items;
    private int size = 0;

    public CustomStringCollection(int capacity) {
        items = new String[capacity];
    }

    public void add(String item) {
        if (size < items.length) {
            items[size++] = item;
        } else {
            throw new ArrayIndexOutOfBoundsException("Collection is full");
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new CustomIterator(this);
    }

    public String get(int index) {
        if (index >= 0 && index < size) {
            return items[index];
        }
        throw new ArrayIndexOutOfBoundsException("Index out of bounds");
    }

    public int getSize() {
        return size;
    }
}
