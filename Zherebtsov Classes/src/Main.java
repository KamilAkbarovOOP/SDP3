import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        CustomStringCollection collection = new CustomStringCollection(5);
        collection.add("One");
        collection.add("Two");
        collection.add("Three");

        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Context context = new Context(new AdditionStrategy());
        System.out.println("Addition: " + context.executeStrategy(5, 3));


        context.setStrategy(new MultiplicationStrategy());
        System.out.println("Multiplication: " + context.executeStrategy(5, 3));
    }
}
