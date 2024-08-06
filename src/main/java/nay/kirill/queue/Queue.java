package nay.kirill.queue;

public class Queue<T> {

    Node front = null;
    Node back = null;

    private int size = 0;

    // Добавление значения в очередь
    public void enqueue(T data) {
        Node newNode = new Node(data);

        if (front == null) {
            front = newNode;
        } else {
            back.prev = newNode;
        }

        back = newNode;
        size++;
    }

    // Удаление значения из очереди
    public T dequeue() {
        if (front == null) {
            return null;
        }

        T data = front.value;

        front = front.prev;

        size--;
        return data;
    }

    public T peek() {
        if (front == null) {
            return null;
        }

        return front.value;
    }

    public int size() {
        return size;
    }

    public int count(Predicate<T> predicate) {
        int count = 0;
        for (Queue<T>.Node node = front; node != null; node = node.prev) {
            if (predicate.isValid(node.value)) {
                count++;
            }
        }

        return count;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueueAll(Queue<? extends T> queue) {
        for (Queue<? extends T>.Node node = queue.front; node != null; node = node.prev) {
            enqueue(node.value);
        }
    }

    private class Node {

        T value;
        Node prev;

        Node(T value) {
            this.value = value;
            prev = null;
        }

    }

}
