package quickTests;

@FunctionalInterface
public interface MyComparator<T> {
    T compare(T a,T b);
}
