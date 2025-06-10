public class Rectangle extends Shape{
    private double height =1.0;
    private double weight =1.0;

    public Rectangle() {
    }
    public Rectangle(double height, double weight){
        this.height=height;
        this.weight=weight;
    }
    public Rectangle(double height, double weight, String color, boolean filled) {
        super (color, filled);
        this.height=height;
        this.weight=weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getArea() {
        return this.weight * this.height;
    }
    public double getPerimeter() {
        return 2 * (this.weight+ this.height);
    }
    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWeight()
                + " and length="
                + getHeight()
                + ", which is a subclass of "
                + super.toString();
}}
