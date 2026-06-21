package age.of.civilizations2.jakowski.lukasz;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.function.IntConsumer;

public class Parallel {
    private static final int THRESHOLD = 64;
    private static final ForkJoinPool pool = new ForkJoinPool(
        Math.max(1, Runtime.getRuntime().availableProcessors() * 2)
    );

    public static void range(int startInclusive, int endExclusive, IntConsumer action) {
        if (endExclusive - startInclusive <= THRESHOLD) {
            for (int i = startInclusive; i < endExclusive; i++) {
                action.accept(i);
            }
            return;
        }
        pool.invoke(new RangeAction(startInclusive, endExclusive, action));
    }

    public static void range(int endExclusive, IntConsumer action) {
        range(0, endExclusive, action);
    }

    public static ForkJoinPool getPool() {
        return pool;
    }

    private static class RangeAction extends RecursiveAction {
        private final int start;
        private final int end;
        private final IntConsumer action;

        RangeAction(int start, int end, IntConsumer action) {
            this.start = start;
            this.end = end;
            this.action = action;
        }

        @Override
        protected void compute() {
            int length = end - start;
            if (length <= THRESHOLD) {
                for (int i = start; i < end; i++) {
                    action.accept(i);
                }
            } else {
                int mid = start + (length / 2);
                invokeAll(
                    new RangeAction(start, mid, action),
                    new RangeAction(mid, end, action)
                );
            }
        }
    }
}
