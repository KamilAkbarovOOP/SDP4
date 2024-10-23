abstract class Shape {
    String name;
    Shape(String name) {
        this.name = name;
    }
    void draw() {
        System.out.println("Drawing " + name);
    }
}

class Circle extends Shape {
    Circle() {
        super("Circle");
    }
}

class Square extends Shape {
    Square() {
        super("Square");
    }
}

class Canvas {
    java.util.List<Shape> shapes = new java.util.ArrayList<>();

    void addShape(Shape shape) {
        shapes.add(shape);
        shape.draw();
    }

    void removeShape(Shape shape) {
        shapes.remove(shape);
        System.out.println("Removed " + shape.name);
    }
}

interface Command {
    void execute();
}

class AddShapeCommand implements Command {
    private Shape shape;
    private Canvas canvas;

    AddShapeCommand(Shape shape, Canvas canvas) {
        this.shape = shape;
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        canvas.addShape(shape);
    }
}

class RemoveShapeCommand implements Command {
    private Shape shape;
    private Canvas canvas;

    RemoveShapeCommand(Shape shape, Canvas canvas) {
        this.shape = shape;
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        canvas.removeShape(shape);
    }
}

public class CommandTest {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        Shape circle = new Circle();
        Shape square = new Square();

        Command addCircle = new AddShapeCommand(circle, canvas);
        Command addSquare = new AddShapeCommand(square, canvas);
        Command removeCircle = new RemoveShapeCommand(circle, canvas);

        addCircle.execute();
        addSquare.execute();
        removeCircle.execute();
    }
}
