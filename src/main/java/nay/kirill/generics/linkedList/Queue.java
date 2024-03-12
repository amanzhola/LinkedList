package nay.kirill.generics.linkedList;

public class Queue<T> {
    private Node<T> front;
    private Node<T> back;

    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = back = newNode;
        } else {
            back.prev = newNode;
            back = newNode;
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T data = front.data;
        front = front.prev;
        if (front == null) {
            back = null;
        }
        return data;
    }

    public void enqueueAll(Queue<T> queue) {
        for (Node<T> node = queue.front; node != null; node = node.prev) {
            enqueue(node.data);
        }
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    private static class Node<T> {
        T data;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.prev = null;
        }
    }

}
