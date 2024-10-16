abstract class TemplateShape {
    public final void draw() {
        prepare();
        render();
        finish();
    }

    abstract void prepare();

    abstract void render();

    void finish() {
        System.out.println("Finished");
    }
}

class Circle extends TemplateShape {
    @Override
    void prepare() {
        System.out.println("Preparing for circle");
    }

    @Override
    void render() {
        System.out.println("Drawing of circle");
    }
}

class Rectangle extends TemplateShape {
    @Override
    void prepare() {
        System.out.println("Preparing for rectangle");
    }

    @Override
    void render() {
        System.out.println("Drawing of rectangle");
    }
}



public class Template {
    public static void main(String[] args) {
        TemplateShape circle = new Circle();
        circle.draw();

        System.out.println();

        TemplateShape rectangle = new Rectangle();
        rectangle.draw();
    }
}