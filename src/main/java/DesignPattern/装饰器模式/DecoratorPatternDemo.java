package DesignPattern.装饰器模式;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Circle circle = new Circle();
        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle with normal border");
        redCircle.draw();

        System.out.println("\nCircle with normal border");
        redRectangle.draw();
    }
}
