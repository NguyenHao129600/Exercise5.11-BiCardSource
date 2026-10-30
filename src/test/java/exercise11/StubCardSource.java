package exercise11;

/**
 * Controllable test stub for CardSource.
 *
 * <p>The empty state and returned card are supplied by the test. Small call
 * counters are included so tests can also verify delegation and short-circuit
 * behavior without relying on a real deck.</p>
 */
final class StubCardSource implements CardSource {
    private final boolean empty;
    private final Card cardToReturn;
    private int drawCallCount;
    private int isEmptyCallCount;

    StubCardSource(boolean empty, Card cardToReturn) {
        this.empty = empty;
        this.cardToReturn = cardToReturn;
    }

    @Override
    public Card draw() {
        drawCallCount++;
        return cardToReturn;
    }

    @Override
    public boolean isEmpty() {
        isEmptyCallCount++;
        return empty;
    }

    int getDrawCallCount() {
        return drawCallCount;
    }

    int getIsEmptyCallCount() {
        return isEmptyCallCount;
    }
}
