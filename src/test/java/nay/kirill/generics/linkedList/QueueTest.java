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
        assertEquals("One", queue.peek()); // Peeking should not remove the element
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
    void testDequeueEmptyQueue() {
        assertNull(queue.dequeue());
    }

}
