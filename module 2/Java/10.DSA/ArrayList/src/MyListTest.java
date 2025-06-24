public class MyListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println("Size: " + list.size());
        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("Contains 'B': " + list.contains("B"));
        System.out.println("Index of 'C': " + list.indexOf("C"));

        list.add(1, "X");
        System.out.println("Element at index 1 after adding 'X': " + list.get(1));

        System.out.println("Removed element: " + list.remove(2));
        System.out.println("Size after removal: " + list.size());

        list.clear();
        System.out.println("Size after clear: " + list.size());
    }
}
