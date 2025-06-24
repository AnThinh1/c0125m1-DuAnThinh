public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    public MyLinkedList() {
        head = null;
        numNodes = 0;
    }

    public void addFirst(E e) {
        Node temp = head;
        head = new Node(e);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E e) {
        Node temp = head;
        if (head == null) {
            addFirst(e);
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(e);
        numNodes++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }
        if (index == 0) {
            addFirst(element);
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node holder = temp.next;
            temp.next = new Node(element);
            temp.next.next = holder;
            numNodes++;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + numNodes);
        }
        Node temp = head;
        if (index == 0) {
            head = head.next;
            numNodes--;
            return (E) temp.data;
        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node removed = temp.next;
        temp.next = removed.next;
        numNodes--;
        return (E) removed.data;
    }

    public boolean remove(Object e) {
        if (head == null) return false;
        if (head.data.equals(e)) {
            head = head.next;
            numNodes--;
            return true;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(e)) {
                temp.next = temp.next.next;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int size() {
        return numNodes;
    }

    public E clone() {
        MyLinkedList<E> newList = new MyLinkedList<>();
        Node temp = head;
        while (temp != null) {
            newList.addLast((E) temp.data);
            temp = temp.next;
        }
        return (E) newList;
    }

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(E o) {
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.equals(o)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        // Với LinkedList, không cần thiết phải đảm bảo dung lượng như ArrayList, nên hàm này có thể để trống
    }

    public E get(int i) {
        if (i < 0 || i >= numNodes) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + numNodes);
        }
        Node temp = head;
        for (int index = 0; index < i; index++) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public E getFirst() {
        if (head == null) {
            return null;
        }
        return (E) head.data;
    }

    public E getLast() {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return (E) temp.data;
    }

    public void clear() {
        head = null;
        numNodes = 0;
    }
}
