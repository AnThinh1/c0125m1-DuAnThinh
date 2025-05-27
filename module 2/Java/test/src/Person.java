public class Person {
    public String name;
    public int age;
    public int trym;

    public Person(String name, int age) {
        this.trym = 20;
        this.name = name;
        this.age = age;
    }
    public void sayHello(){
        System.out.println("Hello " + this.name + " "+ this.age + " tuổi " +"trym dài "+ this.trym +" cm");
    }
}
