package nay.kirill.queue;

@FunctionalInterface
public interface Predicate<M> {

    boolean isValid(M data);

}