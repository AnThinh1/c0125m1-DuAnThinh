public class Student {
    private String name="Thinh";
    private String Classes="C02";

    public Student (){
    }
    public Student(String name, String Classes){
        this.name=name;
        this.Classes=Classes;
    }
    public String getName (){
        return name;
    }
    public String getClasses (){
        return Classes;
    }
    public void display(){
        System.out.println("Name: "+name+" - Class: "+Classes);
    }
}
