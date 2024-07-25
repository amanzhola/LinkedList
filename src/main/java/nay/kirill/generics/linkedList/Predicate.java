package nay.kirill.generics.linkedList;

@FunctionalInterface
public interface Predicate<T> {

    boolean compare(T object);

}