package quickTests;

import org.junit.Test;

public class TestComparator {

    MyComparator<Integer> mC = new MyComparator<Integer>() {
        @Override
        public Integer compare(Integer a, Integer b) {
            return null;
        }
    };
    double a,b;

    @Test
    public void halp() {
        MyComparator<Double> mCLambda = (a,b) -> null;
    }
}
