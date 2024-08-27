package nay.kirill.generics.linkedList;

public class Queue<T> {

    private Node front = null;

    private Node back = null;

    private int size;

    // Добавление элемента в очередь
    public void enqueue(T value) {
        size++;
        Node node = new Node(value);

        if (front == null) {
            front = node;
        } else {
            back.prev = node;
        }
        back = node;
    }

    // Получение и удаление элемента из очереди
    public T dequeue() {
        if(front == null) {
            return null;
        }

        T value = front.value;
        front = front.prev;
        size--;

        return value;
    }

    // Получение первого элемента в очереди
    public T peek() {
        if (front == null) {
            return null;
        }

        return front.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int count(Predicate<T> predicate) {
        int counter = 0;
        for (Queue<T>.Node node = front; node != null; node = node.prev) {
            T value = node.value;
            if (predicate.check(value)) {
                counter++;
            }
        }
        return counter;
    }

    public void enqueueAll(Queue<? extends T> queue) {
        for (Queue<? extends T>.Node node = queue.front; node != null; node = node.prev) {
            T value = node.value;
            enqueue(value);
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
