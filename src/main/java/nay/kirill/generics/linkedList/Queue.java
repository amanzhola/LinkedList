package nay.kirill.generics.linkedList;

public class Queue<T> {
    private Node front;
    private Node back;

    public void enqueue(T element) {
        Node newNode = new Node(element);
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
        for (Queue<? extends T>.Node node = queue.front; node != null; node = node.prev) {
            enqueue(node.data);
        }
    }

    // Отрабатываем лямбды
    public int count(Predicate<T> predicate) {
        int count = 0;
        for (Node node = front; node != null; node = node.prev) {
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

    private class Node {
        T data;
        Node prev;

        Node(T data) {
            this.data = data;
            this.prev = null;
        }
    }

}
