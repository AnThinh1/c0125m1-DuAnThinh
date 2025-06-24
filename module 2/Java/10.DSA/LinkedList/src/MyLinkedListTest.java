public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.addFirst("B");
        list.addFirst("A");
        list.addLast("C");
        list.add(1, "X");

        System.out.println("Size: " + list.size());
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());
        System.out.println("Element at index 1: " + list.get(1));

        System.out.println("Contains 'C': " + list.contains("C"));
        System.out.println("Index of 'B': " + list.indexOf("B"));

        list.remove("X");
        System.out.println("Size after removing 'X': " + list.size());

        list.remove(0);
        System.out.println("First after removing index 0: " + list.getFirst());

        list.clear();
        System.out.println("Size after clear: " + list.size());
    }
}
