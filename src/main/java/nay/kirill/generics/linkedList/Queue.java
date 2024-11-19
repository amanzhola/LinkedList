package nay.kirill.generics.linkedList;

public class Queue<T> {

    private Node front = null;

    private Node back = null;

    private int size = 0;

    void enqueue(T value) {
        Node node = new Node(value);

        if (back == null) {
            front = node;
        } else {
            back.next = node;
        }

        back = node;
        size++;
    }

    T dequeue() {
        if (front == null) {
            return null;
        }

        T value = front.value;
        front = front.next;
        size--;
        return value;
    }

    T peek() {
        if (front == null) {
            return null;
        }

        return front.value;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return front == null;
    }

    int count(Predicate<T> predicate) {
        int counter = 0;
        for(Queue<T>.Node node = front; node != null; node = node.next) {
            T value = node.value;
            if (predicate.check(value)) {
                counter++;
            }
        }

        return counter;
    }

    private class Node {

        T value;
        Node next;

        Node(T value) {
            this.value = value;
            next = null;
        }

    }
}
