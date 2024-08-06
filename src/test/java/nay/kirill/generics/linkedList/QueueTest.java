package nay.kirill.generics.linkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    @Test
    void testEnqueueAndDequeue() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");

        assertEquals("One", queue.dequeue());
        assertEquals("Two", queue.dequeue());
        assertEquals("Three", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testPeek() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");

        assertEquals("One", queue.peek());
        assertEquals("One", queue.peek());
    }

    @Test
    void testIsEmpty() {
        Queue<String> queue = new Queue<>();

        assertTrue(queue.isEmpty());

        queue.enqueue("Element");

        assertFalse(queue.isEmpty());
    }

    @Test
    void testCount() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");

        assertEquals(2, queue.count((value) -> value.contains("T")));
    }

    @Test
    public void testEnqueueAll() {
        Queue<String> queue1 = new Queue<>();

        queue1.enqueue("One");
        queue1.enqueue("Two");

        Queue<String> queue2 = new Queue<>();

        queue2.enqueue("Three");
        queue2.enqueue("Four");

        queue1.enqueueAll(queue2);
        assertEquals("One", queue1.dequeue());
        assertEquals("Two", queue1.dequeue());
        assertEquals("Three", queue1.dequeue());
        assertEquals("Four", queue1.dequeue());
    }

    @Test
    public void testEnqueueAllWithSubtypes() {
        Queue<Animal> animalQueue = new Queue<>();
        Animal animal1 = new Animal("Animal1");
        Dog dog1 = new Dog("Dog1");
        animalQueue.enqueue(animal1);
        animalQueue.enqueue(dog1);

        Queue<Dog> dogQueue = new Queue<>();
        Dog dog2 = new Dog("Dog2");
        Dog dog3 = new Dog("Dog3");
        dogQueue.enqueue(dog2);
        dogQueue.enqueue(dog3);

        animalQueue.enqueueAll(dogQueue);

        assertEquals(animal1, animalQueue.dequeue());
        assertEquals(dog1, animalQueue.dequeue());
        assertEquals(dog2, animalQueue.dequeue());
        assertEquals(dog3, animalQueue.dequeue());
        assertTrue(animalQueue.isEmpty());
    }

    @Test
    void testDequeueEmptyQueue() {
        Queue<String> queue = new Queue<>();
        assertNull(queue.dequeue());
    }

}
