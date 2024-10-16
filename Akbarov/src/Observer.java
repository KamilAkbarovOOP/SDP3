import java.util.ArrayList;
import java.util.List;

interface ShapeObserver {
    void update(String shapeName, double newSize);
}

interface ShapeSubject {
    void attach(ShapeObserver observer);
    void detach(ShapeObserver observer);
    void notifyObservers();
}

class Shape implements ShapeSubject {
    private List<ShapeObserver> observers = new ArrayList<>();
    private String name;
    private double size;

    public Shape(String name, double size) {
        this.name = name;
        this.size = size;
    }

    public void setSize(double newSize) {
        this.size = newSize;
        notifyObservers();
    }

    public double getSize() {
        return size;
    }

    @Override
    public void attach(ShapeObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(ShapeObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ShapeObserver observer : observers) {
            observer.update(name, size);
        }
    }
}


class ShapeDisplay implements ShapeObserver {
    @Override
    public void update(String shapeName, double newSize) {
        System.out.println("Shape: " + shapeName + "\nSize changed on: " + newSize);
    }
}

public class Observer {
    public static void main(String[] args) {
        Shape circle = new Shape("Circle", 5.0);
        ShapeDisplay display = new ShapeDisplay();

        circle.attach(display);

        circle.setSize(10.0);
        circle.setSize(7.5);
    }
}