public class QueueAsLinkedList<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        T item;
        Node<T> next;

        Node (T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    public void add(T item) {
        Node<T> node = new Node<T>(item, null);
        if (rear == null) {
            rear = node;
            front = node;
        } else {
            rear.next = node;
        }

        rear = node;
        size++;
    }

    public T remove() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        T item = front.item;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return item;
    }

    public T peek() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        return front.item;
    }

    public int getCount() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public static void main(String[] args) {
        QueueAsLinkedList<Integer> ll = new QueueAsLinkedList<Integer>();
        ll.add(1);   ll.add(2); ll.add(3);
        while (!ll.isEmpty()) {
            System.out.println(ll.remove());
        }
    }
}
