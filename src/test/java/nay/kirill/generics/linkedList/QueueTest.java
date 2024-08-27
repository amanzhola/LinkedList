package nay.kirill.generics.linkedList;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    @Test
    public void testEnqueue() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");

        assertEquals("1", queue.dequeue());
        assertEquals("2", queue.dequeue());
        assertEquals("3", queue.dequeue());
    }

    @Test
    public void testPeek() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("1932479");
        queue.enqueue("21324324");
        queue.enqueue("3132434");

        assertEquals("1", queue.peek());
        assertEquals("1", queue.peek());
    }

    @Test
    public void testSize() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("1");
        queue.enqueue("2");

        assertEquals(2, queue.size());

        queue.enqueue("3");

        assertEquals(3, queue.size());
    }

    @Test
    public void isEmpty() {
        Queue<String> queue = new Queue<>();

        assertTrue(queue.isEmpty());

        queue.enqueue("1");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testCount() {
        Queue<String> queue = new Queue<>();

        queue.enqueue("Кирилл");
        queue.enqueue("Катя");
        queue.enqueue("Петя");

        int result = queue.count((String object) -> object.charAt(0) == 'К');
        assertEquals(2, result);
    }

    @Test
    public void testEnqueueAll() {
        Queue<Object> queue1 = new Queue<>();
        Queue<String> queue2 = new Queue<>();

        queue1.enqueue("Кирилл");
        queue1.enqueue("Катя");

        queue2.enqueue("Аня");
        queue2.enqueue("Вика");

        queue1.enqueueAll(queue2);

        assertEquals("Кирилл", queue1.dequeue());
        assertEquals("Катя", queue1.dequeue());
        assertEquals("Аня", queue1.dequeue());
        assertEquals("Вика", queue1.dequeue());
    }

}
