package nay.kirill.generics.linkedList;

public class Main {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");

        String first = queue.dequeue();
        if (first.equals("1")) {
            System.out.println("Верно");
        } else {
            System.out.println("Ошибка!");
        }
    }

}
