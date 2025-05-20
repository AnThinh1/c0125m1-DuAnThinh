public class Student {
    private String name;
    private int id;
    private static int nextID=1000;

    public Student(String name){
        this.name=name;
        this.id=nextID;
        nextID++;
    }
    void display (){
        System.out.println("Name: "+name+" ID: "+id);
    }
}
