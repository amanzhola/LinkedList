package nay.kirill.generics.linkedList;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Метод добавления элемента в конец списка
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Метод удаления элемента из списка
    public boolean remove(T element) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(element)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next; // Удаляем голову
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev; // Удаляем хвост
                }
                size--;
                return true; // Элемент успешно удален
            }
            current = current.next;
        }
        return false; // Элемент не найден
    }

    // Метод получения размера списка
    public int size() {
        return size;
    }

    // Метод получения элемента по индексу
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // Метод объединения с другим списком
    public void addAll(LinkedList<? extends T> other) {
        Node<? extends T> current = other.head;
        while (current != null) {
            this.add(current.data);
            current = current.next;
        }
    }

    // Переопределение метода toString() для отображения содержимого списка
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }
}
/*
Ваш вопрос касается двух схожих, но всё же немного различающихся версий класса `LinkedList`.
Давайте подробно рассмотрим основные отличия между двумя версиями:

### 1. Метод `addAll`

В первой версии код метода `addAll` выглядит так:
```java
public void addAll(LinkedList<? extends T> other) {
    Node<? extends T> current = other.head;
    while (current != null) {
        this.add(current.data);
        current = current.next;
    }
}
```
Во второй версии код этого же метода выглядит так:
```java
public void addAll(LinkedList<? extends T> other) {
    Node<T> current = other.head;
    while (current != null) {
        this.add(current.data);
        current = current.next;
    }
}
```

**Разница**:
- В первой версии используется `Node<? extends T> current`, в то время как во второй — `Node<T> current`.
- Это может вызвать вопросы при компиляции, если `other` содержит элементы с типами,
которые не могут быть безопасно приведены к типу `T`. В общем, использование `Node<? extends T>`
— это более безопасный подход,
так как он позволяет обработать любые подтипы, которые могут находиться в `other`.

### 2. Переопределение метода `toString`

В обеих версиях метод `toString` реализован идентично, что означает, что они оба создают строковое представление списка.
Различий в них нет.

### 3. Отсутствие метода `get`

Ваши предложенные классы не содержат метода `get(int index)`. Ваша предыдущая версия содержала метод получения элемента
по индексу, который был полезен для работы с вашими тестами. Если в тестах используется `get`,
то вы должны вернуть этот метод в реализацию класса `LinkedList`.

### 4. Исключения и обработка ошибок

В первой версии обработки исключений нет, особенно в методе `get`. Если индекс не будет найден,
 следует выбрасывать исключение, например, `IndexOutOfBoundsException`, для обработки ошибок. Эта логика была присутствовала в предыдущей реализации, но пропущена в тексте вашего вопроса.

### Общие рекомендации

1. **Использование Wildcards**: Убедитесь, что вы понимаете, как использовать wildcard-синтаксис `? extends T`
в обобщенных методах. Это позволяет использовать элементы подтипа в списках.

2. **Единообразие**: Если вы используете определенные методы, такие как `get`, убедитесь, что они присутствуют
в вашем классе для поддержки всех тестов.

3. **Проверка на наличие ошибок**: Убедитесь, что классы, которые вы используете для тестов, могут вызывать исключения,
когда это необходимо, что улучшает надежность вашего кода.

4. **Корректная обработка перекрывающих методов**: Если вы решите переопределять методы, такие как `toString`,
убедитесь, что они отражают текущее состояние вашего списка.

### Итог

Разобравшись в различиях, вы сможете понимать, как ваша реализация может быть улучшена для работы
со всеми вашими тестами и сценариями. Надеюсь, это поможет вам улучшить ваш код и сделать его более чистым и безопасным.



 */