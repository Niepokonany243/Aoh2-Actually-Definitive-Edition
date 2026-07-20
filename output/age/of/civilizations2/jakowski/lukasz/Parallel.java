package age.of.civilizations2.jakowski.lukasz;

import java.util.function.IntConsumer;

public class Parallel {
    private static final int THRESHOLD = 64;
    public static void range(int startInclusive, int endExclusive, IntConsumer action) {
        GameTaskScheduler.parallelRange(startInclusive, endExclusive, THRESHOLD, action);
    }

    public static void range(int endExclusive, IntConsumer action) {
        range(0, endExclusive, action);
    }

}
