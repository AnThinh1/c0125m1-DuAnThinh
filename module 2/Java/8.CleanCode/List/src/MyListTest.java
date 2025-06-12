public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInteger = new MyList<Integer>();
        listInteger.add(10);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);
        listInteger.add(67);
        listInteger.add(55);


        System.out.println("element 1: "+listInteger.get(0));
        System.out.println("element 2: "+listInteger.get(4));
        System.out.println("element 3: "+listInteger.get(5));
        listInteger.get(-1);
        System.out.println("element -1: " + listInteger.get(-1));


    }
}