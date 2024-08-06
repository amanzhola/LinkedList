package nay.kirill.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    @Test
    public void testEnqueue() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        assertEquals("First", queue.dequeue());
        assertEquals("Second", queue.dequeue());
        assertEquals("Third", queue.dequeue());
    }

    @Test
    public void testPeek() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        assertEquals("First", queue.peek());
        assertEquals("First", queue.peek());
    }

    @Test
    public void testSize() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("First");
        queue.enqueue("Second");
        queue.enqueue("Third");

        assertEquals(3, queue.size());

        queue.dequeue();

        assertEquals(2, queue.size());
    }

    @Test
    public void testIsEmpty() {
        Queue<String> queue = new Queue<>();

        assertTrue(queue.isEmpty());
        queue.enqueue("Test");

        assertFalse(queue.isEmpty());
    }

    @Test
    public void testEnqueueAll() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("First");
        queue.enqueue("Second");

        Queue<String> queue2 = new Queue<>();

        queue2.enqueue("1");
        queue2.enqueue("2");

        queue.enqueueAll(queue2);

        assertEquals("First", queue.dequeue());
        assertEquals("Second", queue.dequeue());

        assertEquals("1", queue.dequeue());
        assertEquals("2", queue.dequeue());
    }

    @Test
    public void testEnqueueSubtypes() {
        Queue<Animal> animals = new Queue<>();

        animals.enqueue(new Animal("Animal1"));
        animals.enqueue(new Dog("Dog1"));

        Queue<Dog> dogs = new Queue<>();

        dogs.enqueue(new Dog("Dog2"));
        dogs.enqueue(new Dog("Dog3"));

        animals.enqueueAll(dogs);
    }

    @Test
    public void testCount() {
        Queue<Animal> animals = new Queue<>();

        animals.enqueue(new Animal("Animal1"));
        animals.enqueue(new Dog("Dog1"));
        animals.enqueue(new Dog("Dog2"));
        animals.enqueue(new Dog("Dog3"));
        animals.enqueue(new Animal("Animal2"));

        int dogsCount = animals.count((data) -> data instanceof Dog);

        assertEquals(3, dogsCount);
    }

}
