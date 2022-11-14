/**
 * * @author www.EasyCodeBook.com (c)
 */
class Circle {
    // How to define a constant in Java
    private final double PI = 3.14159;
    // radius of circle
    private double radius;

    // no arg Constructor
    public Circle() {
        radius = 0.0;
    }
    // Parameterized constructor
    public Circle(double r) {
        radius = r;
    }
    //Setter (Mutator) method for radius
    public void setRadius(double r) {
        radius = r;
    }
    //Getter (Accessor) method for radius
    public double getRadius() {
        return radius;
    }
    // method to calculate and return area
    public double getArea() {
        return PI * radius * radius;
    }
}