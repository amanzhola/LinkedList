package nay.kirill.generics.linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    private Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new Queue<>();
    }

    @Test
    void testEnqueueAndDequeue() {
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
        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");

        assertEquals("One", queue.peek());
        assertEquals("One", queue.peek());
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty());

        queue.enqueue("Element");

        assertFalse(queue.isEmpty());
    }

    @Test
    void testCount() {
        queue.enqueue("One");
        queue.enqueue("Two");
        queue.enqueue("Three");

        assertEquals(2, queue.count((value) -> value.contains("T")));
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
        assertNull(queue.dequeue());
    }

}
