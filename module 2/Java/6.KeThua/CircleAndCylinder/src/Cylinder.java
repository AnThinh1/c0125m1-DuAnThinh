public class Cylinder extends Circle{
    private double height;
    public Cylinder(double height, double radius, String color){
        super(radius, color);
        this.height=height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getTheTich() {
        return Math.PI * getRadius() * getRadius() * height;
        }
    @Override
    public String toString() {
        return "A Cylinder with radius = " + getRadius()
                + ", height = " + getHeight()
                + ", volume = " + getTheTich()
                + ",color: "+getColor();
    }
    }

