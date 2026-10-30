package exercise11;

/**
 * Combines two CardSource objects.
 *
 * <p>It draws from source 1 while source 1 is not empty. Once source 1 is
 * empty, it draws from source 2.</p>
 */
public class BiCardSource implements CardSource {
    private final CardSource aSource1;
    private final CardSource aSource2;

    public BiCardSource(CardSource pSource1, CardSource pSource2) {
        aSource1 = pSource1;
        aSource2 = pSource2;
    }

    /**
     * Draws from source 1 if it is not empty, otherwise from source 2.
     */
    @Override
    public Card draw() {
        if (!aSource1.isEmpty()) {
            return aSource1.draw();
        } else {
            return aSource2.draw();
        }
    }

    /**
     * The combined source is empty only when both underlying sources are empty.
     */
    @Override
    public boolean isEmpty() {
        return aSource1.isEmpty() && aSource2.isEmpty();
    }
}
