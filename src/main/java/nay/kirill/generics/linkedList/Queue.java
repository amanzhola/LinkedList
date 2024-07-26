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

    // Отрабатываем wildcard'ы
    public void enqueueAll(Queue<? extends T> queue) {
        for (Node<? extends T> node = queue.front; node != null; node = node.prev) {
            enqueue(node.data);
        }
    }

    // Отрабатываем лямбды
    public int count(Predicate<T> predicate) {
        int count = 0;
        for (Node<T> node = front; node != null; node = node.prev) {
            if (predicate.compare(node.data)) {
                count++;
            }
        }

        return count;
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
